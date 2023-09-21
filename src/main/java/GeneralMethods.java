import java.io.*;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class GeneralMethods {
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

    private void writeToFile(Path path, String dataReadyToAdd){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()))){
            List<String> fullUserData = readFromFile(path);
            fullUserData.add(dataReadyToAdd);
            writer.write(String.join("\n", fullUserData));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
