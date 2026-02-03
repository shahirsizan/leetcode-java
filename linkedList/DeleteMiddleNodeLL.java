// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/

package linkedList;

public class DeleteMiddleNodeLL {
	static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int val) {
			this.val = val;
		}
	}
	
	public ListNode deleteMiddle(ListNode head) {
		// Edge case: if n=1, we have to delete the only node. So return null
		if (head.next == null) {
			return null;
		}
		
		ListNode slowPointer = head;
		ListNode fastPointer = head;
		ListNode prevPointer = null; // to keep track of the immediate previous node of 'slowPointer'
		
		// tortoise-hare approach
		while (fastPointer != null && fastPointer.next != null) {
			prevPointer = slowPointer;
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}
		
		// at this point,
		// `fastPointer` is at the end,
		// 'slowPointer' is at the middle and
		// 'prevPointer' is immediately behind of `slowPointer`
		// Delete the `slowPointer` node by skipping it.
		prevPointer.next = slowPointer.next;
		
		return head;
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
		DeleteMiddleNodeLL myObj = new DeleteMiddleNodeLL();
		
		// 1 -> 3 -> 4 -> `7` -> 1 -> 2 -> 6
		ListNode head = new ListNode(1);
		head.next = new ListNode(3);
		head.next.next = new ListNode(4);
		head.next.next.next = new ListNode(7);
		head.next.next.next.next = new ListNode(1);
		head.next.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next.next = new ListNode(6);
		
		System.out.print("Original: ");
		myObj.printList(head);
		
		ListNode result = myObj.deleteMiddle(head);
		
		System.out.print("After deleting middle: ");
		myObj.printList(result);
	}
}