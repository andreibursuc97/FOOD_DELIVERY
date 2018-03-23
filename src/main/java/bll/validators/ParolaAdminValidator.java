package bll.validators;

import connection.ConnectionFactory;
import model.Admin;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParolaAdminValidator implements Validator<Admin> {

    private static final String parolaAdminString;

    static {
        parolaAdminString = "select parola from Admin where username=?";
    }

    public void validate(Admin t) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement parolaAdminStatement=null;

        try{
            parolaAdminStatement=dbConnection.prepareStatement(parolaAdminString);
            parolaAdminStatement.setString(1,t.getUsername());
            ResultSet rs=parolaAdminStatement.executeQuery();
            if(rs.next()) {

                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                byte[] hash = digest.digest(t.getParola().getBytes(StandardCharsets.UTF_8));
                StringBuilder parolaDeVerificat = new StringBuilder();
                StringBuilder parolaDeVerificat2 = new StringBuilder();
                StringBuilder parolaUser = new StringBuilder();
                for (byte b : hash) {
                    parolaDeVerificat.append(String.format("%02X ", b));
                }

               /* for (byte b : rs.getBytes("parola")) {
                    parolaUser.append(String.format("%02X ", b));
                }*/

                //String fileString=new String(hash,"UTF-8");
                String upper=rs.getString("parola").toUpperCase();

                for(int i=0;i<upper.length();i+=2)
                {
                    if(i!=0)
                        parolaUser.append(" ");
                    parolaUser.append(upper.substring(i,i+2));
                }
                parolaUser.append(" ");
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
