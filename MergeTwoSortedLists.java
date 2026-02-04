// https://leetcode.com/problems/merge-two-sorted-lists/

public class MergeTwoSortedLists {
	
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
	
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		// list1: 1 -> 2 -> 4
		// list2: 1 -> 3 -> 4
		// `newDummyHead` value doesn't matter, we will return `newDummyHead.next`
		ListNode newDummyHead = new ListNode(0);
		ListNode currentDummy = newDummyHead;
		
		// also, we are merging the lists, so changing the heads of the two lists is OK
		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				currentDummy.next = list1;
				list1 = list1.next;
			} else {
				currentDummy.next = list2;
				list2 = list2.next;
			}
			currentDummy = currentDummy.next;
		}
		
		// append the remainder of the non-null list after `currentDummy`
		if (list1 != null) {
			currentDummy.next = list1;
		} else if (list2 != null) {
			currentDummy.next = list2;
		}
		
		// return new head of the merged list
		return newDummyHead.next;
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
		MergeTwoSortedLists myObj = new MergeTwoSortedLists();
		
		// 1 -> 2 -> 4
		ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
		// 1 -> 3 -> 4
		ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
		
		ListNode mergedHead = myObj.mergeTwoLists(list1, list2);
		
		System.out.println("Merged List (Expected: 1 -> 1 -> 2 -> 3 -> 4 -> 4): ");
		printList(mergedHead);
	}
}