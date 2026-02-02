// https://leetcode.com/problems/plus-one-linked-list/description/
// PREMIUM

package linkedList;

public class PlusOneLinkedList {
	static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int val) {
			this.val = val;
		}
	}
	
	public ListNode plusOne(ListNode head) {
		// example: 9 -> 9 -> 9
		// example: 1 -> 2 -> 9 -> 9
		// example: 9 -> 9 -> 9
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		// set `dummy` as `lastNonNine` initially to handle cases like 999.
		ListNode lastNonNine = dummy;
		ListNode currNode = head;
		
		// find rightmost non-9 node
		while (currNode != null) {
			if (currNode.val != 9) {
				lastNonNine = currNode;
			}
			currNode = currNode.next;
		}
		
		// increment the last non-9 node
		lastNonNine.val++;
		
		// set all the following nodes to 0
		currNode = lastNonNine.next;
		while (currNode != null) {
			currNode.val = 0;
			currNode = currNode.next;
		}
		
		// For cases like: (999 -> 1000)
		// if `lastNonNine` still pointing to `dummy`, means the MSB was 9 and became 10, so `dummy` (which is 1) is new head.
		return lastNonNine == dummy ? dummy : dummy.next;
	}
	
	// ✅ printList() ✅
	public void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + (head.next != null ? " -> " : ""));
			head = head.next;
		}
		System.out.println();
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		PlusOneLinkedList myObj = new PlusOneLinkedList();
		
		// 1 -> 2 -> 9
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(9);
		System.out.print("Input: 129 ---> Output: ");
		myObj.printList(myObj.plusOne(head1));
		
		// 9 -> 9 -> 9
		ListNode head2 = new ListNode(9);
		head2.next = new ListNode(9);
		head2.next.next = new ListNode(9);
		System.out.print("Input: 999 ---> Output: ");
		myObj.printList(myObj.plusOne(head2));
	}
}