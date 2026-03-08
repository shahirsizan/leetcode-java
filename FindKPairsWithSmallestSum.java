// CPS academy DSA sheet (Heaps & Priority Queues)
// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 🥎Time Complexity:
 * 1. To build the minHeap for min(n,k) elements -> O[ min(n,k) * (log(min(n,k))) ]
 * 2. Each of the min(n,k) k extractions takes O[ min(n,k) * log(min(n,k)) ].
 * 🥎Space Complexity: O(min(n,k))
 */

public class FindKPairsWithSmallestSum {
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> resultList = new ArrayList<>();
		
		// MinHeap each element: {sum, nums1_idx, nums2_idx}
		PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		
		// Initially push (nums1[i], nums2[0]) for first `k` elements OR all of `nums1` if k > nums1.length
		for (int i = 0; i < Math.min(nums1.length, k); i++) {
			minHeap.offer(new int[]{nums1[i] + nums2[0], i, 0});
		}
		
		// Extract `k` times
		while (k > 0 && !minHeap.isEmpty()) {
			// current min sum
			int[] current = minHeap.poll();
			int sum = current[0];
			int i = current[1];
			int j = current[2];
			
			// Add current pair to result
			resultList.add(Arrays.asList(nums1[i], nums2[j]));
			
			// If there's a next element in nums2, push (nums1[i], nums2[j+1]) in minHeap
			if (j + 1 < nums2.length) {
				minHeap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
			}
			
			k--;
		}
		
		return resultList;
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		FindKPairsWithSmallestSum myObj = new FindKPairsWithSmallestSum();
		int[] n1 = {1, 7, 11}, n2 = {2, 4, 6};
		int k = 3;
		System.out.println("K Smallest Pairs: " + myObj.kSmallestPairs(n1, n2, k) + " (Expected: [[1, 2], [1, 4], [1, 6]])");
	}
}