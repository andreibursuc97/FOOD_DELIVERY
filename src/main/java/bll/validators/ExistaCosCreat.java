package bll.validators;

import connection.ConnectionFactory;
import model.Cos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExistaCosCreat implements Validator<Cos> {

    private static final String existaCosString;

    static {
        existaCosString = "select id from cos where comanda_finalizata=false and client_id=(select id from clienti where logat=true)";
    }


    public void validate(Cos t) {

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement existaCosStatement=null;

        try {
            int ok=0;
            existaCosStatement= dbConnection.prepareStatement(existaCosString);

            ResultSet rs = existaCosStatement.executeQuery();

            if(rs.next())
                ok=1;

            if(ok==0)
                throw new IllegalArgumentException("Nu exista un cos creat!");

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            ConnectionFactory.close(dbConnection);
            ConnectionFactory.close(existaCosStatement);
        }

    }
}
