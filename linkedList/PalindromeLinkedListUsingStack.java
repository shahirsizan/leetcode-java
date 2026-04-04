// https://leetcode.com/problems/palindrome-linked-list/description/
// CPS academy sheet (LL), Kunal Kushwaha (LL)

package linkedList;

import java.util.Stack;

/**
 * This approach is non-destructive. We are not modifying the original LL.
 * The approach where links are modified is a destructive approach.
 */

public class PalindromeLinkedListUsingStack {
	
	public static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int val) {
			this.val = val;
		}
	}
	
	public boolean isPalindrome(ListNode head) {
		// if only one node, it's by default palindrome
		if (head.next == null) {
			return true;
		}
		
		Stack<Integer> stack = new Stack<>();
		ListNode currNode = head;
		
		// 1. Push all values into stack
		while (currNode != null) {
			stack.push(currNode.val);
			currNode = currNode.next;
		}
		
		// 2. Pop from stack and compare with original LL (left-to-right)
		currNode = head;
		while (currNode != null) {
			if (currNode.val != stack.pop()) {
				return false;
			}
			currNode = currNode.next;
		}
		
		return true;
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		PalindromeLinkedListUsingStack myObj = new PalindromeLinkedListUsingStack();
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);
		
		System.out.println("Original: 1 -> 2 -> 2 -> 1");
		boolean result = myObj.isPalindrome(head);
		System.out.println("Is Palindrome? : " + result);
	}
}