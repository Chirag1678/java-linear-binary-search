// Class to find the rotation point in a sorted array
public class RotationPointArray {
    public static void main(String[] args) {
        // Create an array and initialize with values in rotated sorted order
        int[] numbers = {7, 8, 9, 1, 2, 3, 4, 5, 6};

        // find the index of rotated point
        int index = findRotationPoint(numbers);

        // Display the result
        System.out.printf("The index of rotation point is %d and the element is %d.", index, numbers[index]);
    }

    // method to find the index of the rotation point in array
    static int findRotationPoint(int[] numbers) {
        int left = 0, right = numbers.length - 1;

        while(left<right) {
            int mid = left + (right-left) / 2;

            if(numbers[mid]>numbers[right]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left; // Index of smallest element
    }
}
// Sample Output ->
//The index of rotation point is 3 and the element is 1.