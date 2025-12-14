public class GameOfLife {
	
	public void gameOfLife(int[][] board) {
		if (board == null) {
			return;
		}
		
		int rows = board.length;
		int cols = board[0].length;
		
		// first Pass: introduce new states (2 , 3) to represent future changes
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				
				int originalState = board[i][j];
				int liveNeighborsCount = countLiveNeighbors(board, rows, cols, i, j);
				
				//  for 0 -> 1; updated state will be 2
				//  for 1 -> 0; updated state will be 3
				//  for 0 -> 0 or 1 -> 1; updated state will be same as before.
				if (originalState == 0 && liveNeighborsCount == 3) {
					board[i][j] = 2;
				} else if (originalState == 1 && (liveNeighborsCount < 2 || liveNeighborsCount > 3)) {
					board[i][j] = 3;
				} else {
					continue;
				}
			}
		}
		
		// second Pass: finalize the changes in the matrix
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				// updated value 2 (0 -> 1); final state is 1.
				// updated value 3 (1 -> 0); final state is 0.
				// updated value 0 (0 -> 0) or 1 (1 -> 1); final state is same as before.
				if (board[i][j] == 2) {
					board[i][j] = 1;
				} else if (board[i][j] == 3) {
					board[i][j] = 0;
				} else {
					continue;
				}
			}
		}
	}
	
	// 🧩helper🧩
	private int countLiveNeighbors(int[][] board, int rows, int cols, int i, int j) {
		int count = 0;
		
		// 8 neighbors are:
		int[][] dirOffsets = {{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};
		
		for (int[] dirOffset : dirOffsets) {
			int neighboursI = i + dirOffset[0];
			int neighboursJ = j + dirOffset[1];
			
			// check boundary
			if (neighboursI >= 0 && neighboursI < rows && neighboursJ >= 0 && neighboursJ < cols) {
				// the neighbors might be mutated already (0->2, 1->3) due to previous calculation.
				// so original State was = board[neighboursI][neighboursJ] % 2.
				count += board[neighboursI][neighboursJ] % 2;
			}
		}
		
		return count;
	}
	
	// 🧩helper🧩
	private static void printMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			for (int val : row) {
				System.out.printf("%2d ", val);
			}
			System.out.println();
		}
	}
	
	// 🧩main🧩
	public static void main(String[] args) {
		GameOfLife ourObj = new GameOfLife();
		
		int[][] board = {
				{0, 1, 0},
				{0, 0, 1},
				{1, 1, 1},
				{0, 0, 0}
		};
		
		System.out.println("INITIAL");
		printMatrix(board);
		
		ourObj.gameOfLife(board);
		
		System.out.println("\nFINAL");
		printMatrix(board);
	}
	
	
}