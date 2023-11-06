package Creator.Airport;

import Creator.*;
import DB.DBConnection;
import DB.DatabaseConnectionException;
import DB.QueryException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class AirportCreator extends Creator implements ICreator {
    private final ArrayList<Airport> airports = new ArrayList<>();
    private static AirportCreator instance;

    public AirportCreator() throws QueryException, SQLException, DatabaseConnectionException {
        importData();
    }

    @Override
    public void importData() throws QueryException, SQLException {
        ResultSet airportData = this.getDb().sendQuery("SELECT airport.id, airport.name, city.name, countries.name FROM airport " +
                "JOIN city on city_id = city.id " +
                "JOIN countries on city.country_id = countries.id;"
        );
        int columnCount = this.getDb().getColumnsNumber(airportData);

        while(airportData.next()) {
            String[] airportInfo = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) airportInfo[i - 1] = airportData.getString(i);

            Airport airport = new Airport(Integer.parseInt(airportInfo[0]), airportInfo[1], airportInfo[2], airportInfo[3]);
            airports.add(airport);
            Arrays.fill(airportInfo, null);
        }
    }

    @Override
    public void printData() {

    }

    public static AirportCreator getInstance() throws QueryException, SQLException, DatabaseConnectionException {
        if (instance == null) {
            instance = new AirportCreator();
        }
        return instance;
    }

    public ArrayList<Airport> getData() {
        return airports;
    }
}
