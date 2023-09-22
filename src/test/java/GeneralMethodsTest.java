import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class GeneralMethodsTest {
    GeneralMethods generalMethodsTest = new GeneralMethods();

    @Test
    void isStringInUserDataFile(){
        //given//when
        Path path = Paths.get("src", "main", "java", "dataFiles", "UserData.txt");
        String string = "Kowalski";
        //then
        assertTrue(generalMethodsTest.isInFile(path, string));
    }

}