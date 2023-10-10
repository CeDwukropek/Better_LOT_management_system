import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        DBConnection db = new DBConnection();
        try {
            ArrayList<Customer> customers = new ArrayList<>();

            ResultSet res = db.sendQuery("select * from customer");
            int columnCount = db.getColumnsNumber(res);

            while (res.next()) {
                String[] userInfo = new String[columnCount];

                for (int i = 1; i <= columnCount; i++) {
                    userInfo[i - 1] = res.getString(i);
                }
                try {
                    Customer user = new Customer(Integer.parseInt(userInfo[0]), userInfo[1], userInfo[2], userInfo[3], userInfo[4], userInfo[5]);
                    customers.add(user);
                } catch (Exception e) {
                    System.out.println("Error while creating user");
                }
                Arrays.fill(userInfo, null);
            }

            for(User x : customers) {
                System.out.println(x.getName() + " " + x.getSurname());
            }

        } catch (Exception e) {
            System.out.println("DB error");
        }

    }
}