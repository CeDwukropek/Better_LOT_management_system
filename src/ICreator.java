import java.sql.SQLException;

public interface ICreator {
    void importData() throws QueryException, SQLException;
}
