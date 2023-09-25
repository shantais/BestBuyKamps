import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class GeneralMethodsTest {
    GeneralMethods generalMethods = new GeneralMethods();

    @Test
    void isLogInSuccessful(){
        assertTrue(generalMethods.LogIn());
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