import java.util.ArrayList;

public abstract class Creator {
    private final DBConnection db;
    public Creator(DBConnection db) {
        this.db = db;
    }

    public DBConnection getDb() { return this.db; }
}
