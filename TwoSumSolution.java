// CPS academy sheet (Arrays & Matrix)
// https://leetcode.com/problems/two-sum/description/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumSolution {
	
	
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> Mapp = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			int remaining = target - nums[i];
			
			if (Mapp.containsKey(remaining)) {
				return new int[]{i, Mapp.get(remaining)};
			} else {
				Mapp.put(nums[i], i);
			}
		}
		
		throw new IllegalArgumentException("No two sum solution found for the given input.");
	}
	
	
	public static void main(String[] args) {
		TwoSumSolution myObj = new TwoSumSolution();
		
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		
		System.out.println("Array: " + Arrays.toString(nums) + ", Target: " + target);
		int[] result = myObj.twoSum(nums, target);
		System.out.println("Indices: (Expected: [0, 1]) : " + Arrays.toString(result));
	}
}