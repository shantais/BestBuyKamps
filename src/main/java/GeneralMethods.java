import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GeneralMethods {
    public boolean LogIn(){
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input username: ");
        String username = scanner.nextLine();
        user.setUsername(username);
        System.out.println("Input password: ");
        String password = scanner.nextLine();
        user.setPassword(password);
        return isInFile(user.getPath(), "username="+ user.getUsername() +"|password=" + user.getPassword());
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

    public boolean isInFile(Path path, String value){
        List<String> fullUserData = readFromFile(path);
        for(String user: fullUserData) {
            return user.contains(value);
        }
        return false;
    }

    private void addStringToFile(Path path, String dataReadyToAdd){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()))){
            List<String> fullUserData = readFromFile(path);
            fullUserData.add(dataReadyToAdd);
            writer.write(String.join("\n", fullUserData));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeToFile(Path path, String dataReadyToAdd){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()))){
            writer.write(dataReadyToAdd);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
