public class ReorderList {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}


	public void reorderList(ListNode head) {
		//		if `no node` or `single node` or only `two nodes`, return
		if (head == null || head.next == null || head.next.next == null) {
			return;
		}

		//		procedure:
		//		1. find the middle of the list.
		//		2. reverse the second half.
		//		3. merge one-by-one from each of the sublists.

		//		1. find the middle of the list.
		ListNode slowPointer = head;
		ListNode fastPointer = head;
		while (fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}

		// 	declare the head of the second half list
		ListNode headOfSecondHalf = slowPointer.next;
		slowPointer.next = null;

		//		2. reverse the second half.
		ListNode prevNode = null;
		ListNode currNode = headOfSecondHalf;
		ListNode nextNode = currNode.next;
		while (nextNode != null) {
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
			nextNode = nextNode.next;
		}
		currNode.next = prevNode;

		//		3. merge one-by-one from each of the sublists.
		ListNode p1 = head; // 'p1' is head of the first half
		ListNode p2 = currNode; // 'p2' is head of the reversed second half

		while (p2 != null) {
			// temporary nodes track future `next node`
			ListNode p1NextTemp = p1.next;
			ListNode p2NextTemp = p2.next;

			// update `next` references
			p1.next = p2;
			p2.next = p1NextTemp;

			// advance the pointers
			p1 = p1NextTemp;
			p2 = p2NextTemp;
		}

		// nothing to return
	}

	// --- Main Method for Demonstration ---

	public static void main(String[] args) {
		ReorderList solver = new ReorderList();

		// Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));

		System.out.print("Original List: ");
		printList(head);

		solver.reorderList(head);

		System.out.print("Reordered List: ");
		printList(head); // Expected: 1 -> 6 -> 2 -> 5 -> 3 -> 4
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