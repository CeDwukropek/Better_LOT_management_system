package MainLogic;

import UI.UILogin;
import Users.User;

import javax.swing.*;
import java.util.ArrayList;

public class ManagementSystem {
    ArrayList<User> flightAttenders = new ArrayList<>();
    ManagementSystem() {

    }
    void createPlane() {

    }

    void loginUI() {
        UILogin login = new UILogin();

        login.setContentPane(login.mainPanel);
        login.setTitle("Login");
        login.setSize(300, 250);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
