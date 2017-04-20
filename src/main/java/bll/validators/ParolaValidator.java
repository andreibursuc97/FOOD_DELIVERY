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
public class ParolaValidator implements Validator<Client> {

    private static final String parolaString;

    static {
        parolaString = "select parola from clienti where username=?";
    }

    public void validate(Client t) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement parolaStatement=null;

        try{
            parolaStatement=dbConnection.prepareStatement(parolaString);
            parolaStatement.setString(1,t.getUsername());
            ResultSet rs=parolaStatement.executeQuery();
            if(rs.next()) {
                if (!t.getParola().equals(rs.getString("parola")))
                    throw new IllegalArgumentException("Ati introdus o parola gresita!");
            }
            //else throw new IllegalArgumentException("Ati introdus o parola gresita!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
