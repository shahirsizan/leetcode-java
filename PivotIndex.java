// https://leetcode.com/problems/find-pivot-index/description/?q=724

public class PivotIndex {
	
	public int pivotIndex(int[] givenNums) {
		int totalSum = 0;
		for (int x : givenNums) {
			totalSum += x;
		}
		
		int leftSubarraySum = 0;
		for (int i = 0; i < givenNums.length; i++) {
			int rightSubarraySum = totalSum - leftSubarraySum - givenNums[i];
			
			if (leftSubarraySum == rightSubarraySum) {
				return i;
			}
			
			leftSubarraySum += givenNums[i];
		}
		
		return -1;
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		PivotIndex myObj = new PivotIndex();
		int[] nums1 = {1, 7, 3, 6, 5, 6};
		int[] nums2 = {-1, -1, -1, -1, -1, 0};
		System.out.println("Pivot Index of [1,7,3,6,5,6]: " + myObj.pivotIndex(nums2));
		// Output: 3 (Left sum: 1+7+3 = 11, Right sum: 5+6 = 11)
	}
}