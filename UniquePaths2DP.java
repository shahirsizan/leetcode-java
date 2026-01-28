// https://leetcode.com/problems/unique-paths-ii/

public class UniquePaths2DP {
	
	private int[][] dp;
	
	public int uniquePathsWithObstacles(int[][] givenObstacleGrid) {
		int rows = givenObstacleGrid.length;
		int cols = givenObstacleGrid[0].length;
		dp = new int[rows][cols];
		// input `row-col` are 1 based. But we need 0 based index. So sending `row-col` arguments by subtracting 1.
		int result = recursive(givenObstacleGrid, dp, rows - 1, cols - 1);
		return result;
	}
	
	private int recursive(int[][] givenObstacleGrid, int[][] dp, int currRow, int currCol) {
		// check whether starting position AND not obstacle
		if (currRow == 0 && currCol == 0 && givenObstacleGrid[currRow][currCol] == 0) {
			return 1;
		}
		// check whether index out of bound
		if (currRow == -1 || currCol == -1) {
			return 0;
		}
		
		// check whether obstacle or not
		if (givenObstacleGrid[currRow][currCol] == 1) {
			return 0;
		}
		
		// for overlapping calculations, check dp[][]
		if (dp[currRow][currCol] != 0) {
			return dp[currRow][currCol];
		}
		
		// # of ways to reach this particular [row][col] is:
		// # of ways from immediate above cell + # of ways from immediate left cell
		// this recursion will eventually lead us up to starting point [0][0] which has a base case return of `1`.
		int noOfWaysToReachHere = recursive(givenObstacleGrid, dp, currRow - 1, currCol)
				+ recursive(givenObstacleGrid, dp, currRow, currCol - 1);
		dp[currRow][currCol] = noOfWaysToReachHere;
		return dp[currRow][currCol];
	}
	
	
	// ✅ main() ✅
	public static void main(String[] args) {
		UniquePaths2DP myObj = new UniquePaths2DP();
		
		int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
		int[][] obstacleGrid2 = {{1, 0}};
		System.out.println("Unique Paths: " + myObj.uniquePathsWithObstacles(obstacleGrid2));
	}
}