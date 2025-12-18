// https://leetcode.com/problems/jump-game/description/

import java.util.Arrays;

public class JumpGameBacktracking {
	
	enum State {
		UNKNOWN,
		END,
		NOT_POSSIBLE
	}
	
	State[] memo;
	
	public boolean canJump(int[] numsList) {
		memo = new State[numsList.length];
		// initialize all states as `UNKNOWN`
		Arrays.fill(memo, State.UNKNOWN);
		// the last index is always "GOOD" because it is the goal
		memo[numsList.length - 1] = State.END;
		return backtrack(0, numsList);
	}
	
	private boolean backtrack(int position, int[] nums) {
		// if result already calculated for this `position`, return.
		// if `State.END`, we are finally at the `end` of array.
		// if `State.NOT_POSSIBLE`, we have to `backtrack`
		if (memo[position] == State.END) {
			return true;
		} else if (memo[position] == State.NOT_POSSIBLE) {
			return false;
		}
		// else calculate below
		
		// `furthest Possible Jump` from this `position`
		int furthestPossibleJump = Math.min(position + nums[position], nums.length - 1);
		
		// try every jump from the largest to the smallest option
		for (int nextPosition = furthestPossibleJump; nextPosition > position; nextPosition--) {
			boolean isPossible = backtrack(nextPosition, nums);
			if (isPossible) {
				memo[position] = State.END;
				return true;
			} else {
				continue;
			}
		}
		// if all options above fail, means no jump possible from this `position`. Mark it as `State.NOT_POSSIBLE`
		memo[position] = State.NOT_POSSIBLE;
		return false;
	}
	
	// ✅main✅
	public static void main(String[] args) {
		JumpGameBacktracking myObj = new JumpGameBacktracking();
		
		int[] nums1 = {2, 3, 1, 1, 4};
		System.out.println("Input: [2, 3, 1, 1, 4]");
		System.out.println("Reachable: " + myObj.canJump(nums1));
		
		int[] nums2 = {3, 2, 1, 0, 4};
		System.out.println("\nInput: [3, 2, 1, 0, 4]");
		System.out.println("Reachable: " + myObj.canJump(nums2));
	}
}