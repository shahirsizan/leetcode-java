// https://leetcode.com/problems/middle-of-the-linked-list/description/

package linkedList;

public class MiddleOfTheLinkedList {
	public static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int val) {
			this.val = val;
		}
		
		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	
	public ListNode middleNode(ListNode head) {
		ListNode slowPointer = head;
		ListNode fastPointer = head;
		
		// as long as the `fastPointer` AND the next of `fastPointer` not null, iterate
		while (fastPointer != null && fastPointer.next != null) {
			// slow pointer moves 1 step
			slowPointer = slowPointer.next;
			// fast pointer moves 2 steps
			fastPointer = fastPointer.next.next;
		}
		
		return slowPointer;
	}
	
	// --- Main Method for Demonstration ---
	
	public static void main(String[] args) {
		MiddleOfTheLinkedList solver = new MiddleOfTheLinkedList();
		
		// Example 1: Odd length (1 -> 2 -> 3 -> 4 -> 5). Middle should be 3.
		ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		ListNode middle1 = solver.middleNode(head1);
		System.out.println("Odd List Middle: " + middle1.val + " (Expected: 3)");
		
		// Example 2: Even length (1 -> 2 -> 3 -> 4 -> 5 -> 6). Middle should be 4.
		ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
		ListNode middle2 = solver.middleNode(head2);
		System.out.println("Even List Middle: " + middle2.val + " (Expected: 4)");
	}
}