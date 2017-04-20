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
public class ExistaUsernameValidator implements Validator<Client> {

    private static final String usernameString;

    static {
        usernameString = "select username from clienti";
    }

    public void validate(Client t) {

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement usernameStatement;

        try {
            usernameStatement = dbConnection.prepareStatement(usernameString);
            int ok=0;
            ResultSet rs = usernameStatement.executeQuery();

            while (rs.next()) {
                String username = rs.getString("username");
                if(username.equals(t.getUsername()))
                {ok=1;
                break;}
            }

            if(ok==0)
                throw new IllegalArgumentException("Nu exista acest username!");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
