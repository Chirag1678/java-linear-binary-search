// Class to search a target value in a 2D sorted matrix
public class SearchValueMatrix {
    public static void main(String[] args) {
        // Create a 2D matrix and initialize it with sorted values, also declare a target value
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;

        // Display the result
        System.out.printf("Target " + target + " found: " + (searchMatrix(matrix, target) ? "Yes" : "No"));
    }

    // method to search target element in a matrix using binary search
    static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = rows * cols - 1;

        while(left<=right) {
            int mid = left + (right-left) / 2;
            int value = matrix[mid/cols][mid%cols];

            if(value==target) return true;
            else if(value<target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return false;
    }
}
// Sample Output ->
//Target 3 found: Yes