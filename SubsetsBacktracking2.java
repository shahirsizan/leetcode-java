import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsBacktracking2 {
	private int[] nums;
	private List<List<Integer>> result;
	private List<Integer> currentSubset;
	
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		this.nums = nums;
		this.result = new ArrayList<>();
		this.currentSubset = new ArrayList<>();
		
		// must sort: groups duplicates because Java's Array.contains()
		// treats (1,4,4) and (4,1,4) differently. But they are same in our case
		// so sorting will keep all the duplicates together
		Arrays.sort(nums);
		
		// start from index `0`
		backtrack(0, currentSubset);
		
		return result;
	}
	
	// ✅backtrack✅
	private void backtrack(int currStartIdx, List<Integer> currentSubset) {
		
		// base case:
		// a valid subset can be of any length, so as soon as a `currentSubset` is formed,
		// meaning, as soon as we are at this point, include the `currentSubset` to `result`
		result.add(new ArrayList<>(currentSubset));
		
		
		// now explore possibilities: iterate through `nums` starting from 'currStartIdx' index
		for (int i = currStartIdx; i < nums.length; i++) {
			// skip duplicates:
			// if the current char is the same as the previous char in this loop,
			// skip it because the previous one already explored all subsets starting with this value.
			if (i > currStartIdx && nums[i] == nums[i - 1]) {
				continue;
			}
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
		SubsetsBacktracking2 myObj = new SubsetsBacktracking2();
		
		int[] nums1 = {4, 4, 4, 1, 4}; // [4, 4, 4, 4, 1] -> [4, 4, 4, (), ()]
		List<List<Integer>> result1 = myObj.subsetsWithDup(nums1);
		System.out.println("Input: " + Arrays.toString(nums1));
		System.out.println("Result1: " + result1);
		
	}
}