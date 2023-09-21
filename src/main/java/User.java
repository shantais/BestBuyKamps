import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class User {
    private Boolean loggedStatus = false;
    String username;
    private String password = "";
    private String name = "";
    private String surname = "";
    private String email = "";
    private String street = "";
    private String houseNumber = "";
    private String flatNumber = "";
    private String postalCode = "";
    private String city = "";
    private String phoneNumber = "";
    public boolean isLogged() {
        return loggedStatus;
    }

    public String registrationForm(){
        List<String> exampleFormStrings = List.of("KowalskiRządzi666", "AwesomePassword123", "Jan", "Kowalski", "jan.kowalski@somesite.com", "Awesome Street", "111\\1", "11-111", "Great City", "123456789");
        List<String> formStrings = List.of("username=", "password=", "name=", "surname=", "email=", "street=", "houseNumber=", "postalCode=", "city=", "phoneNumber=");
        List<String> registrationForm = new LinkedList<>();

        System.out.println("Please fill in registration form:");
        for (String formSpace : formStrings){
            String value = exampleFormStrings.get(formStrings.indexOf(formSpace));
            System.out.print("\n" + formSpace + " " + value);
            registrationForm.add(formSpace+value);
        }
        System.out.println('\n');
        System.out.println(registrationForm);

        Path path = Paths.get("src", "main", "java", "dataFiles", "UserData.txt");
        String formReadyToSave = String.join("|", registrationForm);

        List<String> fullUserData = readFromFile(path);

        if (!isInFile(fullUserData, username, email)){
            writeToFile(path, fullUserData, formReadyToSave);
        }
        return formReadyToSave;
    }

    private boolean isInFile(List<String> fullUserData, String username, String email){
        return fullUserData.contains(username) || fullUserData.contains(email);
    }
    public List<String> readFromFile(Path path){
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            List<String> fullUserData = new LinkedList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                fullUserData.add(line);
            }
            return fullUserData;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void writeToFile(Path path, List<String> fullUserData, String formReadyToSave){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()))){
            fullUserData.add(formReadyToSave);
            writer.write(String.join("\n", fullUserData));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
