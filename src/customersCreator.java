import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class customersCreator {
    private final DBConnection db;
    private ArrayList<User> customers = new ArrayList<>();
    public customersCreator(DBConnection db) throws QueryException, SQLException {
        this.db = db;
        importUserData();
    }

    private void importUserData() throws QueryException, SQLException {
        ResultSet res = db.sendQuery("select * from customer");
        int columnCount = db.getColumnsNumber(res);
        
        while(res.next()) {
            String[] userInfo = new String[columnCount];

            for (int i = 1; i <= columnCount; i++) {
                userInfo[i - 1] = res.getString(i);
            }

            Customer user = new Customer(Integer.parseInt(userInfo[0]), userInfo[1], userInfo[2], userInfo[3], userInfo[4], userInfo[5]);
            customers.add(user);

            Arrays.fill(userInfo, null);
        }
    }

    public ArrayList<User> getCustomers() {
        return customers;
    }
}
