import java.util.Scanner;

// Class to find the first occurrence of a word in list of Strings
public class WordInString {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter number of Strings: ");
        int n = input.nextInt();
        input.nextLine(); // Consume newLine

        String[] strings = new String[n];

        // loop to take string inputs
        for(int i=0;i<n;i++) {
            System.out.print("Enter String " + (i+1) + ": ");
            strings[i] = input.nextLine();
        }

        System.out.print("Enter the word to find: ");
        String target = input.next();

        // method to find and return the first sentence containing the target word
        findSentence(strings, target);

        input.close();
    }

    // method to find and print the string containing the word
    static void findSentence(String[] strings, String target) {
        for(String s:strings) {
            for(String word:s.split(" ")) {
                if(word.equalsIgnoreCase(target)) {
                    System.out.printf("The word '%s' found in sentence: %s", target, s);
                    return;
                }
            }
        }
        System.out.printf("No String found with word '%s'", target);
    }
}
// Sample Output ->
// Enter number of Strings: 3
// Enter String 1: Hello World
// Enter String 2: Java is a programming language
// Enter String 3: Python is also a programming language
// Enter the word to find: programming
// The word 'programming' found in sentence: Java is a programming language