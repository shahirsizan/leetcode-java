// https://leetcode.com/problems/jump-game/description/

public class JumpGameGreedy {
	
	public boolean canJump(int[] nums) {
		if (nums.length == 1) {
			return true;
		}
		
		int minJumps = 0;
		int current_window_last_idx = 0;
		int global_farthest_idx = 0;
		
		// starting at `i = 0`, `i + arr[i]` is our first window
		// from within the current window, find out how farthest we can jump.
		// at the end of the current window, we have to jump anyways.
		// as soon as we find out our `global_farthest >= last index`, means we will be able to jump to the very last index
		for (int i = 0; i < nums.length - 1; i++) {
			global_farthest_idx = Math.max(global_farthest_idx, i + nums[i]);
			
			if (i == current_window_last_idx) {
				current_window_last_idx = global_farthest_idx;
			}
			
			// if already reach the end or surpass it, we are done
			if (current_window_last_idx >= nums.length - 1) {
				return true;
			}
		}
		
		return false;
	}
	
	// ✅main✅
	public static void main(String[] args) {
		JumpGameGreedy myObj = new JumpGameGreedy();
		
		int[] nums1 = {2, 3, 1, 1, 4};
		System.out.println("Input: [2, 3, 1, 1, 4]");
		System.out.println("Reachable: " + myObj.canJump(nums1));
		
		int[] nums2 = {3, 2, 1, 0, 4};
		System.out.println("\nInput: [3, 2, 1, 0, 4]");
		System.out.println("Reachable: " + myObj.canJump(nums2));
	}
}