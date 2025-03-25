import java.io.*;

// Class to take user input from console and write it to file
public class UserInputToFile {
    public static void main(String[] args) {
        // Declare a file path where the file will be created
        String fileName = "InputFormUser.txt";

        // Create an InputStreamReader to read from the console
        try (InputStreamReader isr=new InputStreamReader(System.in);
             BufferedReader br=new BufferedReader(isr);
             FileWriter fw=new FileWriter(fileName, true);  // Append mode
             BufferedWriter bw=new BufferedWriter(fw)) {

            System.out.println("Enter text (type 'exit' to stop):");

            String input;
            while (!(input=br.readLine()).equalsIgnoreCase("exit")) {
                bw.write(input);
                bw.newLine();  // Write input as a new line
            }

            System.out.println("User input saved to " + fileName);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
// Sample Output ->
// Enter text (type 'exit' to stop):
// Hello, this is a test file.
// It contains multiple lines.
// This file is encoded in UTF-8.
// Enjoy reading this file using InputStreamReader!
// exit

// User input saved to InputFormUser.txt