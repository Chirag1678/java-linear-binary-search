import java.util.Scanner;

// Class to concatenate strings
public class ConcatStrings {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter number of Strings: ");
        int n = input.nextInt();

        String[] strings = new String[n];

        // loop to take string inputs
        for(int i=0;i<n;i++) {
            System.out.print("Enter String " + (i+1) + ": ");
            strings[i] = input.next();
        }

        // Concatenate strings efficiently using StringBuffer
        StringBuffer sb = new StringBuffer();

        for(String s:strings) {
            sb.append(s).append(" ");
        }

        String result = sb.toString();

        // Display the result
        System.out.print("Resulted string after concatenation: " + result);

        input.close();
    }
}
// Sample Output ->
// Enter number of Strings: 7
// Enter String 1: Hello
// Enter String 2: world
// Enter String 3: how 
// Enter String 4: is
// Enter String 5: it 
// Enter String 6: been
// Enter String 7: going
// Resulted string after concatenation: Hello world how is it been going 