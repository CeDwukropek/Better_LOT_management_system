import javax.xml.transform.Result;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/lot_manager";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, username, password);

            Statement stm = conn.createStatement();

            ResultSet res = stm.executeQuery("select * from customer");
            ResultSetMetaData rsmd = res.getMetaData();

            StringBuilder user = new StringBuilder();

            while (res.next()) {
                int x = rsmd.getColumnCount();
                for (int i = 1; i <= x; i++) {
                    user.append(res.getString(i)).append(" ");
                }
                System.out.println(user);
                user = new StringBuilder();
            }

        } catch (Exception e) {
            System.out.println("DB error");
        }
    }
}