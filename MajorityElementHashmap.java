// HashMap approach
// O(n) time ;  O(n) space
// https://leetcode.com/problems/majority-element/description/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElementHashmap {
	public int majorityElement(int[] numsArray) {
		HashMap<Integer, Integer> countsMap = new HashMap<>();

		for (int num : numsArray) {
			countsMap.put(num, countsMap.getOrDefault(num, 0) + 1);
		}

		int maxValue = -1;
		Map.Entry<Integer, Integer> tempEntry = null;
		for (Map.Entry<Integer, Integer> entry : countsMap.entrySet()) {
			if (entry.getValue() > maxValue) {
				maxValue = entry.getValue();
				tempEntry = entry;
			}
		}

		return tempEntry.getKey();
	}

	// --- Main Method for Demonstration ---

	public static void main(String[] args) {
		MajorityElementHashmap solver = new MajorityElementHashmap();

		int[] nums1 = {3, 2, 3};
		int result1 = solver.majorityElement(nums1);
		System.out.println("--- Example 1 ---");
		System.out.println("Input: " + Arrays.toString(nums1) + ", Majority Element: " + result1); // Expected: 3

		System.out.println("-----------------");

		int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
		int result2 = solver.majorityElement(nums2);
		System.out.println("--- Example 2 ---");
		System.out.println("Input: " + Arrays.toString(nums2) + ", Majority Element: " + result2); // Expected: 2
	}
}