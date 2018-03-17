package dao;

import bll.ComandaBLL;
import connection.ConnectionFactory;
import model.Cos;
import model.Produs;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Andrei on 20/04/2017.
 * metode cos
 */
public class CosDAO {

    private static final String insertStatementString;
    private static final String adaugaInCosString;
    private static final String getIdCosString;
    private static final String finalizareComandaString;
    private static final String pretCosString;
    private static final String dateCosString;
    private static final String dateCos2String;
    private static final String sumString;
    private static final String updatePretCosString;
    private static final String cautaCosString;


    static {
        insertStatementString="insert into cos(pret_total,client_id,data_creare,comanda_finalizata)" + " VALUES (0,(select id from clienti where logat=true),?,false)";
        adaugaInCosString="Update cos set pret_total=? where comanda_finalizata=false";
        sumString="select sum(pret_bucata*cantitate) from comanda_articol where cos_id=(select max(id) from cos)";
        updatePretCosString="update cos set pret_total=? where id=?";
        cautaCosString="select pret_total,client_id,data_creare,comanda_finalizata from cos where id=?";
        getIdCosString="select Id from cos where comanda_finalizata=false and client_id=(select id from clienti where logat=true)";
        finalizareComandaString="update cos set comanda_finalizata=true where comanda_finalizata=false and client_id=(select id from clienti where logat=true)";
        pretCosString="Select pret_total from cos where comanda_finalizata=false and client_id=(select id from clienti where logat=true)";
        dateCosString="Select id,client_id,data_creare,pret_total from cos where comanda_finalizata=false and client_id=(select id from clienti where logat=true)";
        dateCos2String="Select id,client_id,data_creare,pret_total from cos where comanda_finalizata=true and client_id=(select id from clienti where logat=true)";

    }

    public static int insert(Cos cos)
    {
        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement insertStatement=null;
        int insertedId=-1;

        try{
            insertStatement=dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);

            DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            //String inputText = "2012-11-17T00:00:00-05:00";
            Date date = new Date();

            insertStatement.setString(1,outputFormat.format(date));

            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }

        }catch(SQLException e) {
        e.printStackTrace();

        } finally {
        ConnectionFactory.close(insertStatement);
        ConnectionFactory.close(dbConnection);
    }

        return insertedId;
    }

    public static Cos findById(int cosId){
        Cos toReturn=null;
        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement findStatement=null;
        ResultSet rs=null;


        try {
            findStatement=dbConnection.prepareStatement(cautaCosString);
            findStatement.setInt(1,cosId);
            rs=findStatement.executeQuery();
            rs.next();
            float pretTotal=rs.getFloat("pret_total");
            int clientId=rs.getInt("client_id");
            String data=rs.getString("data_creare");
            //boolean comandaFinalizata=rs.getBoolean("comanda_finalizata");
            toReturn=new Cos(cosId, clientId,data,pretTotal);


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }

        return toReturn;

    }

    public static void adaugaInCos(int produsId,int cantitate)
    {
        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement adaugaInCosStatement=null;
        PreparedStatement getIdCosStatement=null;
        PreparedStatement sumStatement=null;
        ResultSet rs=null;
        ResultSet sum=null;
        float suma=0;

        try{
            adaugaInCosStatement=dbConnection.prepareStatement(adaugaInCosString);
            getIdCosStatement=dbConnection.prepareStatement(getIdCosString);
            sumStatement=dbConnection.prepareStatement(sumString);
            Produs produs=ProdusDAO.findById(produsId);
            float pret=produs.getPret();
            rs=getIdCosStatement.executeQuery();

            if(rs.next())
            {   ComandaBLL comandaBLL=new ComandaBLL();
                comandaBLL.insert(produsId,cantitate,rs.getInt("id"));}
            else throw new IllegalArgumentException("Nu exista un cos gol creat!");
            sum=sumStatement.executeQuery();
            if(sum.next())
            {
                suma=sum.getInt("sum(pret_bucata*cantitate)");
                System.out.println(suma);
            }
            adaugaInCosStatement.setFloat(1,suma);
            adaugaInCosStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static void finalizareComanda()
    {
        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement finalizareComandaStatement=null;
        PreparedStatement dateCosStatement=null;
        ResultSet rs=null;
        try{
            dateCosStatement=dbConnection.prepareStatement(dateCosString);
            rs=dateCosStatement.executeQuery();
            if(rs.next())
            {
                Cos cos=new Cos(rs.getInt("id"),rs.getInt("client_id"),rs.getString("data_creare"),rs.getInt("pret_total"));
                cos.creareFactura();
            }

            finalizareComandaStatement=dbConnection.prepareStatement(finalizareComandaString);
            finalizareComandaStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int pretCos()
    {
        int pret=0;
        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement pretCosStatement=null;
        ResultSet rs=null;
        try{
            pretCosStatement=dbConnection.prepareStatement(pretCosString);
            rs=pretCosStatement.executeQuery();
            if(rs.next())
            pret=rs.getInt("pret_total");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pret;

    }

    public static void setPretCos(int idCos,float pret)
    {
        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement updatePretCosStatement=null;
        try{
            updatePretCosStatement=dbConnection.prepareStatement(updatePretCosString);
            updatePretCosStatement.setFloat(1,pret);
            updatePretCosStatement.setInt(2,idCos);
            updatePretCosStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String[]> veziCosuri()
    {
        String[] dateTabel;
        dateTabel= new String[40];
        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement dateCosStatement=null;
        ResultSet rs=null;
        ArrayList<String[]> elemente=new ArrayList<String[]>();
        try{
            dateCosStatement=dbConnection.prepareStatement(dateCos2String);
            rs=dateCosStatement.executeQuery();
            int i=0;
            while(rs.next())
            {
                dateTabel=new String[]{Integer.toString(rs.getInt("id")),rs.getString("data_creare"),Integer.toString(rs.getInt("pret_total"))};
                elemente.add(dateTabel);
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());

        }finally {
            ConnectionFactory.close(dateCosStatement);
            ConnectionFactory.close(dbConnection);
            ConnectionFactory.close(rs);
        }

        return elemente;
    }

}
