package Creator.Plane;

import Creator.Airport.Airport;

import java.util.ArrayList;

public class Plane {
    private final int id;
    private final String name;
    private final int passengersLimit;
    private final Airport startAirport;
    private final Airport finaltAirport;
    private final ArrayList<User> flightAttenders;

    public Plane(int id,
                 String name,
                 int passengersLimit,
                 Airport startAirport,
                 Airport finaltAirport,
                 ArrayList<User> flightAttenders) {
        this.id = id;
        this.name = name;
        this.passengersLimit = passengersLimit;
        this.startAirport = startAirport;
        this.finaltAirport = finaltAirport;
        this.flightAttenders = flightAttenders;
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

    public Airport getStartAirport() {
        return startAirport;
    }

    public Airport getFinaltAirport() {
        return finaltAirport;
    }

    public ArrayList<User> getFlightAttenders() {
        return flightAttenders;
    }

}
