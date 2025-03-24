import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Class to count number of occurrences of a word in a file
public class CountOccurrence {
    public static void main(String[] args) {
        // Specify fileName and target word
        String fileName = "FileReader.txt";
        String target = "Java";

        // method to count the occurrences of thw word
        int count = totalCount(fileName, target);

        // Display the result
        System.out.println("The word '" + target + "' appears " + count + " times in the file.");
    }

    static int totalCount(String fileName, String target) {
        int count = 0;
        // Use try-catch to handle exceptions
        try (FileReader fr = new FileReader(fileName);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+"); // Split line into words
                for (String word : words) {
                    if (word.equalsIgnoreCase(target)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return count;
    }
}
// Sample Output ->
//The word 'Java' appears 12 times in the file.