// https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/

package linkedList;

public class RemoveDuplicatesLL {
	
	static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int val) {
			this.val = val;
		}
	}
	
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode currPointer = head;
		
		while (currPointer != null && currPointer.next != null) {
			// if `current` and `next` both are same, skip that `next`
			if (currPointer.val == currPointer.next.val) {
				currPointer.next = currPointer.next.next;
			}
			// else increment `current`
			else {
				// Otherwise, just move the pointer forward
				currPointer = currPointer.next;
			}
		}
		
		return head;
	}
	
	// ✅ printList() ✅
	public void printList(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.val + (temp.next != null ? " -> " : ""));
			temp = temp.next;
		}
		System.out.println();
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		RemoveDuplicatesLL myObj = new RemoveDuplicatesLL();
		
		// 1 -> 1 -> 2 -> 3 -> 3
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(3);
		
		System.out.print("Before: ");
		myObj.printList(head);
		
		ListNode result = myObj.deleteDuplicates(head);
		
		System.out.print("After: ");
		myObj.printList(result);
	}
}