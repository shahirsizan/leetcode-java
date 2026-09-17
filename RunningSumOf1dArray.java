// https://leetcode.com/problems/running-sum-of-1d-array/
// https://medium.com/@maityamit/prefix-sum-summary-with-practice-questions-sheet-1d-2d-on-leetcode-83c8deb4f713

import java.util.Arrays;

public class RunningSumOf1dArray {
	
	public int[] runningSum(int[] givenNums) {
		int[] result = new int[givenNums.length];
		result[0] = givenNums[0];
		
		for (int i = 1; i < givenNums.length; i++) {
			// Update the current element by adding the sum of the previous elements
			result[i] = givenNums[i] + result[i - 1];
		}
		return result;
	}
	
	public static void main(String[] args) {
		RunningSumOf1dArray solver = new RunningSumOf1dArray();
		
		// Test case 1
		int[] nums1 = {1, 2, 3, 4};
		System.out.println("Input: " + Arrays.toString(nums1));
		System.out.println("Output: " + Arrays.toString(solver.runningSum(nums1)));
		
		System.out.println("---");
		
		// Test case 2
		int[] nums2 = {1, 1, 1, 1, 1};
		System.out.println("Input: " + Arrays.toString(nums2));
		System.out.println("Output: " + Arrays.toString(solver.runningSum(nums2)));
	}
}