// https://leetcode.com/problems/linked-list-cycle/description/

package linkedList;

public class LinkedListCycle {
	
	public static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public boolean hasCycle(ListNode head) {
		// if head `empty` or just a `single-node` (no cycle possible)
		if (head == null || head.next == null) {
			return false;
		}
		
		ListNode slowPointer = head;
		ListNode fastPointer = head;
		
		while (fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
			
			// the backward distance between the pointers will decrease by one node per iteration,
			// so the distance must become zero and eventually the pointers will meet.
			if (slowPointer == fastPointer) {
				return true;
			}
		}
		
		// If `fastPointer` is null or `fastPointer->next` is null, meaning it reached the end, there is no cycle
		return false;
	}
	
	
	// --- Main Method for Demonstration ---
	
	public static void main(String[] args) {
		LinkedListCycle solver = new LinkedListCycle();
		
		// Example 1: List with a cycle (3 -> 2 -> 0 -> -4 -> 2)
		ListNode head1 = new ListNode(3);
		ListNode node2 = new ListNode(2);
		ListNode node0 = new ListNode(0);
		ListNode nodeN4 = new ListNode(-4);
		
		head1.next = node2;
		node2.next = node0;
		node0.next = nodeN4;
		nodeN4.next = node2; // Cycle: -4 points back to 2
		
		System.out.println("List 1 (Cycle): " + solver.hasCycle(head1) + " (Expected: true)");
		
		// Example 2: List without a cycle (1 -> 2 -> 3)
		ListNode head2 = new ListNode(1);
		head2.next = new ListNode(2);
		head2.next.next = new ListNode(3);
		
		System.out.println("List 2 (No Cycle): " + solver.hasCycle(head2) + " (Expected: false)");
	}
}