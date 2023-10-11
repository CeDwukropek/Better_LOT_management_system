import java.util.ArrayList;

public class Plane {
    private final Countries startCountry;
    private final Countries finalCountry;
    private final String name;
    private int passengersLimit = 10;
    private ArrayList<User> flightAttenders = new ArrayList<>();

    public Plane(Countries startCountry,
                 Countries finalCountry,
                 String name,
                 ArrayList<User> flightAttenders) {
        this.startCountry = startCountry;
        this.finalCountry = finalCountry;
        this.name = name;
        this.flightAttenders = flightAttenders;
    }

    public void setPassengersLimit(int passengersLimit) {
        this.passengersLimit = passengersLimit;
    }
}
