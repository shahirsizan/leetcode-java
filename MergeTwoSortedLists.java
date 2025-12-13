public class MergeTwoSortedLists {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public ListNode mergeTwoLists(ListNode leftSortedHead, ListNode rightSortedHead) {
		ListNode dummyHeadToBeReturned = new ListNode(0);
		ListNode currentDummy = dummyHeadToBeReturned;

		while (leftSortedHead != null && rightSortedHead != null) {
			if (leftSortedHead.val <= rightSortedHead.val) {
				currentDummy.next = leftSortedHead;
				leftSortedHead = leftSortedHead.next;
			} else {
				currentDummy.next = rightSortedHead;
				rightSortedHead = rightSortedHead.next;
			}
			currentDummy = currentDummy.next;
		}

		// append the remainder of the non-null list after `currentDummy`
		if (leftSortedHead != null) {
			currentDummy.next = leftSortedHead;
		} else if (rightSortedHead != null) {
			currentDummy.next = rightSortedHead;
		}

		// return new head of the merged list
		return dummyHeadToBeReturned.next;
	}

	// --- Main Method for Demonstration ---
	public static void main(String[] args) {
		MergeTwoSortedLists solver = new MergeTwoSortedLists();

		// List 1: 1 -> 2 -> 4
		ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
		// List 2: 1 -> 3 -> 4
		ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

		System.out.print("List 1: ");
		printList(list1);
		System.out.print("List 2: ");
		printList(list2);

		ListNode mergedHead = solver.mergeTwoLists(list1, list2);

		System.out.print("Merged List: ");
		printList(mergedHead); // Expected: 1 -> 1 -> 2 -> 3 -> 4 -> 4
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