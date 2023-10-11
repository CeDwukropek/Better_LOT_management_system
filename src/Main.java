import java.sql.*;

public class Main {
    public static void main(String[] args) throws DatabaseConnectionException, QueryException {
        try {
            DBConnection db = new DBConnection();
            CustomersCreator customersCreator = new CustomersCreator(db);
            PlanesCreator planesCreator = new PlanesCreator(db);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}