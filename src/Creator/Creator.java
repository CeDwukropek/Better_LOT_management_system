package Creator;

import DB.DBConnection;
import DB.DatabaseConnectionException;

public abstract class Creator {
    private DBConnection db = new DBConnection();
    public Creator() throws DatabaseConnectionException {

    }

    public DBConnection getDb() { return this.db; }

}
