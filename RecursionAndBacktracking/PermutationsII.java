// CPS academy DSA sheet (Recursion and Backtracking)
// https://leetcode.com/problems/permutations-ii/description/

package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
	
	// ✅ permute() ✅
	public List<List<Integer>> permuteUnique(int[] numsArray) {
		List<Integer> currentList = new ArrayList<>();
		List<List<Integer>> resultList = new ArrayList<>();
		boolean[] visitedBooleanList = new boolean[numsArray.length];
		// sort `numsArray` to group duplicates together
		Arrays.sort(numsArray);
		backtrack(numsArray, currentList, visitedBooleanList, resultList);
		return resultList;
	}
	
	
	// ✅ backtrack() ✅
	private void backtrack(int[] givenNumsList, List<Integer> currentList, boolean[] visitedBooleanList, List<List<Integer>> resultList) {
		// base case:
		// if `currentList` length equal to `givenNumsList` length, we found a permutation, append to `resultList`
		if (currentList.size() == givenNumsList.length) {
			resultList.add(new ArrayList<>(currentList));
			return;
		}
		
		// not base case, explore all options for current position
		for (int i = 0; i < givenNumsList.length; i++) {
			// skip if the number is already in the `currentList` (AKA visited)
			if (visitedBooleanList[i] == true) {
				continue;
			}
			
			// If `current` option is same as `previous` option AND `previous` option is `not visited`,
			// means `previous` option is completely explored and after backtrack, removed from `visitedBooleanList`,
			// So exploring the current option which is similar to the previous, will render the same permutations.
			// So we have to skip current option.
			if (i > 0 && givenNumsList[i] == givenNumsList[i - 1] && visitedBooleanList[i - 1] == false) {
				continue;
			}
			// if previous option, which is similar to current option, is `visited`,
			// means we are at a subsequent `recursion frame` originated from that previous option, which is allowed.
			
			// add current option
			currentList.add(givenNumsList[i]);
			// make it `visited`
			visitedBooleanList[i] = true;
			// make recursive function call
			backtrack(givenNumsList, currentList, visitedBooleanList, resultList);
			
			// backtrack, remove `givenNumsList[i]` from `currentList` and go for next iteration
			currentList.removeLast();
			visitedBooleanList[i] = false;
		}
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		PermutationsII myObj = new PermutationsII();
		int[] nums = {1, 1, 2};
		List<List<Integer>> result = myObj.permuteUnique(nums);
		System.out.println("Input: [1, 1, 2]");
		System.out.println("Output: " + result);
	}
}