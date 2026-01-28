// https://leetcode.com/problems/unique-paths/description/

public class UniquePathsDP {
	
	private int[][] dp;
	
	public int uniquePaths(int row, int col) {
		dp = new int[row][col];
		// input `row-col` are 1 based. But we need 0 based index. So sending `row-col` arguments by subtracting 1.
		// for input `row-col` 3 and 8, we are calling `recursive(dp, 2, 7)`
		int result = recursive(dp, row - 1, col - 1);
		return result;
	}
	
	private int recursive(int[][] dp, int row, int col) {
		// check whether index out of bound
		if (row == -1 || col == -1) {
			return 0;
		}
		
		// anywhere in row 0, only way to traverse is to the right. No way to come from above.
		// anywhere in col 0, only way to traverse is down. No way to come from left.
		if (row == 0 || col == 0) {
			return 1;
		}
		
		// for overlapping calculations, check dp[][]
		if (dp[row][col] != 0) {
			return dp[row][col];
		}
		
		// # of ways to reach this particular [row][col] is:
		// # of ways from immediate above cell + # of ways from immediate left cell
		// this recursion will eventually lead us up to starting point [0][0] which has a base case return of `1`.
		int noOfWaysToReachHere = recursive(dp, row - 1, col) + recursive(dp, row, col - 1);
		dp[row][col] = noOfWaysToReachHere;
		return dp[row][col];
	}
	
	
	// ✅ main() ✅
	public static void main(String[] args) {
		UniquePathsDP myObj = new UniquePathsDP();
		
		
		int m1 = 3, n1 = 7;
		System.out.println("Input: m = " + m1 + ", n = " + n1);
		System.out.println("Unique Paths: " + myObj.uniquePaths(m1, n1));
		
		
		int m2 = 3, n2 = 2;
		System.out.println("\nInput: m = " + m2 + ", n = " + n2);
		System.out.println("Unique Paths: " + myObj.uniquePaths(m2, n2));
		
		int m3 = 10, n3 = 10;
		System.out.println("\nInput: m = " + m3 + ", n = " + n3);
		System.out.println("Unique Paths: " + myObj.uniquePaths(m3, n3));
	}
}