// https://leetcode.com/problems/add-two-numbers-ii/description/

package linkedList;


import java.util.Stack;


public class AddTwoNumbersLinkedList2 {
	static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int val) {
			this.val = val;
		}
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		
		// push l1 values into stack1
		while (l1 != null) {
			stack1.push(l1.val);
			l1 = l1.next;
		}
		
		// push l2 values into stack2
		while (l2 != null) {
			stack2.push(l2.val);
			l2 = l2.next;
		}
		
		int carry = 0;
		ListNode head = null;
		
		// Process stacks
		while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
			int sum = carry;
			
			if (!stack1.isEmpty()) {
				sum += stack1.pop();
			}
			if (!stack2.isEmpty()) {
				sum += stack2.pop();
			}
			
			carry = sum / 10;
			// create new node and insert to the left of the head each time
			ListNode newNode = new ListNode(sum % 10);
			newNode.next = head;
			head = newNode;
		}
		
		// `head` now points to the leftmost digit of the sum
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
		AddTwoNumbersLinkedList2 myObj = new AddTwoNumbersLinkedList2();
		
		// 7 -> 2 -> 4 -> 3
		ListNode l1 = new ListNode(7);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1.next.next.next = new ListNode(3);
		
		// 5 -> 6 -> 4
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		System.out.print("L1: ");
		myObj.printList(l1);
		System.out.print("L2: ");
		myObj.printList(l2);
		
		ListNode result = myObj.addTwoNumbers(l1, l2);
		System.out.print("Sum: ");
		myObj.printList(result); // Expected: 7 -> 8 -> 0 -> 7
	}
}