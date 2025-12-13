public class SortList {
// don't include the below `ListNode` class in leetcode. Lest you'll get compilation error.
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int val) { this.val = val; }
	}

	public ListNode sortList(ListNode head) {
		// base case: 0 or 1 element, already sorted, return.
		if (head == null || head.next == null) {
			return head;
		}

		// split the list
		ListNode midPointer = findMiddle(head);
		ListNode rightHead = midPointer.next;
		midPointer.next = null;

		// recursively split
		ListNode leftSortedHead = sortList(head);
		ListNode rightSortedHead = sortList(rightHead);

		// merge the sorted halves
		return merge(leftSortedHead, rightSortedHead);
	}

	private ListNode findMiddle(ListNode head) {
		ListNode slowPointer = head;
		ListNode fastPointer = head.next;

//		slowPointer -> one step ;  fastPointer -> two steps
		while (fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}
		return slowPointer;
	}

	private ListNode merge(ListNode leftSortedHead, ListNode rightSortedHead) {
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

	public static void main(String[] args) {
		SortList solver = new SortList();

		// Input: 4 -> 2 -> 1 -> 3
		ListNode head = new ListNode(4);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(3);

		System.out.print("Original List: ");
		printList(head);

		ListNode sortedHead = solver.sortList(head);

		System.out.print("Sorted List:   ");
		printList(sortedHead);
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