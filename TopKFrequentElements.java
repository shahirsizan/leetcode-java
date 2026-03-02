// CPS academy DSA sheet (Arrays)
// https://leetcode.com/problems/top-k-frequent-elements/description/

import java.util.*;

public class TopKFrequentElements {
	public int[] topKFrequent(int[] givenNums, int k) {
		Map<Integer, Integer> ourHashMap = new HashMap<>();
		
		// {4, 1, -1, 2, -1, 2, 3}
		
		// populate ourHashMap
		for (int num : givenNums) {
			if (ourHashMap.containsKey(num)) {
				ourHashMap.put(num, ourHashMap.get(num) + 1);
			} else {
				ourHashMap.put(num, 1);
			}
		}
		
		// `min heap` will contain least counted element in its head.
		// So during traversal of the hashmap, all the elements with `less count` will get into the head and polled out.
		// the last `k` elements that reside in the heap are the `k` largest elements
		PriorityQueue<Map.Entry<Integer, Integer>> ourMinHeap = new PriorityQueue<>(
				(a, b) -> a.getValue() - b.getValue()
		);
		
		for (Map.Entry<Integer, Integer> entry : ourHashMap.entrySet()) {
			ourMinHeap.add(entry);
			
			if (ourMinHeap.size() > k) {
				ourMinHeap.poll();
			}
		}
		
		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			// Below `Objects.requireNonNull()` were suggested by IDE.
			// Only `ourMinHeap.poll()).getKey()` would also work.
			result[i] = Objects.requireNonNull(ourMinHeap.poll()).getKey();
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		TopKFrequentElements myObj = new TopKFrequentElements();
		
		int[] nums = {4, 1, -1, 2, -1, 2, 3};
		int k = 2;
		int[] result = myObj.topKFrequent(nums, k);
		// frequencies: 1:1, -1:2, 2:2, 3:1. Top 2 are -1 and 2.
		System.out.println("Input: " + Arrays.toString(nums) + ", k: " + k);
		System.out.println("Result: " + Arrays.toString(result));
	}
}
