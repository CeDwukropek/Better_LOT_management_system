import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public interface ICreator {
    void importData() throws QueryException, SQLException;
    public ArrayList<Object> getData();
}
