// CPS academy DSA sheet (Recursion and Backtracking)
// https://leetcode.com/problems/n-queens-ii/description/

package RecursionAndBacktracking;

import java.util.Arrays;

public class NQueensII {
	public int totalNQueens(int n) {
		int count = 0;
		
		// Define a `n * n` board
		char[][] board = new char[n][n];
		for (char[] row : board) {
			Arrays.fill(row, '.');
		}
		
		// Constraints tracking
		boolean[] checkCols = new boolean[n];
		boolean[] checkPosDiag = new boolean[2 * n];
		boolean[] checkNegDiag = new boolean[2 * n];
		
		count = backtrack(board, 0, n, checkCols, checkPosDiag, checkNegDiag);
		
		return count;
	}
	
	private int backtrack(char[][] board, int currRow, int totalCols,
	                      boolean[] checkCols, boolean[] checkPosDiag,
	                      boolean[] checkNegDiag) {
		int count = 0;
		
		// Base case 1: If currRow exceeds row limit, means we achieved our answer
		if (currRow == totalCols) {
			return 1;
		}
		
		/**
		 * To get the insight of how the diagonals indexes are calculated,
		 * I've drawn a diagram. It is in the `RecursionAndBacktracking` folder .
		 * */
		
		for (int currCol = 0; currCol < totalCols; currCol++) {
			// If queen already exists, go to next iteration
			if (checkCols[currCol] || checkPosDiag[currRow + currCol] || checkNegDiag[currRow - currCol + totalCols - 1]) {
				continue;
			}
			
			// 1. Select option
			board[currRow][currCol] = 'Q';
			checkCols[currCol] = true;
			checkPosDiag[currRow + currCol] = true;
			checkNegDiag[currRow - currCol + totalCols - 1] = true;
			
			// 2. Explore option
			count += backtrack(board, currRow + 1, totalCols, checkCols, checkPosDiag, checkNegDiag);
			
			// 3. Backtrack and discard option
			board[currRow][currCol] = '.';
			checkCols[currCol] = false;
			checkPosDiag[currRow + currCol] = false;
			checkNegDiag[currRow - currCol + totalCols - 1] = false;
		}
		
		return count;
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		NQueensII myObj = new NQueensII();
		
		int count = 0;
		count = myObj.totalNQueens(4);
		System.out.println("Solution for 4-Queens: " + count);
		
	}
}