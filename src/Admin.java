public class Admin extends User implements IUser {
    final private boolean adminUI = true;
    public Admin(int id, String name, String surname, String phone, String email, String birthDate) {
        super(id, name, surname, phone, email, birthDate);
    }
    @Override
    public void sendMessage() {
        return;
    }
}
