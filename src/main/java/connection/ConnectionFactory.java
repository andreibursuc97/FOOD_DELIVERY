package connection;

import java.sql.*;
import java.util.logging.Logger;

/**
 * Created by Andrei on 18/04/2017.
 */
public class ConnectionFactory  {
    private static final Logger LOGGER=Logger.getLogger(ConnectionFactory.class.getName());
    private static final String DRIVER="com.mysql.cj.jdbc.Driver";
    private static final String DBURL="jdbc:mysql://localhost:3306/food_delivery";
    private static final String USER="root";
    private static final String PASS="and5544";
    private static ConnectionFactory singleInstance=new ConnectionFactory();

    private ConnectionFactory(){
        try{
            Class.forName(DRIVER);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    private Connection createConnection()
    {
        Connection connection=null;
        try {
            connection=DriverManager.getConnection(DBURL,USER,PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;

    }

    public static Connection getConnection()
    {
       return singleInstance.createConnection();
    }

    public static void close(Connection connection)  {

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement statement)  {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void close(ResultSet resultSet) {
        try {
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
