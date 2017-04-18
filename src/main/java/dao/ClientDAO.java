package dao;

import model.Client;
import connection.ConnectionFactory;

import java.sql.*;

/**
 * Created by Andrei on 18/04/2017.
 */
public class ClientDAO {

    private final static String findStatementString = "SELECT * FROM clienti where id=?";
    private static final String insertStatementString = "insert into clienti(nume,adresa,email,varsta)"+" VALUES (?,?,?,?)";
    private static final String updateStatementString = "update clienti"+" set nume=?,adresa=?,email=?,varsta=? where id=?";
    private static final String deleteStatementString = "delete from clienti"+" where id=?";
    private static final String showAllStatementString = "select * from clienti";

    public static Client findById(int clientId){
        Client toReturn=null;
        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement findStatement=null;
        ResultSet rs=null;


        try {
            findStatement=dbConnection.prepareStatement(findStatementString);
            findStatement.setInt(1,clientId);
            rs=findStatement.executeQuery();
            rs.next();
            String nume=rs.getString("nume");
            String adresa=rs.getString("adresa");
            String email=rs.getString("email");
            int varsta=rs.getInt("varsta");
            toReturn=new Client(clientId,nume,adresa,email,varsta);


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }

        return toReturn;

    }

    public static int insert(Client client){

        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement insertStatement=null;
        int insertedId=-1;


        try {
            insertStatement=dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);

            insertStatement.setString(1,client.getNume());
            insertStatement.setString(2,client.getAdresa());
            insertStatement.setString(3,client.getEmail());
            insertStatement.setInt(4,client.getVarsta());

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

    public static void update(Client client){

        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement updateStatement=null;
       // int insertedId=-1;


        try {
            updateStatement=dbConnection.prepareStatement(updateStatementString);

            updateStatement.setString(1,client.getNume());
            updateStatement.setString(2,client.getAdresa());
            updateStatement.setString(3,client.getEmail());
            updateStatement.setInt(4,client.getVarsta());
            updateStatement.setInt(5,client.getId());
            updateStatement.executeUpdate();



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.close(updateStatement);
            ConnectionFactory.close(dbConnection);
        }


    }

    public static void delete(Client client){

        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement deleteStatement=null;
        // int insertedId=-1;


        try {
            deleteStatement=dbConnection.prepareStatement(deleteStatementString);

            deleteStatement.setInt(1,client.getId());

            deleteStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }


    }

    public static void showAll()
    {
        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement showAllStatement=null;
        ResultSet rs=null;
        try {
            showAllStatement=dbConnection.prepareStatement(deleteStatementString);

            rs=showAllStatement.executeQuery();

            while(rs.next())
            {

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.close(showAllStatement);
            ConnectionFactory.close(dbConnection);
        }
    }
}
