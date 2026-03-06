// // CPS academy DSA sheet (Heaps & Priority Queues)
// https://leetcode.com/problems/find-median-from-data-stream/description/

import java.util.PriorityQueue;


class FindMedian {
	/**
	 * Why `Priority queue` instead of normal Array/ArrayList?
	 * Because the data are dynamically inserted.
	 * Array/ArrayList requires resizing which requires O(n) T.C.
	 * Also data may arrive out of order, so would need O(nlogn) sorting TC.
	 * `Priority queue` has O(logn) insertion T.C. This is the main reason we use it!
	 * Although both has O(1) TC for (middle element in array and top head in PQ).
	 * The "special" thing about the Priority Queue (Heap) approach isn't how fast it finds the median,
	 * it's how fast it stays ready to find the next one.
	 * for more: https://share.google/aimode/FuHvBdUmbFiTd3XTP
	 */
	
	private PriorityQueue<Integer> leftMaxHeap; // Stores the smaller left half
	private PriorityQueue<Integer> rightMinHeap; // Stores the larger right half
	
	public FindMedian() {
		leftMaxHeap = new PriorityQueue<>((a, b) -> {
			return b - a;
		});
		rightMinHeap = new PriorityQueue<>();
	}
	
	public void addNum(int num) {
		// 1. First add to left Max-Heap
		leftMaxHeap.offer(num);
		
		// 2. Balance. Move the largest of left to the rightMinHeap
		rightMinHeap.offer(leftMaxHeap.poll());
		
		// 3. Check if balanced. Maintain size property (Left heap size >= Right heap size)
		if (leftMaxHeap.size() < rightMinHeap.size()) {
			leftMaxHeap.offer(rightMinHeap.poll());
		}
	}
	
	public double findMedian() {
		// if one of the heap is larger, then the `top` of the `larger` heap is the median
		// else the median is: (left heap head + left heap head) / 2.0
		if (leftMaxHeap.size() != rightMinHeap.size()) {
			return leftMaxHeap.peek();
		} else {
			return (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
		}
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		FindMedian myObj = new FindMedian();
		myObj.addNum(1);
		myObj.addNum(2);
		System.out.println("Median after 1, 2: " + myObj.findMedian()); // 1.5
		myObj.addNum(3);
		System.out.println("Median after 1, 2, 3: " + myObj.findMedian()); // 2.0
	}
}