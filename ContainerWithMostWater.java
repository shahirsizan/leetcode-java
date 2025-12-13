import java.lang.Math;
import java.util.Arrays;

public class ContainerWithMostWater {

	public int maxArea(int[] height) {
		int leftPointer = 0;
		int rightPointer = height.length - 1;
		int maxArea = 0;

		while (leftPointer < rightPointer) {
			int currentWidth = rightPointer - leftPointer;
			int currentHeight = Math.min(height[leftPointer], height[rightPointer]);

			int currentArea = currentWidth * currentHeight;
			maxArea = Math.max(maxArea, currentArea);

			// Move the short pointer towards taller line (greedy)
			if (height[leftPointer] < height[rightPointer]) {
				leftPointer++;
			} else {
				rightPointer--;
			}
		}

		return maxArea;
	}

	// --- Main Method ---

	public static void main(String[] args) {
		ContainerWithMostWater solver = new ContainerWithMostWater();

		// Example 1:
		int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
		int result1 = solver.maxArea(height1);
		// Best pair: 8 (index 1) and 7 (index 8). Area = 7 * 7 = 49. Expected: 49
		System.out.println("--- Example 1 ---");
		System.out.println("Height: " + Arrays.toString(height1));
		System.out.println("Max Area: " + result1);

		System.out.println("-----------------");

		// Example 2:
		int[] height2 = {1, 1};
		int result2 = solver.maxArea(height2);
		// Area = 1 * 1 = 1. Expected: 1
		System.out.println("--- Example 2 ---");
		System.out.println("Height: " + Arrays.toString(height2));
		System.out.println("Max Area: " + result2);
	}
}