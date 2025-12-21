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
		// if index out of bound, there is no way to reach to that index from [0][0]
		if (row == -1 || col == -1) {
			return 0;
		}
		
		// anywhere in the first row, only way from [0][0] is to traverse right
		// anywhere in the first col, only way from [0][0] is to traverse downwards
		if (row == 0 || col == 0) {
			return 1;
		}
		
		// for overlapping calculations, check dp[][]
		if (dp[row][col] != 0) {
			return dp[row][col];
		}
		
		// # of ways from [0][0] to this particular [row][col] is:
		// # of ways from [0][0] to `immediate above cell + immediate left cell`
		// this recursion will eventually send us up to the cell [0][0] which has a base case return of `1`.
		dp[row][col] = recursive(dp, row - 1, col) + recursive(dp, row, col - 1);
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