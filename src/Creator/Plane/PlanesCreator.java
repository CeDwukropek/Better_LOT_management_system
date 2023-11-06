package Creator.Plane;

import Creator.*;
import Creator.Airport.Airport;
import Creator.Airport.AirportCreator;
import Creator.Customer.Customer;
import DB.DBConnection;
import DB.DatabaseConnectionException;
import DB.QueryException;
import Users.User;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class PlanesCreator extends Creator implements ICreator {
    private final ArrayList<Plane> planes = new ArrayList<>();
    public final ArrayList<Airport> airports;
    private ArrayList<Customer> customers;
    private static PlanesCreator instance;
    public PlanesCreator(ArrayList<Airport> airports, ArrayList<Customer> customers) throws QueryException, SQLException, DatabaseConnectionException {
        this.airports = airports;
        importData();
    }

    public static PlanesCreator getInstance(ArrayList<Airport> airports, ArrayList<Customer> customers) throws QueryException, SQLException, DatabaseConnectionException {
        if (instance == null) {
            instance = new PlanesCreator(airports, customers);
        }
        return instance;
    }

    @Override
    public void importData() throws QueryException, SQLException {
        ResultSet planeData = this.getDb().sendQuery("select * from plane");

        int columnCount = this.getDb().getColumnsNumber(planeData);

        while(planeData.next()) {
            String[] planeInfo = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) planeInfo[i - 1] = planeData.getString(i);

            Plane user = new Plane(
                    Integer.parseInt(planeInfo[0]),
                    planeInfo[1],
                    Integer.parseInt(planeInfo[2])
            );
            planes.add(user);
            Arrays.fill(planeInfo, null);
        }
    }

    @Override
    public void printData() {
        for (Plane x : this.planes) {
            System.out.println(x.getId());
            System.out.println(x.getName());
            System.out.println(x.getPassengersLimit());
        }
    }

    public ArrayList<Plane> getData() {
        return planes;
    }
}
