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


    static {
        insertStatementString="insert into cos(pret_total,client_id,data_creare,comanda_finalizata)" + " VALUES (0,(select id from clienti where logat=true),?,false)";
        adaugaInCosString="Update cos set pret_total=pret_total+? where comanda_finalizata=false";
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

    public static void adaugaInCos(int produsId,int cantitate)
    {
        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement adaugaInCosStatement=null;
        PreparedStatement getIdCosStatement=null;
        ResultSet rs=null;

        try{
            adaugaInCosStatement=dbConnection.prepareStatement(adaugaInCosString);
            getIdCosStatement=dbConnection.prepareStatement(getIdCosString);
            Produs produs=ProdusDAO.findById(produsId);
            float pret=produs.getPret();
            rs=getIdCosStatement.executeQuery();
            if(rs.next())
            {   ComandaBLL comandaBLL=new ComandaBLL();
                comandaBLL.insert(produsId,cantitate,rs.getInt("id"));}
            else throw new IllegalArgumentException("Nu exista un cos gol creat!");

            adaugaInCosStatement.setFloat(1,pret*cantitate);
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
