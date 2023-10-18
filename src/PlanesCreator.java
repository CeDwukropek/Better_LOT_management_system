import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class PlanesCreator extends Creator implements ICreator {
    private final ArrayList<Plane> planes = new ArrayList<>();
    private final ArrayList<Airport> airports;
    private ArrayList<Customer> customers;
    public PlanesCreator(DBConnection db, ArrayList<Airport> airports, ArrayList<Customer> customers) throws QueryException, SQLException {
        super(db);
        this.airports = airports;
        importData();
    }

    @Override
    public void importData() throws QueryException, SQLException {
        ResultSet planeData = this.getDb().sendQuery("select * from plane");

        int columnCount = this.getDb().getColumnsNumber(planeData);

        while(planeData.next()) {
            String[] planeInfo = new String[columnCount];
            int[] airportsInfo = new int[2];
            for (int i = 1; i <= columnCount; i++) planeInfo[i - 1] = planeData.getString(i);

            ResultSet airportsData = this.getDb().sendQuery("SELECT startAirport_id, finalAirport_id FROM flight " +
                    "WHERE plane_id = " + Integer.parseInt(planeInfo[0]));

            columnCount = this.getDb().getColumnsNumber(airportsData);
            airportsData.next();

            for (int i = 1; i <= columnCount; i++) airportsInfo[i - 1] = airportsData.getInt(i);

            Plane user = new Plane(
                    Integer.parseInt(planeInfo[0]),
                    planeInfo[1],
                    Integer.parseInt(planeInfo[2]),
                    airports.get(airportsInfo[0]),
                    airports.get(airportsInfo[1]),
                    null
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
            System.out.println(x.getStartAirport().getId());
            System.out.println(x.getStartAirport().getName());
            System.out.println(x.getStartAirport().getCityName());
            System.out.println(x.getStartAirport().getCountryName());
            System.out.println(x.getFinaltAirport().getId());
            System.out.println(x.getFinaltAirport().getName());
            System.out.println(x.getFinaltAirport().getCityName());
            System.out.println(x.getFinaltAirport().getCountryName());

            if (x.getFlightAttenders() != null) {
                for (User z : x.getFlightAttenders()) {
                    System.out.println(z.getId());
                    System.out.println(z.getName());
                    System.out.println(z.getSurname());
                    System.out.println(z.getBirthDate());
                    System.out.println(z.getEmail());
                    System.out.println(z.getPhone());
                }
            }
        }
    }

    public ArrayList<Plane> getData() {
        return planes;
    }
}
