import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void isCurrentUserLogged(){
        assertEquals(false, User.isLogged());
    }
    @Test
    void areAllRegistrationSpacesFilled(){
        String name = "Jan";
        String surname = "Kowalski";
        String password = "AwesomePassword123";
        String email = "jan.kowalski@somesite.com";
        String street = "Awesome Street";
        String houseNumber = "111";
        String flatNumber = "1";
        String postalCode = "11-111";
        String city = "Great City";
        String phoneNumber = "123456789";

        assertEquals(true, User.registrationForm());
    }
}