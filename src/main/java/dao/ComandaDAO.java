package dao;

import connection.ConnectionFactory;
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
    //private static final String getProdus;

    static{
        insertString="insert into comanda_articol(cos_id,produs_id,cantitate,pret_bucata) values(?,?,?,?);";
        veziComenziString="select id,cantitate,pret_bucata,produs_id from comanda_articol where cos_id=(select id from cos where comanda_finalizata=false and client_id=(select id from clienti where logat=true))";
        detaliiComenziString="select descriere from produs where id=?";
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
