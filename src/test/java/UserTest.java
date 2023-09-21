//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class UserTest {
//    User user = new User();
//
//    @Test
//    void isCurrentUserLogged(){
//        assertFalse(user.isLogged());
//    }
//
//
////    TODO: try to activate private methods via reflection
////    Tested Method but changed to private for safety
////    @Test
////    @Disabled
////    void isUserNameInUserDataFile(){
////        Path path = Paths.get("src", "main", "java", "dataFiles", "UserData.txt");
////        assertEquals(true, user.isInFile(path, "KowalskiRządzi666", "jan.kowalski@somesite.com"));
////    }
//
//    @Test
//    @Disabled
//    void didGenerateProperRegistrationForm(){
//        //given//when
//        String userData = "username=KowalskiRządzi666|password=AwesomePassword123|name=Jan|surname=Kowalski|email=jan.kowalski@somesite.com|" +
//                "street=Awesome Street|houseNumber=111\\1|postalCode=11-111|city=Great City|phoneNumber=123456789";
//        //then
//        assertEquals(userData, user.registrationForm());
//    }
//
//    @Test
//    void isStringInUserDataFile(){
//        //given//when
//        Path path = Paths.get("src", "main", "java", "dataFiles", "UserData.txt");
//        String string = "Kowalski";
//        //then
//        assertTrue(user.isInFile(path, string));
//    }
//
//    @Test
//    void isRegistrationFormInDatabase(){
//        Path path = Paths.get("src", "main", "java", "dataFiles", "UserData.txt");
//        String userData = "username=KowalskiRządzi666|password=AwesomePassword123|name=Jan|surname=Kowalski|email=jan.kowalski@somesite.com|" +
//                "street=Awesome Street|houseNumber=111\\1|postalCode=11-111|city=Great City|phoneNumber=123456789";
//        assertTrue(user.readFromFile(path).contains(userData));
//    }
//
//    @Test
//    void xxxx(){
//
//    }
//}