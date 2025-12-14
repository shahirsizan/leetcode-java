public class RotateImage {
	
	public void rotate(int[][] matrix) {
		if (matrix == null) {
			return;
		}
		
		// square matrix, so rows == cols
		int rows = matrix.length;
		
		// transpose the matrix, swap elements across the `main` diagonal
		// process only the `upper-right` triangle, the `lower-left` will be swapped automatically
		for (int i = 0; i < rows; i++) {
			for (int j = i; j < rows; j++) {
				// swap
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		
		// flip the `transposed` matrix around the `vertical` axis
		for (int i = 0; i < rows; i++) {
			int leftMost = 0;
			int rightMost = rows - 1;
			
			while (leftMost < rightMost) {
				int temp = matrix[i][leftMost];
				matrix[i][leftMost] = matrix[i][rightMost];
				matrix[i][rightMost] = temp;
				
				leftMost++;
				rightMost--;
			}
		}
		
	}
	
	// 🧩 helper 🧩
	private static void printMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			for (int val : row) {
				System.out.printf("%2d ", val);
			}
			System.out.println();
		}
	}
	
	// 🧩 main 🧩
	public static void main(String[] args) {
		RotateImage ourObj = new RotateImage();
		int[][] matrix1 = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		
		System.out.println("--- Matrix 1 Input ---");
		printMatrix(matrix1);
		
		ourObj.rotate(matrix1);
		
		System.out.println("\n--- Matrix 1 after Rotating 90° Clockwise ---");
		printMatrix(matrix1);
		
	}
	
	
}