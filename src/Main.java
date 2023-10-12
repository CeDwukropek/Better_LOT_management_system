import java.sql.*;

public class Main {
    public static void main(String[] args) throws DatabaseConnectionException, QueryException {
        try {
            DBConnection db = new DBConnection();
            CustomersCreator customersCreator = new CustomersCreator(db);
            AirportCreator airportCreator = new AirportCreator(db);
            PlanesCreator planesCreator = new PlanesCreator(db, airportCreator.getData());

            for (Object x : planesCreator.getData()) {
                System.out.println(((Plane)x).getName());
                System.out.println(((Plane)x).getFinaltAirport());
                System.out.println(((Plane)x).getStartAirport());
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}