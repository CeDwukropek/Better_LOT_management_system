package UI;

import javax.swing.*;

public class UICustomer extends JFrame {
    public JPanel mainPanel;
    private JLabel nameLabel;
    private JLabel SurnameLabel;
    private JLabel PhoneLabel;
    private JLabel arriveLabel;
    private JLabel DepartureLabel;
    private JPanel NrFlightLabel;
    private JLabel GateLabel;
    private JLabel SeatLabel;
    public JLabel label;

    public UICustomer(String name) {
        label.setText("Well cum " + name);
    }
}
