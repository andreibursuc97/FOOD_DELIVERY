package bll.validators;

import connection.ConnectionFactory;
import model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Andrei on 20/04/2017.
 */
public class DejaLogatValidator implements Validator<Client> {



    private static final String clientLogatString;

    static {
        clientLogatString = "select logat from clienti";
    }

    public void validate(Client t) {

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement clientLogatStatement=null;

        try {
            int ok = 1;
            clientLogatStatement = dbConnection.prepareStatement(clientLogatString);

            ResultSet rs = clientLogatStatement.executeQuery();

            while (rs.next()) {
                boolean logat = rs.getBoolean("logat");
                if (logat == true) {
                    ok = 0;
                    break;
                }

            }

            if (ok == 0)
                throw new IllegalArgumentException("Exista deja un client logat!");

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            ConnectionFactory.close(dbConnection);
            ConnectionFactory.close(clientLogatStatement);
        }
    }


}

