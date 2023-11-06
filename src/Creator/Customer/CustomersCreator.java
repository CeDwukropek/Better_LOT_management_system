package Creator.Customer;

import Creator.*;
import DB.DBConnection;
import DB.DatabaseConnectionException;
import DB.QueryException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class CustomersCreator extends Creator implements ICreator {
    private final ArrayList<Customer> customers = new ArrayList<>();
    private static CustomersCreator instance;
    public CustomersCreator() throws QueryException, SQLException, DatabaseConnectionException {
        importData();
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

    @Override
    public void printData() {

    }

    public static CustomersCreator getInstance() throws QueryException, SQLException, DatabaseConnectionException {
        if (instance == null) {
            instance = new CustomersCreator();
        }
        return instance;
    }

    public ArrayList<Customer> getData() {
        return customers;
    }
}
