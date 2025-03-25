// Class to find the first and last occurrence of an element in a sorted array
public class FirstAndLastOccurrence {
    public static void main(String[] args) {
        // Declare a sorted array and initialize it with sorted value
        int[] numbers = {1, 2, 2, 2, 3, 4, 5, 5, 6};
        // Initialize the target value
        int target = 2;

        // methods to find the first and last occurrences of a target element
        int firstOccurrence = findFirstOccurrence(numbers, target);
        int lastOccurrence = findLastOccurrence(numbers, target);

        // Display the results
        System.out.printf("First Occurrence Index of %d: %d\n", target, firstOccurrence);
        System.out.printf("Last Occurrence Index of %d: %d\n", target, lastOccurrence);
    }

    // method to find the first occurrence of an element
    static int findFirstOccurrence(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1, result = -1;

        while(left<=right) {
            int mid = left + (right-left) / 2;
            if(numbers[mid]==target) {
                result = mid;
                right = mid - 1; // Search in the left half
            }
            else if(numbers[mid]<target) left = mid + 1;
            else right = mid - 1;
        }

        return result;
    }

    // method to find the last occurrence of an element
    static int findLastOccurrence(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1, result = -1;

        while(left<=right) {
            int mid = left + (right-left) / 2;
            if(numbers[mid]==target) {
                result = mid;
                left = mid + 1; // Search in the right half
            }
            else if(numbers[mid]<target) left = mid + 1;
            else right = mid - 1;
        }

        return result;
    }
}
// Sample Output ->
// First Occurrence Index of 2: 1
// Last Occurrence Index of 2: 3