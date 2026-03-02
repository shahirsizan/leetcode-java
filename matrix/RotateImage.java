// CPS academy DSA sheet (Matrix)
// https://leetcode.com/problems/rotate-image/description/

package matrix;

public class RotateImage {
	
	public void rotate(int[][] givenMatrix) {
		// square matrix, so rows == cols
		int rows = givenMatrix.length;
		int cols = givenMatrix.length;
		
		// first transpose the matrix, swap elements across the `main` diagonal
		// process only the `upper-right` triangle, the `lower-left` will be swapped automatically
		// for each new row `i`, col `j` will start from `i`, not `0`.
		for (int i = 0; i < rows; i++) {
			for (int j = i; j < cols; j++) {
				// swap
				int temp = givenMatrix[i][j];
				givenMatrix[i][j] = givenMatrix[j][i];
				givenMatrix[j][i] = temp;
			}
		}
		
		// flip the `transposed` matrix around the `vertical` axis
		for (int row = 0; row < rows; row++) {
			int leftPointer = 0;
			int rightPointer = cols - 1;
			
			while (leftPointer < rightPointer) {
				// swap
				int temp = givenMatrix[row][leftPointer];
				givenMatrix[row][leftPointer] = givenMatrix[row][rightPointer];
				givenMatrix[row][rightPointer] = temp;
				
				leftPointer++;
				rightPointer--;
			}
		}
		
	}
	
	// 🧩 printMatrix() 🧩
	private static void printMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			for (int val : row) {
				System.out.printf("%2d ", val);
			}
			System.out.println();
		}
	}
	
	// 🧩 main() 🧩
	public static void main(String[] args) {
		RotateImage ourObj = new RotateImage();
		int[][] matrix = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		
		System.out.println("Input:");
		printMatrix(matrix);
		
		ourObj.rotate(matrix);
		
		System.out.println("\nOutput:");
		printMatrix(matrix);
		
	}
	
	
}