package MainLogic;

import java.sql.*;
import Creator.Customer.*;
import Creator.Plane.*;
import Creator.Airport.*;
import DB.*;


public class Main {
    public static void main(String[] args) throws DatabaseConnectionException, QueryException {
        try {
            DBConnection db = new DBConnection();
            CustomersCreator customersCreator = new CustomersCreator(db);
            AirportCreator airportCreator = new AirportCreator(db);
            PlanesCreator planesCreator = new PlanesCreator(db, airportCreator.getData(), customersCreator.getData());

            planesCreator.printData();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}