import java.util.Scanner;

// Class to find the peak element in an array
public class PeakElement {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter number of elements: ");
        int n = input.nextInt();

        int[] numbers = new int[n];

        // loop to take number inputs
        for(int i=0;i<n;i++) {
            System.out.print("Enter number " + (i+1) + ": ");
            numbers[i] = input.nextInt();
        }

        // find the index of peak element
        int index = findPeak(numbers);

        // Display the result
        System.out.printf("The index of peak element is %d, and the peak element is %d", index, numbers[index]);

        input.close();
    }

    // method to find the peak element in array using binary search
    static int findPeak(int[] numbers) {
        int left = 0, right = numbers.length - 1;

        while(left<right) {
            int mid = left + (right-left) / 2;

            if(numbers[mid]>numbers[mid+1] && numbers[mid]>numbers[mid-1]) {
                return mid;
            }
            else if(numbers[mid]<numbers[mid-1]) {
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }
        return -1;
    }
}
// Sample Output ->
// Enter number of elements: 6
// Enter number 1: 1
// Enter number 2: 3
// Enter number 3: 20
// Enter number 4: 4
// Enter number 5: 1
// Enter number 6: 0
// The index of peak element is 2, and the peak element is 20