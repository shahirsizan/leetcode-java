// https://leetcode.com/problems/find-the-middle-index-in-array/description/
// https://medium.com/@maityamit/prefix-sum-summary-with-practice-questions-sheet-1d-2d-on-leetcode-83c8deb4f713

public class FindTheMiddleIndexInArray {
	
	public int findMiddleIndex(int[] givenNums) {
		int n = givenNums.length;
		int[] prefixSum = new int[n];
		int[] postfixSum = new int[n];
		
		prefixSum[0] = 0;
		for (int i = 1; i < n; i++) {
			prefixSum[i] = prefixSum[i - 1] + givenNums[i - 1];
		}
		
		postfixSum[n - 1] = 0;
		for (int i = n - 2; i >= 0; i--) {
			postfixSum[i] = postfixSum[i + 1] + givenNums[i + 1];
		}
		
		for (int i = 0; i < n; i++) {
			if (prefixSum[i] == postfixSum[i]) {
				return i;
			}
		}
		
		return -1; // if no middle index found
	}
	
	public static void main(String[] args) {
		FindTheMiddleIndexInArray solver = new FindTheMiddleIndexInArray();
		int[] nums = {2, 3, -1, 8, 4};
		System.out.println("Middle Index: " + solver.findMiddleIndex(nums)); // Output: 3
	}
}