package UI;

import javax.swing.*;

public class UICustomer extends JFrame {
    public JPanel mainPanel;
    public JLabel label;

    public UICustomer(String name) {
        label.setText("Welcome" + name);
    }
}
