package dao;

import model.Client;
import connection.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Andrei on 18/04/2017.
 * clasa lcient
 */
public class ClientDAO {

    private final static String findStatementString;
    private static final String insertStatementString;
    private static final String updateStatementString;
    private static final String deleteStatementString;
    private static final String logareString;
    private static final String delogareString;
    private static final String findIdString;
    private static final String showAllString;

    //private static final String logareStatementString;

    static {
        findStatementString = "SELECT * FROM clienti where id=?";
        insertStatementString = "insert into clienti(username,nume,adresa,email,varsta,parola)"+" VALUES (?,?,?,?,?,?)";
        updateStatementString = "update clienti"+" set nume=?,adresa=?,email=?,varsta=?,parola=? where id=?";
        deleteStatementString = "delete from clienti"+" where id=?";
        logareString="update clienti set logat=true where username=?";
        delogareString="update clienti set logat=false where logat=true";
        findIdString="select id from clienti where logat=true";
        showAllString="select id,username,nume,adresa,email,varsta from clienti";
    }



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
            String username=rs.getString("username");
            String nume=rs.getString("nume");
            String adresa=rs.getString("adresa");
            String email=rs.getString("email");
            int varsta=rs.getInt("varsta");
            String parola=rs.getString("parola");
            toReturn=new Client(clientId,username,nume,adresa,email,varsta,parola);


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }

        return toReturn;

    }

    public static int findIdClientLogat()
    {
        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement findStatement=null;
        ResultSet rs=null;
        int toReturn=-1;
        try {
            findStatement = dbConnection.prepareStatement(findIdString);

            rs = findStatement.executeQuery();
            rs.next();
            toReturn=rs.getInt("id");
        }catch (SQLException e) {
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

            insertStatement.setString(1,client.getUsername());
            insertStatement.setString(2,client.getNume());
            insertStatement.setString(3,client.getAdresa());
            insertStatement.setString(4,client.getEmail());
            insertStatement.setInt(5,client.getVarsta());
            insertStatement.setString(6,client.getParola());

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
            updateStatement.setInt(6,client.getId());
            updateStatement.setString(5,client.getParola());
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


    public static void logare(String username,String parola){

        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement logareStatement=null;
        try{
            logareStatement=dbConnection.prepareStatement(logareString);

            logareStatement.setString(1,username);

            logareStatement.executeUpdate();


        }catch(SQLException e)
        {e.printStackTrace();
        }finally {
            ConnectionFactory.close(logareStatement);
            ConnectionFactory.close(dbConnection);
        }

    }

    public static void delogare(){

        Connection dbConnection= ConnectionFactory.getConnection();

        PreparedStatement delogareStatement=null;
        try{

            delogareStatement=dbConnection.prepareStatement(delogareString);
            //delogareStatement.setString(1,username);

            delogareStatement.executeUpdate();


        }catch(SQLException e)
        {e.printStackTrace();
        }finally {
            ConnectionFactory.close(delogareStatement);
            ConnectionFactory.close(dbConnection);
        }

    }

    public static ArrayList<String[]> showAll()
    {
        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement showAllStatement=null;
        ResultSet rs=null;
        ArrayList<String[]> elemente=new ArrayList<String[]>();
        String[] dateTabel=null;
        try {
            showAllStatement=dbConnection.prepareStatement(showAllString);

            rs=showAllStatement.executeQuery();

            while(rs.next())
            {
                dateTabel=new String[]{Integer.toString(rs.getInt("id")),rs.getString("username"),rs.getString("nume"),rs.getString("adresa"),rs.getString("email"),Integer.toString(rs.getInt("varsta"))};
                elemente.add(dateTabel);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.close(showAllStatement);
            ConnectionFactory.close(dbConnection);
        }
        return elemente;
    }
}
