import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GeneralMethods {
    public static String LogIn(Scanner scanner, User user){
        System.out.println("Input username: ");
        String username = scanner.nextLine();
        user.setUsername(username);
        System.out.println("Input password: ");
        String password = scanner.nextLine();
        user.setPassword(password);
        return "username="+ user.getUsername() +"|password=" + user.getPassword();
    }

    public static void logInLoop(Scanner scanner, User user) throws InterruptedException {
        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Log In | 2. Register | 3. Back to Shop" );
            Thread.sleep(100);

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                String logInData = LogIn(scanner, user);
                if (isInFile(user.getPath(), logInData)){
                    System.out.println("Logged in successfully");
                    user.setLoggedStatus(true);
                    user.setAllUserData(logInData);
                    break;
                } else {
                    System.out.println("Wrong Username or password.");
                }
            } else if (choice.equals("2")) {
                String filledForm = registrationForm(scanner);
                if (isInFile(user.getPath(), filledForm)){
                    System.out.println("User already exists");
                } else {
                    addStringToFile(user.getPath(), filledForm);
                    System.out.println("Registration successful.");
                    break;
                }
            } else {
                System.out.println("Incorrect command, try again.");
            }
        }
    }

    public static List<String> readFromFile(Path path){
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

    public static boolean isInFile(Path path, String value){
        List<String> fullUserData = readFromFile(path);
        for(String user: fullUserData) {
            return user.contains(value);
        }
        return false;
    }

    public static String getFromFile(Path path, String line){
        List<String> fullUserData = readFromFile(path);
        for(String userLine: fullUserData) {
            if (userLine.contains(line)){
                return userLine;
            }
        }
        System.out.println("Data have not been found.");
        return "";
    }

    private static void addStringToFile(Path path, String dataReadyToAdd){
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

    public static String registrationForm(Scanner scanner){
        List<String> formStrings = List.of("username=", "password=", "name=", "surname=", "email=", "street=",
                "houseNumber=", "postalCode=", "city=", "phoneNumber=");
        List<String> registrationForm = new LinkedList<>();

        System.out.println("Please fill in registration form:");

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
