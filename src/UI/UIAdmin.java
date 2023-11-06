package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import DB.DatabaseConnectionException;
import DB.QueryException;
import MainLogic.ManagementSystem;

public class UIAdmin extends JFrame{
    private JLabel welcomeLabel;
    public JPanel mainPanel;
    private JButton createFlightButton;
    private JButton editFlightButton;
    private ManagementSystem manager = new ManagementSystem();
    protected String name;
    private static UIAdmin instance;

    public UIAdmin(String name) {
        if(name == null) {
            name = this.getName();
        } else {
            this.name = name;
        }

        welcomeLabel.setText("Welcome " + name);
        createFlightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    manager.createFlightUI();
                } catch (QueryException ex) {
                    throw new RuntimeException(ex);
                } catch (DatabaseConnectionException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
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

    public static UIAdmin getInstance(String name) {
        if (instance == null) {
            instance = new UIAdmin(name);
        }
        return instance;
    }

    public String getName() { return this.name; }
}
