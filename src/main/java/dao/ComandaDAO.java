package dao;

import bll.CosBLL;
import bll.ProdusBLL;
import connection.ConnectionFactory;
import model.ComandaArticol;
import model.Cos;
import model.Produs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Andrei on 20/04/2017.
 */
public class ComandaDAO {

    private static final String insertString;
    private static final String veziComenziString;
    private static final String detaliiComenziString;
    private static final String stergeComandaString;
    private static final String modificaComandaString;
    private static final String cautaComandaString;
    //private static final String getProdus;

    static{
        insertString="insert into comanda_articol(cos_id,produs_id,cantitate,pret_bucata) values(?,?,?,?);";
        veziComenziString="select id,cantitate,pret_bucata,produs_id from comanda_articol where cos_id=(select id from cos where comanda_finalizata=false and client_id=(select id from clienti where logat=true))";
        detaliiComenziString="select descriere from produs where id=?";
        cautaComandaString="select cos_id,produs_id,cantitate,pret_bucata from comanda_articol where id=?";
        stergeComandaString="delete from comanda_articol where id=?";
        modificaComandaString="update comanda_articol set cantitate=? where id=?";
    }

    public static void insert(int produsId,int cantitate,int cosId)
    {Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement insertStatement=null;

        try{
            insertStatement=dbConnection.prepareStatement(insertString);


            Produs produs=ProdusDAO.findById(produsId);
            float pret=produs.getPret();
            insertStatement.setInt(1,cosId);
            insertStatement.setInt(2,produsId);
            insertStatement.setInt(3,cantitate);
            insertStatement.setFloat(4,pret);

            insertStatement.executeUpdate();

            produs.setCantitate(produs.getCantitate()-cantitate);
            ProdusDAO.update(produs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static ComandaArticol findById(int comandaId){
        ComandaArticol toReturn=null;
        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement findStatement=null;
        ResultSet rs=null;


        try {
            findStatement=dbConnection.prepareStatement(cautaComandaString);
            findStatement.setInt(1,comandaId);
            rs=findStatement.executeQuery();
            rs.next();
            int cosId=rs.getInt("cos_id");
            int cantitate=rs.getInt("cantitate");
            float pret=rs.getFloat("pret_bucata");
            int produsId=rs.getInt("produs_id");
            toReturn=new ComandaArticol(comandaId, cosId,produsId,cantitate,pret);


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }

        return toReturn;

    }

    public static void stergeComanda(int idComanda)
    {
        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement stergeComandaStatement=null;
        ComandaArticol comanda=findById(idComanda);
        Produs produs;
        Cos cos;
        ProdusBLL produsBLL=new ProdusBLL();
        CosBLL cosBLL=new CosBLL();
        ResultSet rs=null;

        try{
            stergeComandaStatement=dbConnection.prepareStatement(stergeComandaString);


            // Produs produs=ProdusDAO.findById(produsId);
            stergeComandaStatement.setInt(1,idComanda);
            stergeComandaStatement.executeUpdate();
            produs=ProdusDAO.findById(comanda.getProdus_id());
            produs.setCantitate(produs.getCantitate()+comanda.getCantitate());
            produsBLL.update(produs);
            cos=CosDAO.findById(comanda.getCos_id());
            cosBLL.setPretCos(comanda.getCos_id(),cos.getPretTotal()-comanda.getCantitate()*comanda.getPret_bucata());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void modificaComanda(int idComanda,int cantitate)
    {
        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement modificaComandaStatement=null;
        ComandaArticol comanda=findById(idComanda);
        Produs produs;
        Cos cos;
        ProdusBLL produsBLL=new ProdusBLL();
        CosBLL cosBLL=new CosBLL();


        try{
            modificaComandaStatement=dbConnection.prepareStatement(modificaComandaString);


            // Produs produs=ProdusDAO.findById(produsId);
            modificaComandaStatement.setInt(1,cantitate);
            modificaComandaStatement.setInt(2,idComanda);
            modificaComandaStatement.executeUpdate();
            cos=CosDAO.findById(comanda.getCos_id());
            produs=ProdusDAO.findById(comanda.getProdus_id());
            if(cantitate-comanda.getCantitate()>produs.getCantitate())
                throw new IllegalArgumentException("Nu avem atat de multe produse in plus pe stoc!");
            if(cantitate>=comanda.getCantitate())
                {
                produs.setCantitate(produs.getCantitate()-(cantitate-comanda.getCantitate()));
                cosBLL.setPretCos(comanda.getCos_id(),cos.getPretTotal()+(cantitate-comanda.getCantitate())*comanda.getPret_bucata());
                }
            else
                {
                    produs.setCantitate(produs.getCantitate()+(comanda.getCantitate()-cantitate));
                    cosBLL.setPretCos(comanda.getCos_id(),cos.getPretTotal()-(comanda.getCantitate()-cantitate)*comanda.getPret_bucata());
                }
            produsBLL.update(produs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String[]> veziComenzi()
    {Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement veziComenziStatement=null;
        PreparedStatement detaliiComenziStatement=null;
        ResultSet rs=null;
        ResultSet rs2=null;
        ArrayList<String[]> elemente=new ArrayList<String[]>();

        try{
            veziComenziStatement=dbConnection.prepareStatement(veziComenziString);
            detaliiComenziStatement=dbConnection.prepareStatement(detaliiComenziString);


            rs=veziComenziStatement.executeQuery();

            while (rs.next())
            {

                detaliiComenziStatement.setInt(1,rs.getInt("produs_id"));
                rs2=detaliiComenziStatement.executeQuery();
                rs2.next();
                String descriere=rs2.getString("descriere");
                String[] date={Integer.toString(rs.getInt("id")),descriere,Integer.toString(rs.getInt("cantitate")),Integer.toString(rs.getInt("pret_bucata"))};
                elemente.add(date);


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return elemente;
    }


}
