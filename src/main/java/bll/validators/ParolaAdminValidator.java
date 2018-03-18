package bll.validators;

import connection.ConnectionFactory;
import model.Admin;


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
                if (!t.getParola().equals(rs.getString("parola")))
                    throw new IllegalArgumentException("Ati introdus o parola gresita!");
            }
            //else throw new IllegalArgumentException("Ati introdus o parola gresita!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
