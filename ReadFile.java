import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Class to read a file line-by-line
public class ReadFile {
    public static void main(String[] args) {
        // Specify the file name
        String fileName = "FileReader.txt";

        // method to read file line by line
        readFile(fileName);
    }

    // method to read file using FileReader and BufferReader
    static void readFile(String fileName) {
        // Ue try-catch to read file and handle exception
        try(FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch(IOException e) {
            System.err.print("Error reading file: " + e.getMessage());
        }
    }
}
// Sample Output ->
// Java is a programming language that was developed by James Gosling of Sun Microsystems.
// It was released in 1995 and is a key part of the Sun Java platform.
// Java is a widely used programming language that can run on many devices and operating systems.

// Features of Java :-
// Easy to learn and use
// Object-oriented programming
// Platform independence
// Automatic memory management
// Security
// Rich API
// Multithreading
// High performance