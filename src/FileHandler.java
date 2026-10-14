

import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileHandler {

    private static final String FILE_NAME = "fitness_data.txt";

    public static void saveToFile(String data) {

        try {
            FileWriter writer = new FileWriter(FILE_NAME, true);
            writer.write(data + "\n");
            writer.close();

            System.out.println("Data saved to file successfully!");

        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }

    public static void readFromFile() {

        try {
            BufferedReader reader =
                    new BufferedReader(new FileReader(FILE_NAME));

            String line;

            System.out.println("\n===== FILE DATA =====");

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }
}