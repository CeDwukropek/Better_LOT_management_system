import java.util.ArrayList;

public class userCreator {
    private final DBConnection db;
    private ArrayList<User> users = new ArrayList<>();
    public userCreator(DBConnection db) {
        this.db = db;
    }
}
