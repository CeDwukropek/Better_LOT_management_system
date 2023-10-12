import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class PlanesCreator extends Creator implements ICreator {
    private ArrayList<Object> planes = new ArrayList<>();
    private ArrayList<Object> airports;
    public PlanesCreator(DBConnection db, ArrayList<Object> airports) throws QueryException, SQLException {
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

            for (int i = 1; i <= columnCount; i++) {
                planeInfo[i - 1] = planeData.getString(i);
            }

            ResultSet airportsData = this.getDb().sendQuery("SELECT airport.name as airportName FROM \n" +
                    "                    plane \n" +
                    "                    JOIN flight ON flight.plane_id = plane.id \n" +
                    "                    JOIN airport ON airport.id = flight.startAirport_id \n" +
                    "                    UNION \n" +
                    "                    SELECT airport.name as airportName FROM plane \n" +
                    "                    JOIN flight ON flight.plane_id = plane.id \n" +
                    "                    JOIN airport ON airport.id = flight.finalAirport_id \n" +
                    "                    WHERE plane.id = 1");

            for (int i = 1; i <= 2; i++) {
                airportsInfo[i - 1] = airportsData.getInt(i);
            }

            Plane user = new Plane(
                    Integer.parseInt(planeInfo[0]),
                    planeInfo[1],
                    Integer.parseInt(planeInfo[2]),
                    (Airport) airports.get(airportsInfo[0]),
                    (Airport) airports.get(airportsInfo[1]),
                    null

            );
            planes.add(user);

            Arrays.fill(planeInfo, null);
        }
    }

    public ArrayList<Object> getData() {
        return planes;
    }
}
