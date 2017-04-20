package dao;

import connection.ConnectionFactory;
import model.Produs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Andrei on 20/04/2017.
 */
public class ComandaDAO {

    private static final String insertString;
    //private static final String getProdus;

    static{
        insertString="insert into comanda_articol(cos_id,produs_id,cantitate,pret_bucata) values(?,?,?,?);";


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
}
