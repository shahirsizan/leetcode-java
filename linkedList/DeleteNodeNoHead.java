// https://leetcode.com/problems/delete-node-in-a-linked-list/description/

package linkedList;

public class DeleteNodeNoHead {
	static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int val) {
			this.val = val;
		}
	}
	
	public void deleteNode(ListNode targetNode) {
		// we just copy the `next` node data to `current` node and skip that `next` node
		targetNode.val = targetNode.next.val;
		targetNode.next = targetNode.next.next;
	}
	
	// ✅ printList() ✅
	public void printList(ListNode head) {
		ListNode curr = head;
		while (curr != null) {
			System.out.print(curr.val + (curr.next != null ? " -> " : ""));
			curr = curr.next;
		}
		System.out.println();
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		DeleteNodeNoHead myObj = new DeleteNodeNoHead();
		
		// 4 -> 5 -> 1 -> 9
		ListNode head = new ListNode(4);
		head.next = new ListNode(5);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(9);
		
		ListNode nodeToDelete = head.next;
		
		System.out.print("Before: ");
		myObj.printList(head);
		
		// delete `5`
		myObj.deleteNode(nodeToDelete);
		
		System.out.print("After:  ");
		myObj.printList(head);
	}
}