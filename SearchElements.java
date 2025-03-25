import java.util.Scanner;

// Class to find the first missing positive integer in an array and index of a given target in array
public class SearchElements {
    public static void main(String[] args) {
        // Procedure to find first missing positive integer using linear search
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter number of elements: ");
        int n = input.nextInt();

        int[] numbers = new int[n];

        // loop to take element inputs
        System.out.printf("Enter %d elements in array: ", n);
        for(int i=0;i<n;i++) {
            numbers[i] = input.nextInt();
        }

        // find the first missing positive integer in an array
        int missingPositive = findFirstPositive(numbers);

        // Display the result
        System.out.println("First missing positive integer is: " + missingPositive);
        System.out.println();

        input.close();

        // Procedure to find target element in an array
        // Declare an array and initialize it with sorted values
        int[] sortedNumbers = {1, 2, 3, 4, 5, 6, 7};
        // Declare the target value
        int target = 4;

        // find the index of target element
        int index = findTarget(sortedNumbers, target);

        // Display the result
        System.out.println("Index of " + target + ": " + index);
    }

    // method to find the first missing positive integer
    static int findFirstPositive(int[] numbers) {
        int n = numbers.length;

        for(int i=0;i<n;i++) {
            while(numbers[i]>0  && numbers[i]<=n &&  numbers[numbers[i]-1]!=numbers[i]) {
                int temp = numbers[i];
                numbers[i] = numbers[temp-1];
                numbers[temp-1] = temp;
            }
        }
        for(int i=0;i<n;i++) {
            if(numbers[i]!=i+1) {
                return i+1;
            }
        }
        return n+1;
    }

    // method to find the target element
    static int findTarget(int[] sortedNumbers, int target) {
        int left = 0 , right = sortedNumbers.length - 1;

        while(left<=right) {
            int mid = left + (right-left) / 2;
            if(sortedNumbers[mid]==target) return mid;
            else if(sortedNumbers[mid]<target) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }
}
// Sample Output ->
// Enter number of elements: 6
// Enter 6 elements in array: 1 2 0 4 5 6
// First missing positive integer is: 3

// Index of 4: 3