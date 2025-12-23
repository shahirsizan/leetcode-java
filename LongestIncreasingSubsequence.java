// https://leetcode.com/problems/longest-increasing-subsequence/

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	
	public int lengthOfLIS(int[] nums) {
		// dp[i] stores the length of LIS up until index `i`
		int[] dp = new int[nums.length];
		// Every single element itself is an increasing subsequence of length `1`
		Arrays.fill(dp, 1);
		
		int overallMax = 1;
		
		// Compare every element with all elements before it
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				// Can't explain here. Better draw diagram in whiteboard. It's easy.
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			overallMax = Math.max(overallMax, dp[i]);
		}
		
		return overallMax;
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		LongestIncreasingSubsequence myObj = new LongestIncreasingSubsequence();
		
		int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
		System.out.println("Input: [10, 9, 2, 5, 3, 7, 101, 18]");
		System.out.println("Output: " + myObj.lengthOfLIS(nums1));
		
		int[] nums2 = {0, 1, 0, 3, 2, 3};
		System.out.println("\nInput: [0, 1, 0, 3, 2, 3]");
		System.out.println("Output: " + myObj.lengthOfLIS(nums2));
		
		int[] nums3 = {7, 7, 7, 7};
		System.out.println("\nInput: [7, 7, 7, 7]");
		System.out.println("Output: " + myObj.lengthOfLIS(nums3));
	}
}