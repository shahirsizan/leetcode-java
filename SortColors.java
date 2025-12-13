// https://leetcode.com/problems/sort-colors/description/
// The Dutch National Flag (DNF) Algorithm is a single-pass, in-place sorting algorithm specifically
// designed for partitioning an array containing elements of three distinct categories or values

import java.util.Arrays;

public class SortColors {

	public void sortColors(int[] nums) {
		if (nums.length < 2) {
			return;
		}

		int leftPointer = 0;
		int midPointer = 0;
		int rightPointer = nums.length - 1;

		while (midPointer <= rightPointer) {
			if (nums[midPointer] == 0) {
				int temp = nums[midPointer];
				nums[midPointer] = nums[leftPointer];
				nums[leftPointer] = temp;
//				both pointer will increase
				leftPointer++;
				midPointer++;
			}
			else if (nums[midPointer] == 1) {
//				`midPointer` value has to be `1`, so skip
				midPointer++;
			}
			else if (nums[midPointer] == 2) {
				int temp = nums[midPointer];
				nums[midPointer] = nums[rightPointer];
				nums[rightPointer] = temp;
//				only `rightPointer` should decrease. Because the current `midPointer` value after swap might be `0` or `2`.
				rightPointer--;
			}
		}
	}

	// --- Main Method for Demonstration ---

	public static void main(String[] args) {
		SortColors solver = new SortColors();

		// Example 1:
		int[] nums1 = {2, 0, 2, 1, 1, 0};
		solver.sortColors(nums1);
		System.out.println("--- Example 1 ---");
		System.out.println("Result: " + Arrays.toString(nums1) + " (Expected: [0, 0, 1, 1, 2, 2])");

		System.out.println("-----------------");

		// Example 2:
		int[] nums2 = {2, 0, 1};
		solver.sortColors(nums2);
		System.out.println("--- Example 2 ---");
		System.out.println("Result: " + Arrays.toString(nums2) + " (Expected: [0, 1, 2])");
	}
}