import java.util.Scanner;

// Class to find the first negative number in an array
public class FirstNegativeNumber {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter number of integers: ");
        int n = input.nextInt();

        int[] numbers = new int[n];

        // loop tot take integer inputs
        for(int i=0;i<n;i++) {
            System.out.print("Enter Integer " + (i+1) + ": ");
            numbers[i] = input.nextInt();
        }

        // find the index of first negative number
        int index = firstNegative(numbers);

        if(index!=-1) {
            System.out.println("First negative number found at index " + index);
        } else {
            System.out.println("No negative number found in the array.");
        }

        input.close();
    }

    // method to find the first negative number
    static int firstNegative(int[] numbers) {
        // loop to find the index
        for(int i=0;i<numbers.length;i++) {
            if(numbers[i]<0) return i;
        }
        // if no negative number found return -1;
        return -1;
    }
}
// Sample Output ->
// Enter number of integers: 7
// Enter Integer 1: 5
// Enter Integer 2: 4
// Enter Integer 3: -1
// Enter Integer 4: 2
// Enter Integer 5: 0
// Enter Integer 6: -3
// Enter Integer 7: 6
// First negative number found at index 2