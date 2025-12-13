// Boyer-Moore Voting Algorithm (Optimal)
// O(n) time ;  O(1) space
// https://leetcode.com/problems/majority-element/description/

import java.util.Arrays;

public class MajorityElement {

	public int majorityElement(int[] nums) {
		int count = 0;
		int possibleCandidate = 0;

		for (int currentNum : nums) {
			if (count == 0) {
				possibleCandidate = currentNum;
			}
			if (currentNum == possibleCandidate) {
				count++;
			} else {
				count--;
			}
		}

		return possibleCandidate;
	}

	// --- Main Method for Demonstration ---

	public static void main(String[] args) {
		MajorityElement solver = new MajorityElement();

		int[] nums1 = {3, 2, 3};
		int result1 = solver.majorityElement(nums1);
		System.out.println("Input: " + Arrays.toString(nums1) + ", Majority Element: " + result1); // Expected: 3

		int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
		int result2 = solver.majorityElement(nums2);
		System.out.println("Input: " + Arrays.toString(nums2) + ", Majority Element: " + result2); // Expected: 2
	}
}