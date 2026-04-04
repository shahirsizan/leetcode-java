// https://leetcode.com/problems/sort-list/description/
// CPS academy sheet (LL, Sorting Algorithms), Kunal Kushwaha (LL)

public class SortList {
	
	// don't include the below `ListNode` class in leetcode. Lest you'll get compilation error.
	public static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int val) {
			this.val = val;
		}
	}
	
	// 🥎 sortLinkedList() -> helper method 🥎
	public ListNode sortList(ListNode head) {
		head = mergeSort(head);
		return head;
	}
	
	// 🥎 sortList() -> actual starting point 🥎
	public ListNode mergeSort(ListNode head) {
		// base case: 0 or 1 element, already sorted, return.
		if (head == null || head.next == null) {
			return head;
		}
		
		// split the list
		ListNode midPointer = findMiddle(head);
		ListNode rightHead = midPointer.next;
		midPointer.next = null;
		
		// recursively split
		ListNode leftSortedHead = mergeSort(head);
		ListNode rightSortedHead = mergeSort(rightHead);
		
		// merge the sorted halves
		return merge(leftSortedHead, rightSortedHead);
	}
	
	// 🥎 findMiddle() -> find middle of linked list 🥎
	private ListNode findMiddle(ListNode head) {
		// We need to start `fastPointer` from `slowPointer.next`, because we need the immediate-node before the actual mid-node.
		// If we start `fastPointer` from same position as `slowPointer`, we will get the actual midpoint, that would be the starting of `right sublist`.
		// But then we won't be able to mark the last node of `left sublist` as null.
		ListNode slowPointer = head;
		ListNode fastPointer = head.next;
		
		// slowPointer -> 1 step ;  fastPointer -> 2 steps
		while (fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}
		return slowPointer;
	}
	
	// 🥎 merge() -> merge 2 sorted list 🥎
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
	
	// 🥎 main() 🥎
	public static void main(String[] args) {
		SortList myObj = new SortList();
		
		ListNode head = new ListNode(4);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(3);
		
		ListNode sortedHead = myObj.sortList(head);
		
		System.out.println("Before sort: 4 -> 2 -> 1 -> 3");
		System.out.print("After sort: ");
		printList(sortedHead);
	}
	
	// 🥎 printList() 🥎
	private static void printList(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.val + (current.next != null ? " -> " : ""));
			current = current.next;
		}
		System.out.println();
	}
}