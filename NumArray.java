// https://leetcode.com/problems/range-sum-query-immutable/description/
// https://medium.com/@maityamit/prefix-sum-summary-with-practice-questions-sheet-1d-2d-on-leetcode-83c8deb4f713

public class NumArray {
	private int[] prefixSumArr;
	
	public NumArray(int[] nums) {
		int n = nums.length;
		prefixSumArr = new int[n];
		
		prefixSumArr[0] = nums[0];
		for (int i = 1; i < n; i++) {
			prefixSumArr[i] = prefixSumArr[i - 1] + nums[i];
		}
	}
	
	// {-2, 0, 3, -5,  2, -1}
	// {-2, 0, 1, -4, -2, -3}
	
	public int sumRange(int left, int right) {
		if (left == 0) {
			return prefixSumArr[right];
		}
		return prefixSumArr[right] - prefixSumArr[left - 1];
	}
	
	public static void main(String[] args) {
		int[] nums = {-2, 0, 3, -5, 2, -1};
		NumArray obj = new NumArray(nums);
		
		System.out.println("Sum(0, 2): " + obj.sumRange(0, 2)); // Output: 1
		System.out.println("Sum(2, 5): " + obj.sumRange(2, 5)); // Output: -1
		System.out.println("Sum(0, 5): " + obj.sumRange(0, 5)); // Output: -3
	}
}