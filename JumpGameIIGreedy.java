// https://leetcode.com/problems/jump-game-ii/

public class JumpGameIIGreedy {
	
	public int jump(int[] nums) {
		int minJumps = 0;
		int current_window_last_idx = 0;
		int global_farthest_idx = 0;
		
		// starting at `i = 0`, `i + arr[i]` is our first window
		// from within the current window, find out how farthest we can jump.
		// at the end of the current window, we have to jump anyways. So increment `minJumps` and re-iterate the process.
		// as soon as we find out our `global_farthest >= last index`, the `minJumps` at that moment is the answer
		for (int i = 0; i < nums.length - 1; i++) {
			global_farthest_idx = Math.max(global_farthest_idx, i + nums[i]);
			
			if (i == current_window_last_idx) {
				minJumps++;
				current_window_last_idx = global_farthest_idx;
			}
			
			// if already reach the end, we are done
			if (current_window_last_idx >= nums.length - 1) {
				break;
			}
		}
		
		return minJumps;
	}
	
	public static void main(String[] args) {
		JumpGameIIGreedy myObj = new JumpGameIIGreedy();
		
		int[] nums1 = {2, 3, 1, 1, 4};
		System.out.println("Input: [2, 3, 1, 1, 4]");
		System.out.println("Output: " + myObj.jump(nums1));
		
		int[] nums2 = {2, 3, 0, 1, 4};
		System.out.println("\nInput: [2, 3, 0, 1, 4]");
		System.out.println("Output: " + myObj.jump(nums2));
	}
}