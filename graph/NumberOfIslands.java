// https://leetcode.com/problems/number-of-islands/description/
package graph;

public class NumberOfIslands {
	public int numIslands(char[][] givenGrid) {
		int count = 0;
		int rows = givenGrid.length;
		int cols = givenGrid[0].length;
		
		for (int currRow = 0; currRow < rows; currRow++) {
			for (int currCol = 0; currCol < cols; currCol++) {
				// We start traversing the matrix. Upon finding the first `1`,
				// we perform DFS and convert all adjacent (U,D,L,R) cells to `0`.
				// After returning from all the recursion frames, we have successfully finished processing a single island.
				// Now continue traversing next cells for another `1` which represents another separate island
				// because the previous islands `1`s are all made `0`s.
				// Do the same thing again.
				if (givenGrid[currRow][currCol] == '1') {
					recurseFunc(givenGrid, currRow, currCol);
					count++;
				}
			}
		}
		return count;
	}
	
	private void recurseFunc(char[][] givenGrid, int currRow, int currCol) {
		// if out of boundary OR water, return.
		if (currRow < 0 || currRow >= givenGrid.length ||
				currCol < 0 || currCol >= givenGrid[0].length ||
				givenGrid[currRow][currCol] == '0') {
			return;
		}
		
		// if part of a contiguous island, convert `1` to `0`
		givenGrid[currRow][currCol] = '0';
		
		// Visit all it's neighbors (U,D,L,R)
		recurseFunc(givenGrid, currRow + 1, currCol);
		recurseFunc(givenGrid, currRow - 1, currCol);
		recurseFunc(givenGrid, currRow, currCol + 1);
		recurseFunc(givenGrid, currRow, currCol - 1);
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		char[][] grid = {
				{'1', '1', '0', '0', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '1', '0', '0'},
				{'0', '0', '0', '1', '1'}
		};
		
		NumberOfIslands myObj = new NumberOfIslands();
		System.out.println("Number of Islands: " + myObj.numIslands(grid));
		System.out.println("Expected: 3");
	}
}