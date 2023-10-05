import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/lot_manager";
        String username = "root";
        String password = "";
        try {
            ArrayList<User> customers = new ArrayList<>();

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, username, password);

            Statement stm = conn.createStatement();

            ResultSet res = stm.executeQuery("select * from customer");
            ResultSetMetaData rsmd = res.getMetaData();

            while (res.next()) {
                int x = rsmd.getColumnCount();
                String[] userInfo = new String[x];

                for (int i = 1; i <= x; i++) {
                    userInfo[i - 1] = res.getString(i);
                }

                try {
                    User user = new User(Integer.parseInt(userInfo[0]), userInfo[1], userInfo[2], userInfo[3], userInfo[4], userInfo[5]);
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