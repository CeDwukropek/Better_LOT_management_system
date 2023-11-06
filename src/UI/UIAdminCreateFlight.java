package UI;

import javax.swing.*;

import Creator.Airport.Airport;
import Creator.Airport.AirportCreator;
import Creator.Customer.Customer;
import Creator.Customer.CustomersCreator;
import Creator.Plane.PlanesCreator;
import Creator.Plane.Plane;
import DB.*;
import MainLogic.ManagementSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
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
    private JButton createFlightButton;

    protected ManagementSystem manager;
    protected DBConnection db = new DBConnection();

    public UIAdminCreateFlight(ManagementSystem manager) throws DatabaseConnectionException, QueryException, SQLException {
        this.manager = manager;

        AirportCreator airportCreator = AirportCreator.getInstance();
        ArrayList<Airport> airportsArr = airportCreator.getData();
        CustomersCreator customersCreator = CustomersCreator.getInstance();
        ArrayList<Customer> customersArr = customersCreator.getData();
        PlanesCreator planesCreator = PlanesCreator.getInstance(airportsArr, customersArr);
        ArrayList<Plane> planesArr = planesCreator.getData();

        int count = airportCreator.getData().size();

        for (int i = 0; i < count; i++) {
            startAirports.addItem(airportsArr.get(i).getName());
            finalAirports.addItem(airportsArr.get(i).getName());
        }

        count = planesCreator.getData().size();

        for (int i = 0; i < count; i++) {
            planes.addItem(planesArr.get(i).getName());
        }

        createFlightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int plane = planes.getSelectedIndex() + 1;
                int startAirport = startAirports.getSelectedIndex() + 1;
                int finalAirport = finalAirports.getSelectedIndex() + 1;

                PreparedStatement pstmt = null;
                try {
                    pstmt = db.getConn().prepareStatement("INSERT INTO `flight`(plane_id, startAirport_id, finalAirport_id) VALUES (?, ?, ?)");
                    pstmt.setString(1, Integer.toString(plane));
                    pstmt.setString(2, Integer.toString(startAirport));
                    pstmt.setString(3, Integer.toString(finalAirport));
                    System.out.println(pstmt);
                    pstmt.executeUpdate();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                manager.adminUI(null);
                dispose();
            }
        });
    }
}
