package bll.validators;

import connection.ConnectionFactory;
import model.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExistaUsernameAdminValidator implements Validator<Admin> {

    private static final String usernameAdminString;

    static {
        usernameAdminString = "select username from Admin";
    }

    public void validate(Admin t) {

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement usernameAdminStatement;

        try {
            usernameAdminStatement = dbConnection.prepareStatement(usernameAdminString);
            int ok=0;
            ResultSet rs = usernameAdminStatement.executeQuery();

            while (rs.next()) {

                String adminUsername = rs.getString("username");
                if(adminUsername.equals(t.getUsername()))

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
