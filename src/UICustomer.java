import javax.swing.*;

public class UICustomer extends JFrame {
    private JButton button1;
    private JPanel mainPanel;

    public static void main(String[] args) {
        UICustomer UI = new UICustomer();
        UI.setContentPane(UI.mainPanel);
        UI.setTitle("Lot Management");
        UI.setSize(400, 350);
        UI.setVisible(true);
        UI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
