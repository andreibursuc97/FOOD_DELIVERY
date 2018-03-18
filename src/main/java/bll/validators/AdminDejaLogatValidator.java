package bll.validators;

import connection.ConnectionFactory;
import model.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDejaLogatValidator implements Validator<Admin> {

    private static final String adminLogatString;

    static {
        adminLogatString = "select logat from Admin where logat=1";
    }

    public void validate(Admin t) {

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement adminLogatStatement=null;

        try {
            int ok = 1;

            adminLogatStatement = dbConnection.prepareStatement(adminLogatString);

            ResultSet rs = adminLogatStatement.executeQuery();

            if (rs.next()) {
                ok=0;

            }

            if (ok == 0)
                throw new IllegalArgumentException("Exista deja un admin logat!");

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            ConnectionFactory.close(dbConnection);
            ConnectionFactory.close(adminLogatStatement);
        }
    }
}
