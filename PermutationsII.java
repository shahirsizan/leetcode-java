// https://leetcode.com/problems/permutations-ii/description/

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
			
			// if current option is same as previous one AND previous one is `not visited`
			// which means previous one was previously added and then after backtrack, removed from `visitedBooleanList`,
			// so technically we are in the `next iteration` of the `same recursion frame` in the stack
			// and we have to skip current option.
			if (i > 0 && givenNumsList[i] == givenNumsList[i - 1] && visitedBooleanList[i - 1] == false) {
				continue;
			}
			// if previous one is `visited`,
			// which means we are in the `next recursion frame` where the previous frame has the `previous same element` which is allowed.
			// We can have {1,1,2}, {2,2,3} etc
			
			
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