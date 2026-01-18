// https://leetcode.com/problems/climbing-stairs/description/

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairsDPmemoization {
	
	public int climbStairs(int n) {
		// Create a memoization array to store results
		// Size n + 1 so we can use index n directly
		Map<Integer, Integer> memoMap = new HashMap<>();
		int[] memo = new int[n + 1];
		return climbStairsHelper(n, memoMap);
	}
	
	private int climbStairsHelper(int n, Map<Integer, Integer> memoMap) {
		// base case: if `n <= 2`, we will have `n` ways
		if (n == 1 || n == 2) {
			return n;
		}
		
		// if not base case, check whether we have calculated steps for this stage or not
		if (memoMap.containsKey(n)) {
			return memoMap.get(n);
		}
		
		// if not calculated, calculate now
		int numOfWays = climbStairsHelper(n - 1, memoMap) + climbStairsHelper(n - 2, memoMap);
		// store in memo
		memoMap.put(n, numOfWays);
		// return it
		return numOfWays;
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		ClimbingStairsDPmemoization myObj = new ClimbingStairsDPmemoization();
		int n = 10;
		System.out.println("Ways to climb: " + myObj.climbStairs(n));
		// expected: 89
	}
}