package UI;

import DB.DBConnection;
import DB.DatabaseConnectionException;
import DB.QueryException;
import MainLogic.ManagementSystem;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UILogin extends JFrame {
    // wzorzec singletone
    public JPanel mainPanel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton logInButton;
    private static ManagementSystem manager;

    public UILogin(ManagementSystem manager) {
        this.manager = manager;
        textField1.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.GRAY));
        passwordField1.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.GRAY));
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = textField1.getText();
                String password = new String(passwordField1.getPassword());

                try {
                    DBConnection db = new DBConnection();
                    try {
                        String q = "SELECT * FROM customer WHERE email = '" + email + "' AND password = '" + password + "';";

                        ResultSet res = db.sendQuery(q);

                        res.next();
                        boolean isAdmin = res.getBoolean("isAdmin");
                        String name = res.getString("name");

                        boolean isLogged = true;

                        if(!isLogged) { return; }

                        if(isAdmin) {
                            manager.adminUI();
                            System.out.println("Zalogowano na admina");
                            dispose();
                        } else {
                            manager.customerUI(name);
                            System.out.println("Zalogowano na Customera");
                            dispose();
                        }
                    } catch (QueryException | SQLException el) {
                        throw new RuntimeException(el);
                    }
                } catch (DatabaseConnectionException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
