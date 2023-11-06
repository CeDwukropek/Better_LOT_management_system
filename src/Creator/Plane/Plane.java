package Creator.Plane;

import Creator.Airport.Airport;
import Users.User;

import java.util.ArrayList;

public class Plane {
    private final int id;
    private final String name;
    private final int passengersLimit;

    public Plane(int id,
                 String name,
                 int passengersLimit) {
        this.id = id;
        this.name = name;
        this.passengersLimit = passengersLimit;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPassengersLimit() {
        return passengersLimit;
    }
}
