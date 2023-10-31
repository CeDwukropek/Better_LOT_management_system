package UI;

import javax.swing.*;
import DB.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UIAdminCreateFlight extends JFrame {
    public JPanel mainPanel;
    private JLabel plane;
    private JLabel startAirport;
    private JLabel finalAirport;
    protected JComboBox planes;
    private JComboBox startAirports;
    private JComboBox finalAirports;

    private DBConnection db;

    public UIAdminCreateFlight() throws DatabaseConnectionException, QueryException, SQLException {
        this.db = new DBConnection();

        ResultSet planesRes = db.sendQuery("SELECT name FROM plane");
        ResultSet airportsRes = db.sendQuery("SELECT name FROM airport");
        planesRes.next();
        airportsRes.next();

        int count = db.getColumnsNumber(planesRes);
        for (int i = 1; i <= count; i++) {
            planes.addItem(planesRes.getString(i));
        }

        count = db.getColumnsNumber(airportsRes);
        for (int i = 1; i <= count; i++) {
            startAirports.addItem(airportsRes.getString(i));
            finalAirports.addItem(airportsRes.getString(i));
        }
    }
}
