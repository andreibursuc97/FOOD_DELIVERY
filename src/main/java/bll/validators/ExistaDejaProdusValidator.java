package bll.validators;

import connection.ConnectionFactory;
import model.Produs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExistaDejaProdusValidator implements Validator<Produs> {

    private static final String produsString;

    static {
        produsString = "select id from produs where descriere=? ";
    }

    public void validate(Produs t) {

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement produsStatement=null;

        try {
            int ok=0;
            produsStatement= dbConnection.prepareStatement(produsString);
            produsStatement.setString(1,t.getDescriere());
            ResultSet rs = produsStatement.executeQuery();

            if(rs.next())
                ok=1;


            if(ok==1)
                throw new IllegalArgumentException("Produsul a fost deja adaugat in meniu, se poate doar actualiza cantitatea!");

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            ConnectionFactory.close(dbConnection);
            ConnectionFactory.close(produsStatement);
        }
    }
}
