import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws DatabaseConnectionException, QueryException {
        try {
            DBConnection db = new DBConnection();
            customersCreator customersCreator = new customersCreator(db);

            for(User x : customersCreator.getCustomers()) {
                System.out.println(x.getName() + " " + x.getSurname());
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}