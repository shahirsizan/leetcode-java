// CPS academy DSA sheet (Heaps & Priority Queues)
// https://leetcode.com/problems/ipo/description/

/**
 * 🥎 For `n` elements, pushing all and popping all from a binary heap-based priority queue takes a
 * total time complexity of O(nlogn)
 * https://share.google/aimode/ZA0kFMfdV6nq3ygnY
 * 🥎 time complexity of priority queue
 * https://share.google/aimode/har5fmgLByYw8SpNL
 * 🥎 time complexity of priority queue pop top element
 * https://share.google/aimode/Cg4ckjIJeWwzB60Mp
 */

/**
 * 🥎Time Complexity: O(nlogn + nlogn)
 * Sorting the projects takes O(nlogn).
 * Each project is pushed and popped from the Priority Queue at most once, taking O(logn) per operation.
 * We might need to push all `n` projects into the PQ if all are within our affordability.
 * 🥎Space Complexity: O(n)
 * We store all projects in a 2D array and potentially all profits in the Max-Heap.
 *
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class IPO {
	public int findMaximizedCapital(int k, int w, int[] givenProfits, int[] givenCapitals) {
		int n = givenProfits.length;
		int[][] projects2d = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			projects2d[i][0] = givenCapitals[i];
			projects2d[i][1] = givenProfits[i];
		}
		
		// Sort projects2d by `capital` (ASC order)
		Arrays.sort(projects2d, (a, b) -> a[0] - b[0]);
		
		// Max-Heap to store projects withing our affordability (Max profit on top)
		PriorityQueue<Integer> maxHeapProfit = new PriorityQueue<>((a, b) -> (b - a));
		
		int projectIdx = 0;
		// Iterate k times to pick `k` projects max
		for (int i = 0; i < k; i++) {
			// Add all possible projects within our affordability into Max-Heap
			while (projectIdx < n && projects2d[projectIdx][0] <= w) {
				maxHeapProfit.offer(projects2d[projectIdx][1]);
				projectIdx++;
			}
			
			// If we can't afford any new projects, break early
			if (maxHeapProfit.isEmpty()) {
				break;
			}
			
			// Greedy: Pick the most profitable project
			w += maxHeapProfit.poll();
		}
		
		return w;
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		IPO myObj = new IPO();
		int k = 2, w = 0;
		int[] profits = {1, 2, 3};
		int[] capital = {0, 1, 1};
		
		System.out.println("Max capital possible: " + myObj.findMaximizedCapital(k, w, profits, capital) + " (Expected: 4)");
	}
}