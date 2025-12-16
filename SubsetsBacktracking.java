import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsBacktracking {
	private int[] nums;
	private List<List<Integer>> result;
	private List<Integer> currentSubset;
	
	public List<List<Integer>> subsets(int[] nums) {
		this.nums = nums;
		this.result = new ArrayList<>();
		this.currentSubset = new ArrayList<>();
		
		// start from index `0`
		backtrack(0, currentSubset);
		
		return result;
	}
	
	// ✅backtrack✅
	private void backtrack(int currStartIdx, List<Integer> currentSubset) {
		
		// base case:
		// because a valid subset can be of any length, so as soon as a `currentSubset` is formed,
		// meaning, as soon as we are at this point, include the `currentSubset` to `result`
		result.add(new ArrayList<>(currentSubset));
		
		// now explore possibilities: iterate through `nums` starting from 'currStartIdx' index
		for (int i = currStartIdx; i < nums.length; i++) {
			// include option `nums[i]` in current position
			currentSubset.add(nums[i]);
			// Now proceed to next position to test `nums[i+1]`
			backtrack(i + 1, currentSubset);
			// next position was a base case. So came back to this position, remove the option `nums[i]`.
			currentSubset.removeLast();
			// Get a new option `nums[something]` for current position in next iteration
		}
	}
	
	// ✅main✅
	public static void main(String[] args) {
		SubsetsBacktracking myObj = new SubsetsBacktracking();
		
		int[] nums1 = {1, 2, 3};
		List<List<Integer>> result1 = myObj.subsets(nums1);
		System.out.println("Input: " + Arrays.toString(nums1));
		System.out.println("Result1: " + result1);
		
		System.out.println("\n" + "-".repeat(30) + "\n");
		
		int[] nums2 = {0};
		List<List<Integer>> result2 = myObj.subsets(nums2);
		System.out.println("Input: " + Arrays.toString(nums2));
		System.out.println("Result2: " + result2);
	}
}