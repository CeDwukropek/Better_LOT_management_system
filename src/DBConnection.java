import java.sql.*;

public class DBConnection {
    final private dataBaseData db;
    final private String url;
    final private String username;
    final private String password;
    private Connection conn;

    public DBConnection() {
        this.db = new dataBaseData();
        this.url = "jdbc:mysql://localhost:3306/" + db.database;
        this.username = db.username;
        this.password = db.password;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection(this.url, this.username, this.password);
        } catch (Exception e) {
            System.out.println("Database connection error");
            this.conn = null;
        }
    }

    public ResultSet sendQuery(String q) {
        try {
            Statement stm = conn.createStatement();
            return stm.executeQuery(q);
        } catch (Exception e) {
            System.out.println("Query error");
            return null;
        }
    }

    public int getColumnsNumber(ResultSet res) {
        try {
            ResultSetMetaData rsmd = res.getMetaData();
            return rsmd.getColumnCount();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
