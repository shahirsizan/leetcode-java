// https://leetcode.com/problems/odd-even-linked-list/description/

package linkedList;


public class OddEvenLinkedList {
	static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int val) {
			this.val = val;
		}
	}
	
	public ListNode oddEvenList(ListNode head) {
		// if no node OR only single node, return `head`
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode odd = head;             // first odd node
		ListNode even = head.next;       // second even node
		ListNode evenHead = even;        // head for even sub-linkedlist
		
		// loop through the list
		while (even != null && even.next != null) {
			// next node of current even node will become the next node of current odd node
			odd.next = even.next;
			// then slide the `odd` pointer
			odd = odd.next;
			
			// next node of new current odd node will become the next node of current even node
			even.next = odd.next;
			// then slide the `even` pointer
			even = even.next;
		}
		
		// up until now, `head` pointer pointing to the first of the odd sublist,
		// `odd` pointer pointing to the last of the odd sublist,
		// `evenHead` pointer pointing to the first of the even sublist.
		// establish link: `odd` -> `evenHead`
		odd.next = evenHead;
		
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
		OddEvenLinkedList myObj = new OddEvenLinkedList();
		
		// 1 -> 2 -> 3 -> 4 -> 5
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		System.out.print("Original: ");
		myObj.printList(head);
		
		ListNode result = myObj.oddEvenList(head);
		
		System.out.println("Odd-Even: (Expected: 1 -> 3 -> 5 -> 2 -> 4)");
		myObj.printList(result);
	}
}