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

        List<String> formStrings = List.of("username=", "password=", "name=", "surname=", "email=", "street=", "houseNumber=", "postalCode=", "city=", "phoneNumber=");
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

    public boolean isInFile(Path path, String value){
        List<String> fullUserData = readFromFile(path);
        for(String user: fullUserData) {
            return user.contains(value);
        }
        return false;
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
