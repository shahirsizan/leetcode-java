// CPS academy DSA sheet (Matrix)
// https://leetcode.com/problems/spiral-matrix/description/

package matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		// extreme boundary indexes
		int topMost = 0;
		int bottomMost = rows - 1;
		int leftMost = 0;
		int rightMost = cols - 1;
		
		while (topMost <= bottomMost && leftMost <= rightMost) {
			
			// traverse `right` in the current `topMost` row
			if (topMost <= bottomMost && leftMost <= rightMost) {
				for (int j = leftMost; j <= rightMost; j++) {
					result.add(matrix[topMost][j]);
				}
				// shrink topMost boundary
				topMost++;
			}
			
			// traverse `down` in the current `rightMost` col
			if (topMost <= bottomMost && leftMost <= rightMost) {
				for (int i = topMost; i <= bottomMost; i++) {
					result.add(matrix[i][rightMost]);
				}
				// shrink rightMost boundary
				rightMost--;
			}
			
			// traverse `left` in the current `bottomMost` row
			if (topMost <= bottomMost && leftMost <= rightMost) {
				for (int j = rightMost; j >= leftMost; j--) {
					result.add(matrix[bottomMost][j]);
				}
				// shrink bottomMost boundary
				bottomMost--;
			}
			
			// traverse `up` in the current `leftMost` col
			if (topMost <= bottomMost && leftMost <= rightMost) {
				for (int i = bottomMost; i >= topMost; i--) {
					result.add(matrix[i][leftMost]);
				}
				// shrink leftMost boundary
				leftMost++;
			}
			
			// ☝️ re-iterate next loop starting from waaaaaaay above. Again from left-to-right 👆
		}
		
		return result;
	}
	
	// 🧩 helper 🧩
	private static void printMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			for (int val : row) {
				System.out.printf("%3d ", val);
			}
			System.out.println();
		}
	}
	
	// 🧩 main 🧩
	public static void main(String[] args) {
		SpiralMatrix ourObj = new SpiralMatrix();
		
		int[][] matrix = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		
		System.out.println("Input:");
		printMatrix(matrix);
		System.out.println("Output: " + ourObj.spiralOrder(matrix));
	}
}