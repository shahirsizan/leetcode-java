// CPS academy DSA sheet (Heaps & Priority Queues)
// https://leetcode.com/problems/kth-largest-element-in-an-array/

import java.util.PriorityQueue;

public class KthLargest {
	public int findKthLargest(int[] nums, int k) {
		// PriorityQueue is a min-heap by default
		// 🥎 TO GET KTH SMALLEST, USE MAX-HEAP
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		for (int num : nums) {
			minHeap.add(num);
			
			// if heap size exceeds `k`, remove top (smallest element)
			// at the end, we'll have `k` elements which are `largest` among all.
			// the `top` one is the smallest among them
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}
		
		return minHeap.peek();
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		KthLargest myObj = new KthLargest();
		int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
		int k = 4;
		
		System.out.println("Array: [3, 2, 3, 1, 2, 4, 5, 5, 6], k = 4");
		System.out.println("4th largest element: " + myObj.findKthLargest(nums, k) + " (Expected: 4)");
	}
}