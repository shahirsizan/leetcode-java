// CPS academy DSA sheet (Recursion and Backtracking)
// https://leetcode.com/problems/combinations/description/

package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem	        Branching Logic	                Complexity (Simplified)
 * Permutations	    n×(n−1)×(n−2)...	            O(n!)
 * Combinations	    Only move forward (Increasing)	O((nCk)) [choose k items from n total items]
 * Subsets	For     each element: "Yes" or "No"	    O(2n)
 */

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> resultList = new ArrayList<>();
		backtrack(n, k, 1, new ArrayList<>(), resultList);
		return resultList;
	}
	
	private void backtrack(int n, int k, int start, List<Integer> currentList, List<List<Integer>> resultList) {
		// Base case: `currentList` size equals to `k`
		if (currentList.size() == k) {
			resultList.add(new ArrayList<>(currentList));
			return;
		}
		
		for (int i = start; i <= n; i++) {
			// 1. Select option
			currentList.add(i);
			
			// 2. Explore current option (next numbers must be > i)
			backtrack(n, k, i + 1, currentList, resultList);
			
			// 3. Backtrack, remove option
			currentList.remove(currentList.size() - 1);
		}
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		Combinations myObj = new Combinations();
		System.out.println("Combinations (n=4, k=2): means range within [1,n] : " + myObj.combine(4, 2));
		System.out.println("(Expected: [[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]])");
	}
}