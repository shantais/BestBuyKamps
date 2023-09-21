import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class User {
    private Boolean loggedStatus = false;
    public boolean isLogged() {
        return loggedStatus;
    }

    public static void main(String[] args) {
        User user = new User();
        String form = user.registrationForm();
    }

    public String registrationForm(){
        Path path = Paths.get("src", "main", "java", "dataFiles", "UserData.txt");

        List<String> formStrings = List.of("username=", "password=", "name=", "surname=", "email=", "street=",
                "houseNumber=", "postalCode=", "city=", "phoneNumber=");
        List<String> registrationForm = new LinkedList<>();

        System.out.println("Please fill in registration form:");
        Scanner scanner = new Scanner(System.in);

        for (String formSpace : formStrings){
            boolean isEmpty = true;
            while (isEmpty) {
                System.out.print(formSpace + " ");
                String value = scanner.nextLine();
                registrationForm.add(formSpace + value);
                if (!value.isEmpty()){
                    isEmpty = false;
                }
            }
        }
        System.out.println('\n');
        System.out.println(registrationForm);

        return String.join("|", registrationForm);
    }





}
