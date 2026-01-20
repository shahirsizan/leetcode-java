// https://leetcode.com/problems/combination-sum-ii/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CombinationSumII {
	
	public List<List<Integer>> combinationSum2(int[] givenNums, int target) {
		List<List<Integer>> resultList = new ArrayList<>();
		List<Integer> currentList = new ArrayList<>();
		// sorting `givenNums` will help us to prune extra tree traversal.
		Arrays.sort(givenNums);
		combinationSumIIHelper(givenNums, 0, target, currentList, resultList);
		return resultList;
	}
	
	private void combinationSumIIHelper(int[] givenNums, int startIndexOfCurrentRecursion, int remaining, List<Integer> currentList, List<List<Integer>> resultList) {
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
		// example {1,2,2,2,5}, target = 5
		
		for (int i = startIndexOfCurrentRecursion; i < givenNums.length; i++) {
			// this is one of the `gotcha`
			// we'll skip `equal` elements in succussive `iterations` in same `recursion stack frame` because that will generate duplicate combination
			// (order won't matter, but char frequency will be same, that's why)
			// just draw recursion tree and you'll understand
			if (i > startIndexOfCurrentRecursion && givenNums[i] == givenNums[i - 1]) {
				continue;
			}
			
			// Pruning: If `givenNums[i]` greater than the `remainder`,
			// then all the subsequent numbers are also greater than the remainder.
			// So no need to do recursive call farther. Go back to previous caller function.
			if (givenNums[i] > remaining) {
				break;
			}
			
			// Add current option
			currentList.add(givenNums[i]);
			
			// Do recursive call: Note that we pass 'i+1' to every next recursions.
			// because we can't use the same element more than once.
			// we sorted the given array, so the recursion tree will find the combination of the smallest elements through the left most branch of the tree.
			// only `left-left` and `left-right` turns allowed. No `right-left` turn allowed in the recursion tree. Draw tree for better understanding.
			// so once we get into a `givenNums[i+1]`, we will not go back to a lesser `givenNums[i]` in the successive iterations,
			// lest it will lead to duplication (though unordered) like for `k = 5`, {2,3} and {3,2} are not allowed.
			combinationSumIIHelper(givenNums, i + 1, remaining - givenNums[i], currentList, resultList);
			
			// Discard current option, backtrack
			currentList.removeLast();
		}
		
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		CombinationSumII myObj = new CombinationSumII();
		
		int[] nums = {2, 5, 2, 1, 2};
		int target = 5;
		System.out.println("Input: candidates = {2,5,2,1,2}, target = 5");
		System.out.println("Output: " + myObj.combinationSum2(nums, target));
	}
}