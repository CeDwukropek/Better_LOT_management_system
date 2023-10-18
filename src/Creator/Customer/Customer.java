package Creator.Customer;
import Creator.IUser;
import Creator.User;

public class Customer extends User implements IUser {
    public Customer(int id, String name, String surname, String phone, String email, String birthDate) {
        super(id, name, surname, phone, email, birthDate);
    }

    @Override
    public void sendMessage() {
        return;
    }
}
