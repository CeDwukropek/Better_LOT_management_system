package MainLogic;

import UI.UIAdmin;
import UI.UICustomer;
import UI.UILogin;
import Users.User;

import javax.swing.*;
import java.util.ArrayList;

public class ManagementSystem {
    ArrayList<User> flightAttenders = new ArrayList<>();

    public void loginUI() {
        UILogin frame = new UILogin(this);

        frame.setContentPane(frame.mainPanel);
        frame.setTitle("Login");
        frame.setSize(300, 250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void customerUI(String name) {
        UICustomer frame = new UICustomer(name);

        frame.setContentPane(frame.mainPanel);
        frame.setTitle("Customer");
        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void adminUI(String name) {
        UIAdmin frame = new UIAdmin(name);

        frame.setContentPane(frame.mainPanel);
        frame.setTitle("Customer");
        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
