import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class PlanesCreator implements ICreator {
    private ArrayList<Object> planes = new ArrayList<>();
    public PlanesCreator() {
    }

    @Override
    public void importData() throws QueryException, SQLException {

    }

    public ArrayList<Object> getData() {
        return planes;
    }
}
