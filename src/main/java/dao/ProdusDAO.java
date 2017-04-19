package dao;

import connection.ConnectionFactory;
import model.Produs;

import java.sql.*;

/**
 * Created by Andrei on 18/04/2017.
 */
public class ProdusDAO {

    private final static String findStatementString;
    private static final String insertStatementString;
    private static final String updateStatementString;
    private static final String deleteStatementStringProdus;
   // private static final String showAllStatementString;

    static{
        findStatementString = "SELECT * FROM produs where id=?";
         insertStatementString = "insert into produs(descriere,cantitate,pret)"+" VALUES (?,?,?)";
        updateStatementString = "update produs"+" set descriere=?,cantitate=?,pret=? where id=?";
        deleteStatementStringProdus = "delete from produs"+" where id=?";
        //showAllStatementString = "select * from produs";
    }

    public static Produs findById(int produsId){
        Produs toReturn=null;
        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement findStatement=null;
        ResultSet rs=null;


        try {
            findStatement=dbConnection.prepareStatement(findStatementString);
            findStatement.setInt(1,produsId);
            rs=findStatement.executeQuery();
            rs.next();
            String descriere=rs.getString("descriere");
            int cantitate=rs.getInt("cantitate");
            int pret=rs.getInt("pret");
            toReturn=new Produs(produsId,descriere,cantitate,pret);


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }

        return toReturn;

    }

    public static int insert(Produs produs){

        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement insertStatement=null;
        int insertedId=-1;


        try {
            insertStatement=dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);

            insertStatement.setString(1,produs.getDescriere());
            insertStatement.setInt(2,produs.getCantitate());
            insertStatement.setFloat(3,produs.getPret());

            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }

        return insertedId;
    }

    public static void update(Produs produs){

        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement updateStatement=null;
        // int insertedId=-1;


        try {
            updateStatement=dbConnection.prepareStatement(updateStatementString);

            updateStatement.setString(1,produs.getDescriere());
            updateStatement.setInt(2,produs.getCantitate());
            updateStatement.setFloat(3,produs.getPret());

            updateStatement.executeUpdate();



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.close(updateStatement);
            ConnectionFactory.close(dbConnection);
        }


    }

    public static void deleteProdus(Produs produs){

        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement deleteStatementProdus=null;
        // int insertedId=-1;


        try {
            deleteStatementProdus=dbConnection.prepareStatement(deleteStatementStringProdus);

            deleteStatementProdus.setInt(1,produs.getId());

            deleteStatementProdus.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }finally {
            ConnectionFactory.close(deleteStatementProdus);
            ConnectionFactory.close(dbConnection);
        }


    }
}
