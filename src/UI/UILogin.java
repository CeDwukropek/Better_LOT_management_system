package UI;

import DB.DBConnection;
import DB.DatabaseConnectionException;
import DB.QueryException;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UILogin extends JFrame {
    // wzorzec singletone
    public JPanel mainPanel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton logInButton;
    private boolean isLogged = false;

    public UILogin() {

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
                        db.sendQuery("SELECT isAdmin FROM customer WHERE email = " + email + " AND password = " + password);

                        isLogged = true;
                    } catch (QueryException el) {
                        throw new RuntimeException(el);
                    }
                } catch (DatabaseConnectionException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public boolean isLogged() {
        return isLogged;
    }
}
