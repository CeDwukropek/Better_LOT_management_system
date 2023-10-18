public class Airport {
    private final int id;
    private final String name;
    private final String city_name;
    private final String country_name;

    public Airport(int id, String name, String cityName, String countryName) {
        this.id = id;
        this.name = name;
        city_name = cityName;
        country_name = countryName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCityName() {
        return city_name;
    }

    public String getCountryName() {
        return country_name;
    }
}
