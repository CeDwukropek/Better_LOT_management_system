package Creator;

import DB.DBConnection;

public abstract class Creator {
    private final DBConnection db;
    public Creator(DBConnection db) {
        this.db = db;
    }

    public DBConnection getDb() { return this.db; }
}
