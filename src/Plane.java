import java.util.ArrayList;

public class Plane {
    private Countries startCountry;
    private Countries finalCountry;
    private String name;
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
