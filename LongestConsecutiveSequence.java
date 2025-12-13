// this solution cracked 79 / 83 testcases

import java.util.HashSet;
import java.util.Arrays;

public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		HashSet<Integer> ourHashSet = new HashSet<>();
		for (int num : nums) {
			ourHashSet.add(num);
		}

		int maxLength = 0;
		for (int num : nums) {
//			if `num−1` exists, then `num` is part of an existing sequence, skip.
//			If `num−1` doesn't exist, then `num` is the starting point of a sequence, track the sequence from this point.
			if (!ourHashSet.contains(num - 1)) {
				int currentNum = num;
				int currentSeqLength = 1;
				while (ourHashSet.contains(currentNum + 1)) {
					currentNum += 1;
					currentSeqLength += 1;
				}
				maxLength = Math.max(maxLength, currentSeqLength);
			}
		}

		return maxLength;
	}


	public static void main(String[] args) {
		LongestConsecutiveSequence solver = new LongestConsecutiveSequence();

		// Example 1:
		int[] nums1 = {100, 4, 200, 1, 3, 2};
		int result1 = solver.longestConsecutive(nums1);
		// Sequence is [1, 2, 3, 4]. Expected: 4
		System.out.println("--- Example 1 ---");
		System.out.println("Input: " + Arrays.toString(nums1));
		System.out.println("Longest Sequence Length: " + result1);

		System.out.println("-----------------");

		// Example 2:
		int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
		int result2 = solver.longestConsecutive(nums2);
		// Sequence is [0, 1, 2, 3, 4, 5, 6, 7, 8]. Expected: 9
		System.out.println("--- Example 2 ---");
		System.out.println("Input: " + Arrays.toString(nums2));
		System.out.println("Longest Sequence Length: " + result2);
	}
}