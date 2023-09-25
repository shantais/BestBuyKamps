import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class GeneralMethodsTest {
    GeneralMethods generalMethods = new GeneralMethods();

    @Test
    void isLogInSuccessful(){
        User user = new User();
        String username = "KowalskiRządzi666";
        String password = "AwesomePassword123";
        assertTrue(generalMethods.isInFile(user.getPath(), "username="+ username +"|password=" + password));
    }

    @Test
    void isStringInUserDataFile(){
        //given//when
        Path path = Paths.get("src", "main", "java", "dataFiles", "UserData.txt");
        String string = "Kowalski";
        //then
        assertTrue(generalMethods.isInFile(path, string));
    }

}