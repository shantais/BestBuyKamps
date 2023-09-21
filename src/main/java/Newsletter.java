import java.io.*;

public class Newsletter {
    private static final String email = "subscribers.txt";

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Enter your email address: ");
            String emailAddress = reader.readLine();

            if (emailExist(emailAddress)) {
                System.out.println("The email address already exists.");
            } else {
                addEmail(emailAddress);
                System.out.println("The e-mail address has been added to the subscriber list.");
                System.out.println("We are sending you the latest promotions...");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static boolean emailExist(String email) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(Newsletter.email))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                if (line.equals(email)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void addEmail(String email) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(Newsletter.email, true))) {
            printWriter.println(email);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


