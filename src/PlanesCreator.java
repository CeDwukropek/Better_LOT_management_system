import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class PlanesCreator extends Creator implements ICreator {
    private ArrayList<Object> planes = new ArrayList<>();
    public PlanesCreator(DBConnection db) {
        super(db);
    }

    @Override
    public void importData() throws QueryException, SQLException {
        ResultSet res = this.getDb().sendQuery("select * from planes");
        int columnCount = this.getDb().getColumnsNumber(res);

        while(res.next()) {
            String[] planeInfo = new String[columnCount];

            for (int i = 1; i <= columnCount; i++) {
                planeInfo[i - 1] = res.getString(i);
            }

            Plane user = new Plane(
                    Integer.parseInt(planeInfo[0]),
                    planeInfo[1],
                    Integer.parseInt(planeInfo[2])
            );
            planes.add(user);

            Arrays.fill(planeInfo, null);
        }
    }

    public ArrayList<Object> getData() {
        return planes;
    }
}
