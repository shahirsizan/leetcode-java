// CPS academy DSA sheet (Arrays)
// https://leetcode.com/problems/container-with-most-water/description/

import java.util.Arrays;

public class ContainerWithMostWater {
	
	public int maxArea(int[] givenHeights) {
		int leftPointer = 0;
		int rightPointer = givenHeights.length - 1;
		int maxArea = 0;
		
		/**
		 *  👉 in first iteration, we shall get one of the pointers pointing at a taller wall.
		 * 	👉 Keeping that on hold, we will try to look for the same or taller wall for the other pointer.
		 * 	👉 a pointer will only change if the other pointer is pointing at a taller wall.
		 * 	👉 if both pointing at same tall wall, both will change.
		 * 	👉 for each iteration, we calculate `currentArea` and compare to `maxArea`
		 * */
		while (leftPointer < rightPointer) {
			int currentWidth = rightPointer - leftPointer;
			int currentHeight = Math.min(givenHeights[leftPointer], givenHeights[rightPointer]);
			int currentArea = currentWidth * currentHeight;
			maxArea = Math.max(maxArea, currentArea);
			
			// time to change pointers
			if (givenHeights[leftPointer] < givenHeights[rightPointer]) {
				leftPointer++;
			} else if (givenHeights[leftPointer] > givenHeights[rightPointer]) {
				rightPointer--;
			} else if (givenHeights[leftPointer] == givenHeights[rightPointer]) {
				leftPointer++;
				rightPointer--;
			}
		}
		
		return maxArea;
	}
	
	public static void main(String[] args) {
		ContainerWithMostWater myObj = new ContainerWithMostWater();
		
		// Example 1:
		int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
		int result1 = myObj.maxArea(height1);
		System.out.println("Max Area: " + result1 + " Expected: 49");
		
		System.out.println("-----------------");
		
		// Example 2:
		int[] height2 = {1, 1};
		int result2 = myObj.maxArea(height2);
		System.out.println("Height: " + Arrays.toString(height2));
		System.out.println("Max Area: " + result2 + " Expected: 1");
	}
}