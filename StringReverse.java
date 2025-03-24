import java.util.Scanner;

// Class to reverse a string using stringbuilder
public class StringReverse {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a String: ");
        String s = input.nextLine();

        // reverse the string using StringBuilder
        StringBuilder sb = new StringBuilder(s);

        // reverse the string and convert it to a string
        String reversed = sb.reverse().toString();

        // Display the result
        System.out.printf("The reverse string of %s is: %s", s, reversed);

        input.close();
    }
}
// Sample Output ->
// Enter a String: hello world!
// The reverse string of hello world! is: !dlrow olleh