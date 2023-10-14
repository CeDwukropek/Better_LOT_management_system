import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class CustomersCreator extends Creator implements ICreator {
    private final ArrayList<Object> customers = new ArrayList<>();
    public CustomersCreator(DBConnection db) throws QueryException, SQLException {
        super(db);
    }

    @Override
    public void importData() throws QueryException, SQLException {
        ResultSet res = this.getDb().sendQuery("select * from customer");
        int columnCount = this.getDb().getColumnsNumber(res);
        
        while(res.next()) {
            String[] userInfo = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) userInfo[i - 1] = res.getString(i);

            Customer user = new Customer(Integer.parseInt(userInfo[0]), userInfo[1], userInfo[2], userInfo[3], userInfo[4], userInfo[5]);
            customers.add(user);
            Arrays.fill(userInfo, null);
        }
    }

    public ArrayList<Object> getData() {
        return customers;
    }
}
