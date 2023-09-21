import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user = new User();

    @Test
    void isCurrentUserLogged(){
        assertEquals(false, user.isLogged());
    }

//    Tested Method but changed to private for safety
//    TODO: try to activate via reflection
//    @Test
//    @Disabled
//    void isUserNameInUserDataFile(){
//        Path path = Paths.get("src", "main", "java", "dataFiles", "UserData.txt");
//        assertEquals(true, user.isInFile(path, "KowalskiRządzi666", "jan.kowalski@somesite.com"));
//    }

//    test for another Class
//    @Test
//    void isLoginUnique(){
//        String login = "KowalskiRządzi666";
//        assertEquals(true, loggedInUser.getLogin(login));
//    }

    @Test
    void didSaveRegistrationForm(){
        //given//when
        Path path = Paths.get("src", "main", "java", "dataFiles", "UserData.txt");
        String userData = "username=KowalskiRządzi666|password=AwesomePassword123|name=Jan|surname=Kowalski|email=jan.kowalski@somesite.com|" +
                "street=Awesome Street|houseNumber=111\\1|postalCode=11-111|city=Great City|phoneNumber=123456789";
        //then
        assertEquals(userData, user.registrationForm());
    }

    @Test
    void isRegistrationFormInDatabase(){
        Path path = Paths.get("src", "main", "java", "dataFiles", "UserData.txt");
        String userData = "username=KowalskiRządzi666|password=AwesomePassword123|name=Jan|surname=Kowalski|email=jan.kowalski@somesite.com|" +
                "street=Awesome Street|houseNumber=111\\1|postalCode=11-111|city=Great City|phoneNumber=123456789";
        assertEquals(true, user.readFromFile(path).contains(userData));
    }

    @Test
    void areAllRequiredRegistrationSpacesFilled(){
        String username = "KowalskiRządzi666";
        String password = "AwesomePassword123";
        String email = "jan.kowalski@somesite.com";

        assertEquals(true, user.registrationForm());
    }
}