public class SetMatrixZeroes {
	
	public void setZeroes(int[][] matrix) {
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		// type[] varName = new type[count]
		// All array elements are initialized to 'false'
		boolean[] zeroRows = new boolean[rows];
		boolean[] zeroCols = new boolean[cols];
		
		// first pass: identify zero cells
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] == 0) {
					zeroRows[i] = true;
					zeroCols[j] = true;
				}
			}
		}
		
		// second pass: nullify rows and cols
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (zeroRows[i] || zeroCols[j]) {
					matrix[i][j] = 0;
				}
			}
		}
	}
	
	// 🧩🧩🧩
	private static void printMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			for (int val : row) {
				System.out.printf("%2d ", val);
			}
			System.out.println();
		}
	}
	
	// 🧩🧩🧩
	public static void main(String[] args) {
		SetMatrixZeroes solver = new SetMatrixZeroes();
		
		int[][] matrix1 = {
				{1, 1, 1},
				{1, 0, 1},
				{1, 1, 1}
		};
		
		System.out.println("--- Example 1: Input ---");
		printMatrix(matrix1);
		solver.setZeroes(matrix1);
		System.out.println("--- Example 1: Output ---");
		printMatrix(matrix1);
		// Expected:
		//  1  0  1
		//  0  0  0
		//  1  0  1
		System.out.println("\n" + "-".repeat(30) + "\n");
		
		int[][] matrix2 = {
				{0, 1, 2, 0},
				{3, 4, 5, 2},
				{1, 3, 1, 5}
		};
		
		System.out.println("--- Example 2: Input ---");
		printMatrix(matrix2);
		solver.setZeroes(matrix2);
		System.out.println("--- Example 2: Output ---");
		printMatrix(matrix2);
		// Expected:
		//  0  0  0  0
		//  0  4  5  0
		//  0  3  1  0
	}
}
