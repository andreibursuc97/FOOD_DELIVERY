package bll.validators;

        import connection.ConnectionFactory;
        import model.Cos;

        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;

/**
 * Created by Andrei on 21/04/2017.
 */
public class CosNefinalizatValidator implements Validator<Cos> {

    private static final String cosNefinalizatString;

    static {
        cosNefinalizatString = "select id from cos where comanda_finalizata=false and client_id=(select id from clienti where logat=true)";
    }


    public void validate(Cos t) {

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement cosNefinalizatStatement=null;

        try {
            int ok=0;
            cosNefinalizatStatement= dbConnection.prepareStatement(cosNefinalizatString);

            ResultSet rs = cosNefinalizatStatement.executeQuery();

            if(rs.next())
                ok=1;

            if(ok==1)
                throw new IllegalArgumentException("Exista deja un cos creat!");

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            ConnectionFactory.close(dbConnection);
            ConnectionFactory.close(cosNefinalizatStatement);
        }

    }
}
