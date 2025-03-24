import java.util.HashSet;
import java.util.Scanner;

// Class to remove duplicate characters from a string
public class RemoveDuplicates {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a String: ");
        String s = input.nextLine();

        // remove duplicates using HashSet and StringBuilder
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();

        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(!set.contains(c)) {
                sb.append(c);
            }
            set.add(c);
        }

        String result = sb.toString();

        // Display the result
        System.out.printf("String %s after duplicates removed is: %s", s, result);

        input.close();
    }
}
// Sample Output ->
// Enter a String: hello world!
// String hello world! after duplicates removed is: helo wrd!