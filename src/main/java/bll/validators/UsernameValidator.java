package bll.validators;

import connection.ConnectionFactory;
import model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Andrei on 20/04/2017.
 * verifica daca nu exista deja usernameul
 */
public class UsernameValidator implements Validator<Client> {

    private static final String usernameString;

    static {
        usernameString = "select username from clienti";
    }


    public void validate(Client t) {

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement usernameStatement;

        try {
            usernameStatement = dbConnection.prepareStatement(usernameString);

            ResultSet rs = usernameStatement.executeQuery();

            while (rs.next()) {
                String username = rs.getString("username");
                if (t.getUsername().equals(username))
                    throw new IllegalArgumentException("Useername-ul exista deja");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
