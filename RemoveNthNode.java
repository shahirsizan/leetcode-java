public class RemoveNthNode {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode slowPointer = head;
		ListNode fastPointer = head;

		// single node, also n=1, means have to delete the linked list entirely. Return null
		if(slowPointer.next == null && n == 1){
			return null;
		}

		for (int i = 0; i < n; i++) {
			fastPointer = fastPointer.next;
		}

		//	`fastPointer` null, means the `slowPointer` or HEAD is to be deleted
		if(fastPointer == null){
			slowPointer = slowPointer.next;
			return slowPointer;
		}

		while (fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next;
		}

		// slowPointer now pointing to the node before the `target` node.
		// bypass the target which is `slowPointer.next` by linking `slowPointer.next.next` to `slowPointer`
		slowPointer.next = slowPointer.next.next;

		return head;
	}

	// --- Main ---

	public static void main(String[] args) {
		RemoveNthNode solver = new RemoveNthNode();

		// Example 1: List 1 -> 2 -> 3 -> 4 -> 5, n=2. Expected: 1 -> 2 -> 3 -> 5
		ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		ListNode result1 = solver.removeNthFromEnd(head1, 2);
		System.out.print("Example 1 (n=2): ");
		printList(result1);

		// Example 2: List 1 -> 2, n=2 (Remove head). Expected: 2
		ListNode head2 = new ListNode(1, new ListNode(2));
		ListNode result2 = solver.removeNthFromEnd(head2, 2);
		System.out.print("Example 2 (n=2, remove head): ");
		printList(result2);
	}

	// Helper function to print the list
	private static void printList(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.val + (current.next != null ? " -> " : ""));
			current = current.next;
		}
		System.out.println();
	}
}