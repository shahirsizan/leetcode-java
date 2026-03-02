// CPS academy DSA sheet (Arrays)
// https://leetcode.com/problems/longest-consecutive-sequence/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	
	/**
	 * 👉 Generate hashset from the given array
	 * 👉 traverse the hashset
	 * 👉 for each element `x`, check whether `x-1` exists in the set
	 * 👉 if NO, we got the starting point of another `continuous sequence`.
	 * 👉 in a loop, check whether `x+1` exists, if yes increment `local count` and update `global count`.
	 * 👉 As soon as `x+1` fails, we get the count for an apparent sequence. Get out from the loop.
	 * 👉 Traverse the set for next staring point.
	 *
	 */
	
	public int longestConsecutive(int[] givenNums) {
		
		if (givenNums.length == 0) {
			return 0;
		}
		
		Set<Integer> ourHashSet = new HashSet<>();
		for (int num : givenNums) {
			ourHashSet.add(num);
		}
		
		// set: {0,  2,3,  6,7,8,9}
		
		int globalCount = 1;
		for (int num : ourHashSet) {
			int currentStartNum = num;
			
			// probable start point of a continuous sequence
			if (!ourHashSet.contains(currentStartNum - 1)) {
				int localCount = 1;
				while (ourHashSet.contains(currentStartNum + 1)) {
					localCount++;
					currentStartNum++;
				}
				globalCount = Math.max(globalCount, localCount);
			}
			// no more continuity. Traverse for next starting point of another sequence
		}
		
		return globalCount;
	}
	
	
	public static void main(String[] args) {
		LongestConsecutiveSequence myObj = new LongestConsecutiveSequence();
		
		int[] nums = {0, 2, 3, 6, 7, 8, 9};
		int result = myObj.longestConsecutive(nums);
		System.out.println("Input: " + Arrays.toString(nums));
		System.out.println("Longest Sequence: " + result + " (Expected: 4)");
	}
}