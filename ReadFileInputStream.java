import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

// Class to read byte data and convert it to character data and print it
public class ReadFileInputStream {
    public static void main(String[] args) {
        // Declare a variable and store file path in it
        String fileName = "InputStream.txt";

        // method to read and print using InputStreamReader
        convertAndDisplay(fileName);
    }

    // method to read and console the file data
    static void convertAndDisplay(String fileName) {
        // Use try-catch to handle exception
        try (FileInputStream fis = new FileInputStream(fileName);
             InputStreamReader ir = new InputStreamReader(fis, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(ir)) {

            System.out.println("Reading from binary file:");
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
// Sample Output ->
// Reading from binary file:
// Hello, this is a test file.
// It contains multiple lines.
// This file is encoded in UTF-8.
// Enjoy reading this file using InputStreamReader!