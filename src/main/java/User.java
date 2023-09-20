import java.util.List;

public class User {
    private Boolean loggedStatus = false;
    String name = "";
    String surname = "";
    String password = "";
    String email = "";
    String street = "";
    String houseNumber = "";
    String flatNumber = "";
    String postalCode = "";
    String city = "";
    String phoneNumber = "";

    public boolean isLogged() {
        return loggedStatus;
    }

    public static Boolean registrationForm() {

        return true;
    }
}
