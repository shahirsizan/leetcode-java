// https://leetcode.com/problems/remove-linked-list-elements/description/

package linkedList;

public class RemoveElementsLL {
	static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int val) {
			this.val = val;
		}
	}
	
	public ListNode removeElements(ListNode head, int val) {
		// dummy node pointing to head
		// `dummy.val` cannot be 0 because constraint says the original LL may contain 0
		ListNode dummy = new ListNode(-1);
		ListNode curr = dummy;
		curr.next = head;
		
		while (curr.next != null) {
			if (curr.next.val == val) {
				// skip link
				curr.next = curr.next.next;
			} else {
				curr = curr.next;
			}
		}
		
		return dummy.next;
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
		RemoveElementsLL myObj = new RemoveElementsLL();
		
		// 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6, val = 6
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next.next = new ListNode(6);
		
		System.out.print("Original: ");
		myObj.printList(head);
		
		ListNode result = myObj.removeElements(head, 6);
		
		System.out.print("After removing 6s: ");
		myObj.printList(result);
	}
}