import java.io.*;
import java.nio.charset.StandardCharsets;

// Class to compare time taken by StringBuffer and Builder, and InputStreamReader and FileReader
public class StringsVsReaders {
    public static void main(String[] args) {
        // Compare StringBuffer and StringBuilder
        compareBufferAndBuilder();

        // File path to store large text file
        String fileName = "challenge_problem.txt";

        // method to generate a large file of about 100MB
        generateFile(fileName, 100 * 1024 * 1024);

        // compare FileReader and InputStreamReader
        compareFileReaders(fileName);
    }

    // method to compare StringBuffer and StringBuilder
    static void compareBufferAndBuilder() {
        String text = "hello";
        int iterations = 1000000; // no of iterations to loop

        // StringBuilder time test
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<iterations;i++) {
            sb.append(text);
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuilder time: " + (endTime - startTime) / 1e6 + " ms");

        // StringBuffer Time Test
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for(int i=0;i<iterations;i++) {
            sbf.append(text);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer time: " + (endTime - startTime) / 1e6 + " ms");
        System.out.println();
    }

    // method to generate a large file
    static void generateFile(String fileName, int byteSize) {
        File file = new File(fileName);
        if (file.exists() && file.length() >= byteSize) {
            System.out.println("Large file already exists.");
            return;
        }

        try (BufferedWriter writer=new BufferedWriter(new FileWriter(file))) {
            String sampleText = "This is a sample text file with repeated words.";
            int repeats = byteSize / sampleText.length();
            for(int i=0;i<repeats;i++) {
                writer.write(sampleText);
            }
            System.out.println("Large file created: " + fileName);
        } catch (IOException e) {
            System.out.println("Error generating large file: " + e.getMessage());
        }
    }

    // method to compare FileReader and InputStreamReader
    static void compareFileReaders(String fileName) {
        long startTime, endTime;

        // Using FileReader
        startTime = System.nanoTime();
        try (FileReader fr = new FileReader(fileName);
             BufferedReader br = new BufferedReader(fr)) {
            long wordCount = br.lines().flatMap(line -> java.util.Arrays.stream(line.split("\\s+"))).count();
            System.out.println("FileReader word count: " + wordCount);
        } catch (IOException e) {
            System.out.println("Error reading file with FileReader: " + e.getMessage());
        }
        endTime = System.nanoTime();
        System.out.println("FileReader time: " + (endTime - startTime) / 1e6 + " ms");

        // Using InputStreamReader
        startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(fileName);
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(isr)) {
            long wordCount = br.lines().flatMap(line -> java.util.Arrays.stream(line.split("\\s+"))).count();
            System.out.println("InputStreamReader word count: " + wordCount);
        } catch (IOException e) {
            System.out.println("Error reading file with InputStreamReader: " + e.getMessage());
        }
        endTime = System.nanoTime();
        System.out.println("InputStreamReader time: " + (endTime - startTime) / 1e6 + " ms");
    }
}
// Sample Output ->
// StringBuilder time: 14.439125 ms
// StringBuffer time: 19.561375 ms

// Large file created: challenge_problem.txt
// FileReader word count: 17848097
// FileReader time: 1893.596291 ms
// InputStreamReader word count: 17848097
// InputStreamReader time: 1463.559167 ms