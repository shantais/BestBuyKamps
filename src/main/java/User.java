import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class User {
    private Boolean loggedStatus = false;
    String login;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String street;
    private String houseNumber;
    private String flatNumber;
    private String postalCode;
    private String city;
    private String phoneNumber;

    public boolean isLogged() {
        return loggedStatus;
    }

    public boolean registrationForm() {
        Path path = Paths.get("src", "main", "java", "dataFiles", "UserData.txt");


        return true;
    }

    private void saveRegistrationForm(){
        login = "KowalskiRządzi666";
        password = "AwesomePassword123";
        name = "Jan";
        surname = "Kowalski";
        email = "jan.kowalski@somesite.com";
        street = "Awesome Street";
        houseNumber = "111";
        flatNumber = "1";
        postalCode = "11-111";
        city = "Great City";
        phoneNumber = "123456789";


    }
}
