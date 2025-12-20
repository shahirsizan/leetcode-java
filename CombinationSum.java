// https://leetcode.com/problems/combination-sum/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	
	public List<List<Integer>> combinationSum(int[] candidatesList, int target) {
		List<List<Integer>> resultList = new ArrayList<>();
		List<Integer> currentList = new ArrayList<>();
		// sorting `candidatesList` will help us to cut off extra tree traversal.
		Arrays.sort(candidatesList);
		backtrack(candidatesList, target, 0, currentList, resultList);
		return resultList;
	}
	
	private void backtrack(int[] candidatesList, int remaining, int currentStartIndex, List<Integer> currentList, List<List<Integer>> resultList) {
		// Base case: `target` achieved. Add `currentList` to result. Then backtrack.
		if (remaining == 0) {
			resultList.add(new ArrayList<>(currentList));
			return;
		}
		
		// Another base case: addition of the last element exceeds `target`. We gotta backtrack.
		if (remaining < 0) {
			return;
		}
		
		// No base case, go on.
		
		for (int i = currentStartIndex; i < candidatesList.length; i++) {
			// Pruning: If `current number` is greater than the remainder,
			// then all the subsequent numbers are also greater than the remainder.
			// So no need to do recursive call farther. Backtrack.
			if (candidatesList[i] > remaining) {
				break;
			}
			// Add the current option (number)
			currentList.add(candidatesList[i]);
			// Do recursive call: Note that we pass 'i' instead of `i + 1`
			// because we can use the same element unlimited number of times.
			backtrack(candidatesList, remaining - candidatesList[i], i, currentList, resultList);
			// Discard current option
			currentList.removeLast();
		}
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		CombinationSum myObj = new CombinationSum();
		
		int[] nums1 = {2, 3, 6, 7};
		int target1 = 7;
		System.out.println("Input: candidates = [2, 3, 6, 7], target = 7");
		System.out.println("Output: " + myObj.combinationSum(nums1, target1));
		
		int[] nums2 = {2, 3, 5};
		int target2 = 8;
		System.out.println("\nInput: candidates = [2, 3, 5], target = 8");
		System.out.println("Output: " + myObj.combinationSum(nums2, target2));
	}
}