import java.util.ArrayList;

public class Plane {
    private final int id;
    private final Countries startCountry;
    private final Countries finalCountry;
    private final String name;
    private int passengersLimit = 10;
    private ArrayList<User> flightAttenders = new ArrayList<>();

    public Plane(int id,
                 String name,
                 int passengersLimit,
                 Countries startCountry,
                 Countries finalCountry,
                 ArrayList<User> flightAttenders) {
        this.name = name;
        this.id = id;
        this.passengersLimit = passengersLimit;
        this.startCountry = startCountry;
        this.finalCountry = finalCountry;
        this.flightAttenders = flightAttenders;
    }

    public void setPassengersLimit(int passengersLimit) {
        this.passengersLimit = passengersLimit;
    }
}
