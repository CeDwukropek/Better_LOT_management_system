package MainLogic;

import UI.UICustomer;
import UI.UILogin;
import Users.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ManagementSystem {
    ArrayList<User> flightAttenders = new ArrayList<>();
    ManagementSystem() {

    }
    void createPlane() {

    }

    boolean loginUI() {
        UILogin login = new UILogin();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int windowWidth = 400;
        int windowHeight = 250;
        int x = (screenSize.width / 2) - (windowWidth / 2);
        int y = (screenSize.height / 2) - (windowHeight / 2);

        login.setContentPane(login.mainPanel);
        login.setTitle("Login");
        login.setSize(windowWidth, windowHeight);
        login.setLocation(x, y);
        login.setVisible(true);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return false;
    }
}
