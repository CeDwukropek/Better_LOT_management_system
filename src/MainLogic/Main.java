package MainLogic;

import java.sql.*;
import Creator.Customer.*;
import Creator.Plane.*;
import Creator.Airport.*;
import DB.*;


public class Main {
    public static void main(String[] args){
        ManagementSystem manager = new ManagementSystem();

        manager.loginUI();
    }
}