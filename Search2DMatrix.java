public class Search2DMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int leftPointer = 0;
		int rightPointer = (rows * cols) - 1;

		while (leftPointer <= rightPointer) {
			int mid = leftPointer + (rightPointer - leftPointer) / 2;
			// derive the corresponding 2D index from 1D index 'mid'
			int row = mid / cols;
			int col = mid % cols;

			int currentValue = matrix[row][col];

			if (currentValue == target) {
				return true;
			} else if (currentValue < target) {
				leftPointer = mid + 1;
			} else {
				rightPointer = mid - 1;
			}
		}

		return false;
	}

	// --- Main Method for Demonstration ---

	public static void main(String[] args) {
		Search2DMatrix solver = new Search2DMatrix();

		int[][] matrix1 = {
				  {1, 3, 5, 7},
				  {10, 11, 16, 20},
				  {23, 30, 34, 60}
		};
		int target1 = 3;
		boolean result1 = solver.searchMatrix(matrix1, target1);
		System.out.println("--- Example 1 ---");
		System.out.println("Target: " + target1 + ", Found: " + result1 + " (Expected: true)");

		System.out.println("-----------------");

		int target2 = 13;
		boolean result2 = solver.searchMatrix(matrix1, target2);
		System.out.println("--- Example 2 ---");
		System.out.println("Target: " + target2 + ", Found: " + result2 + " (Expected: false)");
	}
}