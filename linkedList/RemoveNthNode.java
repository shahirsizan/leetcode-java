// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

package linkedList;

public class RemoveNthNode {
	
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
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode slowPointer = head;
		ListNode fastPointer = head;
		
		// only one node AND n=1
		if (n == 1 && head.next == null) {
			head = null;
			return head;
		}
		
		// create a gap of `n` places between the two pointers
		// for n=2 (to delete 2nd last node), we'll have following tail portion: `.....->.....-> slowPointer -> nodeToDelete -> fastPointer(END)`
		for (int i = 0; i < n; i++) {
			fastPointer = fastPointer.next;
		}
		
		//	`fastPointer` null means the `slowPointer` still pointing at the HEAD, which is to be deleted
		if (fastPointer == null) {
			head = head.next;
			return head;
		}
		
		// else, traverse both the pointers together
		while (fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next;
		}
		
		// slowPointer now pointing at the node before the `target` node.
		// bypass the target which is `slowPointer.next` by linking `slowPointer.next.next` to `slowPointer`
		slowPointer.next = slowPointer.next.next;
		
		return head;
	}
	
	// ✅ printList() ✅
	private static void printList(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.val + (current.next != null ? " -> " : ""));
			current = current.next;
		}
		System.out.println();
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		RemoveNthNode solver = new RemoveNthNode();
		
		// Example 1: List 1 -> 2 -> 3 -> 4 -> 5, n=2. Expected: 1 -> 2 -> 3 -> 5
		ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		System.out.print("Example 1, n=2: ");
		printList(head1);
		ListNode result1 = solver.removeNthFromEnd(head1, 2);
		System.out.print("Result 1: ");
		printList(result1);
		
		System.out.println("----------");
		
		// Example 2: List 1 -> 2, n=2 (Remove head). Expected: 2
		ListNode head2 = new ListNode(1, new ListNode(2));
		System.out.print("Example 2, n=2: ");
		printList(head2);
		ListNode result2 = solver.removeNthFromEnd(head2, 2);
		System.out.print("Result 2: ");
		printList(result2);
	}
}