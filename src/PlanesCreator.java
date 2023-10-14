import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class PlanesCreator extends Creator implements ICreator {
    private final ArrayList<Object> planes = new ArrayList<>();
    private final ArrayList<Object> airports;
    private ArrayList<Object> customers;
    public PlanesCreator(DBConnection db, ArrayList<Object> airports, ArrayList<Object> customers) throws QueryException, SQLException {
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
