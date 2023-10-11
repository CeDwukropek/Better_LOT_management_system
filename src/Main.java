import java.sql.*;

public class Main {
    public static void main(String[] args) throws DatabaseConnectionException, QueryException {
        try {
            DBConnection db = new DBConnection();
            CustomersCreator customersCreator = new CustomersCreator(db);

            for(Object x : customersCreator.getData()) {
                System.out.println(((User)x).getName() + " " + ((User)x).getSurname());
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}