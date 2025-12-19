import java.util.ArrayList;
import java.util.List;

public class Permutations {
	
	// ✅ permute() ✅
	public List<List<Integer>> permute(int[] numsArray) {
		List<List<Integer>> resultList = new ArrayList<>();
		// the given elements will be unique, the result permutations will not have any duplicates.
		// so we have to track which one is visited
		boolean[] visitedBooleanList = new boolean[numsArray.length];
		List<Integer> currentList = new ArrayList<>();
		backtrack(numsArray, currentList, visitedBooleanList, resultList);
		return resultList;
	}
	
	
	// ✅ backtrack() ✅
	private void backtrack(int[] numsArray, List<Integer> currentList, boolean[] visitedBooleanList, List<List<Integer>> resultList) {
		// base case:
		// if `currentList.length` == `numsArray.length`, we found a permutation
		// append to `resultList`
		if (currentList.size() == numsArray.length) {
			resultList.add(new ArrayList<>(currentList));
			return;
		}
		
		// else, explore all numbers for the current position
		for (int i = 0; i < numsArray.length; i++) {
			// skip if the number is already in the `currentList` (AKA visited)
			if (visitedBooleanList[i] == true) {
				continue;
			}
			
			// add `numsArray[i]` to `currentList` and do recursive call
			currentList.add(numsArray[i]);
			visitedBooleanList[i] = true;
			backtrack(numsArray, currentList, visitedBooleanList, resultList);
			
			// got back from recursive call
			// remove `numsArray[i]` from `currentList` and go for next iteration
			currentList.removeLast();
			visitedBooleanList[i] = false;
		}
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		Permutations myObj = new Permutations();
		
		int[] nums1 = {1, 2, 3};
		List<List<Integer>> result1 = myObj.permute(nums1);
		System.out.println("Input: [1, 2, 3]");
		System.out.println("Output: " + result1);
		
		System.out.println("\n");
		
		int[] nums2 = {0, 1};
		List<List<Integer>> result2 = myObj.permute(nums2);
		System.out.println("Input: [0, 1]");
		System.out.println("Output: " + result2);
	}
}