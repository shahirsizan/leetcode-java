// CPS academy DSA sheet (Matrix)
// https://leetcode.com/problems/word-search/description/?envType=problem-list-v2&envId=backtracking

package matrix;

public class WordSearch {
	public boolean exist(char[][] givenBoard, String targetWord) {
		int rows = givenBoard.length;
		int cols = givenBoard[0].length;
		boolean result = false;
		
		for (int currRow = 0; currRow < rows; currRow++) {
			for (int currCol = 0; currCol < cols; currCol++) {
				// traverse all cells of the matrix, upon finding the first match, start DFS
				if (givenBoard[currRow][currCol] == targetWord.charAt(0)) {
					result = wordSearchHelper(givenBoard, currRow, currCol, targetWord, 0);
					if (result) {
						return result;
					}
				}
			}
		}
		return result;
	}
	
	// wordSearchHelper() method signature:
	// wordSearchHelper(matrix, currRow, currCol, target string, current index of string)
	
	private boolean wordSearchHelper(char[][] givenBoard, int currRow, int currCol, String targetWord, int currStartIdx) {
		// base case 1: `currStartIdx` equals to target length, meaning target word achieved
		if (currStartIdx == targetWord.length()) {
			return true;
		}
		
		// base case 2: current character doesn't match OR out of boundary
		if (currRow < 0 || currRow >= givenBoard.length ||
				currCol < 0 || currCol >= givenBoard[0].length ||
				givenBoard[currRow][currCol] != targetWord.charAt(currStartIdx)) {
			return false;
		}
		
		// current character matches,
		// mark it as `visited`/`#` so that re-calculation won't happen in future
		// and explore all 4 adjacent cells (options)
		char temp = givenBoard[currRow][currCol];
		givenBoard[currRow][currCol] = '#';
		boolean isFound = wordSearchHelper(givenBoard, currRow, currCol + 1, targetWord, currStartIdx + 1) ||
				wordSearchHelper(givenBoard, currRow, currCol - 1, targetWord, currStartIdx + 1) ||
				wordSearchHelper(givenBoard, currRow + 1, currCol, targetWord, currStartIdx + 1) ||
				wordSearchHelper(givenBoard, currRow - 1, currCol, targetWord, currStartIdx + 1);
		
		// backtrack: restore original
		givenBoard[currRow][currCol] = temp;
		// return result
		return isFound;
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		WordSearch myObj = new WordSearch();
		char[][] board = {
				{'A', 'B', 'C', 'E'},
				{'S', 'F', 'C', 'S'},
				{'A', 'D', 'E', 'E'}
		};
		
		System.out.println("Word 'ABCCED': " + myObj.exist(board, "ABCCED")); // true
		System.out.println("Word 'SEE': " + myObj.exist(board, "SEE"));       // true
		System.out.println("Word 'ABCB': " + myObj.exist(board, "ABCB"));     // false
	}
}