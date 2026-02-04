// https://leetcode.com/problems/rotate-list/description/

package linkedList;


public class RotateLL {
	static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int val) {
			this.val = val;
		}
	}
	
	public ListNode rotateRight(ListNode head, int k) {
		// if empty list OR single node OR k = 0
		// return head itself
		if (head == null || head.next == null || k == 0) {
			return head;
		}
		
		// calculate length and find the last node
		ListNode currNode = head;
		int listLength = 1;
		while (currNode.next != null) {
			currNode = currNode.next;
			listLength++;
		}
		
		
		// normalize k, if remainder == 0,
		// means the result list will resemble the original list. So return the head itself.
		k = k % listLength;
		if (k == 0) {
			return head;
		}
		
		// at this point, `currNode` points at the last node
		// make the list circular
		currNode.next = head;
		
		// find the new tail: `listLength - k - 1` steps from head
		ListNode newTail = head;
		for (int i = 0; i < listLength - k - 1; i++) {
			newTail = newTail.next;
		}
		
		// newTail.next is our new head
		ListNode newHead = newTail.next;
		newTail.next = null;
		
		return newHead;
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
		RotateLL solver = new RotateLL();
		
		// 1 -> 2 -> 3 -> 4 -> 5, k = 2
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		System.out.print("Original: ");
		solver.printList(head);
		
		ListNode result = solver.rotateRight(head, 2);
		System.out.print("Rotated (k=2): ");
		solver.printList(result);
	}
}