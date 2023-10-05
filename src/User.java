public class User implements IUser {
    final private int id;
    final private String name;
    final private String surname;
    final private String phone;
    final private String email;
    final private String birthDate;
    public User(int id, String name, String surname, String phone, String email, String birthDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.birthDate = birthDate;
    }

    @Override
    public IUser getUser() {
        return this;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void sendMessage() {
        return;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthDate() {
        return birthDate;
    }
}
