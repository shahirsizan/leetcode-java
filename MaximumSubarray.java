// CPS academy DSA sheet (Arrays & Matrix)
// https://leetcode.com/problems/maximum-subarray/description/

public class MaximumSubarray {
	
	public int maxSubArray(int[] givenArray) {
		int globalMax = givenArray[0];
		int currentMax = givenArray[0];
		
		// [2, -3, 5, -1]
		// [1, 2, 3, -10]
		// [4, -1, 2]
		// [-2,1,-3,4,-1,2,1,-5,4]
		
		for (int i = 1; i < givenArray.length; i++) {
			int currentNum = givenArray[i];
			
			currentMax = Math.max(currentMax + currentNum, currentNum);
			
			if (currentMax > globalMax) {
				globalMax = currentMax;
			}
		}
		
		return globalMax;
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		MaximumSubarray myObj = new MaximumSubarray();
		int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		int[] nums2 = {1, 2, 3, -10, 7};
		int[] nums3 = {4, -1, 2};
		int[] nums4 = {-2, 1, -3};
		
		int result = myObj.maxSubArray(nums4);
		System.out.println("Maximum Subarray Sum: " + result + " (Expected: 5)");
	}
}