// https://leetcode.com/problems/combination-sum/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	
	public List<List<Integer>> combinationSum(int[] givenNums, int target) {
		List<List<Integer>> resultList = new ArrayList<>();
		List<Integer> currentList = new ArrayList<>();
		// sorting `givenNums` will help us to cut off extra tree traversal.
		Arrays.sort(givenNums);
		combinationSumHelper(givenNums, 0, target, currentList, resultList);
		return resultList;
	}
	
	private void combinationSumHelper(int[] givenNums, int startIndexOfCurrentRecursion, int remaining, List<Integer> currentList, List<List<Integer>> resultList) {
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
		// example {2, 3, 5} ; k = 8
		
		int i = startIndexOfCurrentRecursion;
		while (i < givenNums.length) {
			// Pruning: If `givenNums[i]` greater than the `remainder`,
			// then all the subsequent numbers are also greater than the remainder.
			// So no need to do recursive call farther. Go back to previous caller function.
			if (givenNums[i] > remaining) {
				break;
			}
			
			// Add current option
			currentList.add(givenNums[i]);
			
			// Do recursive call: Note that we pass 'i'.
			// because we can use the same element unlimited number of times.
			// we sorted the given array, so the recursion tree will find the combination of the smallest elements through the left most branch of the tree.
			// so once we get into `givenNums[i+1]` , we will not go back to a lesser `givenNums[i]` in the next recursion for next iteration,
			// lest it will lead to duplication (though unordered) like for `k = 5`, {2,3} and {3,2} are not allowed.
			combinationSumHelper(givenNums, i, remaining - givenNums[i], currentList, resultList);
			
			// Discard current option
			currentList.removeLast();
			
			i++;
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