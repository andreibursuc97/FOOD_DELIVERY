package dao;

import connection.ConnectionFactory;
import model.Cos;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Andrei on 20/04/2017.
 * metode cos
 */
public class CosDAO {

    private static final String insertStatementString;
    static {
        insertStatementString="insert into cos(client_id,data_creare)" + " VALUES (?,?)";
    }

    public int insert(Cos cos)
    {
        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement insertStatement=null;
        int insertedId=-1;

        try{
            insertStatement=dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1,cos.getClient_id());

            DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

            //String inputText = "2012-11-17T00:00:00-05:00";
            Date date = new Date();

            insertStatement.setString(2,outputFormat.format(date));

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



}
