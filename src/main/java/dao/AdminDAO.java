package dao;

import connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminDAO {

    private static final String logareAdminString;
    private static final String delogareAdminString;

    static
    {
        logareAdminString="update admin set logat=true where username=?";
        delogareAdminString="update admin set logat=false where logat=true";
    }

    public static void logare(String username,String parola){

        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement logareAdminStatement=null;
        try{
            logareAdminStatement=dbConnection.prepareStatement(logareAdminString);

            logareAdminStatement.setString(1,username);

            logareAdminStatement.executeUpdate();


        }catch(SQLException e)
        {e.printStackTrace();
        }finally {
            ConnectionFactory.close(logareAdminStatement);
            ConnectionFactory.close(dbConnection);
        }

    }

    public static void delogare(){

        Connection dbConnection= ConnectionFactory.getConnection();

        PreparedStatement delogareAdminStatement=null;
        try{

            delogareAdminStatement=dbConnection.prepareStatement(delogareAdminString);
            //delogareStatement.setString(1,username);

            delogareAdminStatement.executeUpdate();


        }catch(SQLException e)
        {e.printStackTrace();
        }finally {
            ConnectionFactory.close(delogareAdminStatement);
            ConnectionFactory.close(dbConnection);
        }

    }
}
