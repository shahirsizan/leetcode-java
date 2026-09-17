// https://leetcode.com/problems/minimum-size-subarray-sum/description/
// CPS academy DSA sheet (Sliding Window)

public class MinimumSizeSubarraySum {
	
	public static int minSubArrayLen(int target, int[] nums) {
		int currentSum = 0;
		int minLength = Integer.MAX_VALUE;
		
		int left = 0;
		for (int right = 0; right < nums.length; right++) {
			currentSum += nums[right];
			
			while (currentSum >= target) {
				minLength = Math.min(minLength, right - left + 1);
				
				currentSum -= nums[left];
				left++;
			}
		}
		
		// If minLength was never updated, it means no such subarray exists
		return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
	}
	
	public static void main(String[] args) {
		int target1 = 7;
		int[] nums1 = {2, 3, 1, 2, 4, 3};
		System.out.println("Test Case 1: " + minSubArrayLen(target1, nums1) + " Expected: 2 ([4, 3])");
	}
}