// CPS academy DSA sheet (Recursion and Backtracking)
// https://leetcode.com/problems/n-queens/description/

package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> resultList = new ArrayList<>();
		
		// Define a `n * n` board
		char[][] board = new char[n][n];
		for (char[] row : board) {
			Arrays.fill(row, '.');
		}
		
		// Constraints tracking
		boolean[] checkCols = new boolean[n];
		boolean[] checkPosDiag = new boolean[2 * n];
		boolean[] checkNegDiag = new boolean[2 * n];
		
		backtrack(board, 0, n, checkCols, checkPosDiag, checkNegDiag, resultList);
		
		return resultList;
	}
	
	private void backtrack(char[][] board, int currRow, int totalCols,
	                       boolean[] checkCols, boolean[] checkPosDiag,
	                       boolean[] checkNegDiag, List<List<String>> resultList) {
		// Base case 1: If currRow exceeds row limit, means we achieved our answer
		if (currRow == totalCols) {
			resultList.add(construct(board));
			return;
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
			backtrack(board, currRow + 1, totalCols, checkCols, checkPosDiag, checkNegDiag, resultList);
			
			// 3. Backtrack and discard option
			board[currRow][currCol] = '.';
			checkCols[currCol] = false;
			checkPosDiag[currRow + currCol] = false;
			checkNegDiag[currRow - currCol + totalCols - 1] = false;
		}
	}
	
	private List<String> construct(char[][] board) {
		List<String> path = new ArrayList<>();
		for (char[] row : board) {
			path.add(new String(row));
		}
		
		return path;
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		NQueens myObj = new NQueens();
		
		List<List<String>> solutions = myObj.solveNQueens(4);
		System.out.println("Solution for 4-Queens: " + solutions);
		for (List<String> sol : solutions) {
			for (String row : sol) {
				System.out.println(row);
			}
			System.out.println();
		}
	}
}