// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/

public class LongestIncreasingPathInMatrix {
	
	private int[][] matrix;
	private int rows;
	private int cols;
	private int[][] memo;
	// direction offsets (up, down, left, right)
	private final int[][] dirOffsets = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null) {
			return 0;
		}
		
		this.matrix = matrix;
		this.rows = matrix.length;
		this.cols = matrix[0].length;
		this.memo = new int[rows][cols];
		
		int maxLength = 0;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				maxLength = Math.max(maxLength, dfs(i, j));
			}
		}
		
		return maxLength;
	}
	
	// 🧩dfs🧩
	private int dfs(int curr_row, int curr_col) {
		// If current cell already memoized, return.
		if (memo[curr_row][curr_col] != 0) {
			return memo[curr_row][curr_col];
		}
		
		// else, explore the 4 directions
		int maxLen = 1;
		for (int[] dirOffset : dirOffsets) {
			int neighborI = curr_row + dirOffset[0];
			int neighborJ = curr_col + dirOffset[1];
			if (neighborI >= 0 && neighborI < rows && neighborJ >= 0 && neighborJ < cols) {
				// check whether path increases
				if (matrix[neighborI][neighborJ] > matrix[curr_row][curr_col]) {
					int newPathLen = 1 + dfs(neighborI, neighborJ);
					maxLen = Math.max(maxLen, newPathLen);
				}
			}
		}
		
		// memoize the result before returning
		memo[curr_row][curr_col] = maxLen;
		return maxLen;
	}
	
	// 🧩main🧩
	public static void main(String[] args) {
		LongestIncreasingPathInMatrix ourObj = new LongestIncreasingPathInMatrix();
		
		int[][] matrix1 = {
				{9, 9, 4},
				{6, 6, 8},
				{2, 1, 1}
		};
		System.out.println("LIP for Matrix 1: " + ourObj.longestIncreasingPath(matrix1));
		
		int[][] matrix2 = {
				{3, 4, 5},
				{3, 2, 6},
				{2, 2, 1}
		};
		System.out.println("LIP for Matrix 2: " + ourObj.longestIncreasingPath(matrix2));
	}
}