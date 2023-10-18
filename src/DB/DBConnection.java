package DB;

import java.sql.*;

public class DBConnection {
    final private dataBaseData db;
    final private String url;
    final private String username;
    final private String password;
    private Connection conn;

    public DBConnection() throws DatabaseConnectionException {
        this.db = new dataBaseData();
        this.url = "jdbc:mysql://localhost:3306/" + db.database;
        this.username = db.username;
        this.password = db.password;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection(this.url, this.username, this.password);
        } catch (SQLException e) {
            throw new DatabaseConnectionException("Can't connect to " + db.database);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Couldn't find SQL connection module");
        }
    }

    public ResultSet sendQuery(String q) throws QueryException {
        try {
            Statement stm = conn.createStatement();
            return stm.executeQuery(q);
        } catch (SQLException e) {
            throw new QueryException("Query error");
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
