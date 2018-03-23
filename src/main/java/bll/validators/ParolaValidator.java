package bll.validators;

import connection.ConnectionFactory;
import model.Client;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                byte[] hash = digest.digest(t.getParola().getBytes(StandardCharsets.UTF_8));
                StringBuilder parolaDeVerificat = new StringBuilder();
                StringBuilder parolaUser = new StringBuilder();
                for (byte b : hash) {
                    parolaDeVerificat.append(String.format("%02X ", b));
                }

                for (byte b : rs.getBytes("parola")) {
                    parolaUser.append(String.format("%02X ", b));
                }

                //System.out.println(parolaDeVerificat.toString());
                //System.out.println(parolaUser.toString());
                if (!parolaDeVerificat.toString().equals(parolaUser.toString()))
                    throw new IllegalArgumentException("Ati introdus o parola gresita!");
            }
            //else throw new IllegalArgumentException("Ati introdus o parola gresita!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
          catch(NoSuchAlgorithmException e)
          {
              e.printStackTrace();
          }

    }

}
