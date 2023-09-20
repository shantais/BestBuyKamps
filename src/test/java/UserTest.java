import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void isCurrentUserLogged(){
        User user = new User();
        assertEquals(false, user.isLogged());
    }

    @Test
    void xxx(){

    }

    @Test
    void isLoginUnique(){
        String login = "KowalskiRządzi666";
//        assertEquals(false, loggedInUser.getLogin(login));
    }

    @Test
    void areAllRequiredRegistrationSpacesFilled(){
        User user = new User();

        String login = "KowalskiRządzi666";
        String password = "AwesomePassword123";
        String email = "jan.kowalski@somesite.com";

        assertEquals(true, user.registrationForm());
    }
}