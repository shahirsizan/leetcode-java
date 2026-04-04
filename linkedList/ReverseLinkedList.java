// https://leetcode.com/problems/reverse-linked-list/description/
// CPS academy sheet (LL), Kunal Kushwaha (LL)

package linkedList;

public class ReverseLinkedList {
	
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
	
	// 🥎 reverseList() 🥎
	public ListNode reverseList(ListNode head) {
		// No node or only one node
		if (head == null || head.next == null) {
			return head;
		}
		
		// Have to utilize three separate pointers.
		// Nothing to understand. Just draw diagrams and it'll be easier to understand.
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = head.next;
		
		while (curr.next != null) {
			curr.next = prev;
			prev = curr;
			curr = next;
			next = next.next;
		}
		curr.next = prev;
		return curr;
	}
	
	// 🥎 main() 🥎
	public static void main(String[] args) {
		ReverseLinkedList myObj = new ReverseLinkedList();
		
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		System.out.println("Before reverse: 1 -> 2 -> 3 -> 4 -> 5");
		ListNode reversedHead = myObj.reverseList(head);
		System.out.print("After reverse: ");
		printList(reversedHead);
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