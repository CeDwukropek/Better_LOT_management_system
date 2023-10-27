package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIAdmin extends JFrame{
    private JLabel welcomeLabel;
    public JPanel mainPanel;
    private JButton createFlightButton;
    private JButton editFlightButton;

    public UIAdmin(String name) {
        welcomeLabel.setText("Welcome " + name);
        createFlightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });
        editFlightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });
    }
}
