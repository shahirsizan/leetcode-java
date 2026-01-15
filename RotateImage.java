public class RotateImage {
	
	public void rotate(int[][] givenMatrix) {
		// square matrix, so rows == cols
		int rows = givenMatrix.length;
		int cols = givenMatrix.length;
		
		// transpose the matrix, swap elements across the `main` diagonal
		// process only the `upper-right` triangle, the `lower-left` will be swapped automatically
		for (int i = 0; i < rows; i++) {
			for (int j = i; j < cols; j++) {
				// swap
				int temp = givenMatrix[i][j];
				givenMatrix[i][j] = givenMatrix[j][i];
				givenMatrix[j][i] = temp;
			}
		}
		
		// flip the `transposed` matrix around the `vertical` axis
		for (int i = 0; i < rows; i++) {
			int leftMost = 0;
			int rightMost = cols - 1;
			
			while (leftMost < rightMost) {
				int temp = givenMatrix[i][leftMost];
				givenMatrix[i][leftMost] = givenMatrix[i][rightMost];
				givenMatrix[i][rightMost] = temp;
				
				leftMost++;
				rightMost--;
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
		int[][] matrix1 = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		
		System.out.println("--- Matrix 1 Input ---");
		printMatrix(matrix1);
		
		ourObj.rotate(matrix1);
		
		System.out.println("\n--- Matrix 1 output after 90 degree rotation ---");
		printMatrix(matrix1);
		
	}
	
	
}