// https://leetcode.com/problems/palindrome-linked-list/description/
// CPS academy sheet (LL), Kunal Kushwaha (LL)

package linkedList;

/**
 * This approach is destructive because we are modifying the original LL.
 * For non-destructive approach, use Stack.
 * Solved that way in `PalindromeLinkedListUsingStack` class
 *
 */

public class PalindromeLinkedList {
	
	static class ListNode {
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
		
		// if more than one node, find the middle of the list.
		ListNode slowPointer = head;
		ListNode fastPointer = head;
		while (fastPointer.next != null && fastPointer.next.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}
		
		// `slowPointer` now pointing at the node `immediately` before the middle of list. Reverse the second half.
		ListNode secondHalfHead = reverse(slowPointer.next);
		
		// at this point, `secondHalfHead` acting as head of the reversed second half list
		// compare the two halves.
		ListNode firstHalfIterator = head;
		ListNode secondHalfIterator = secondHalfHead;
		boolean result = true;
		while (secondHalfIterator != null) {
			if (firstHalfIterator.val != secondHalfIterator.val) {
				result = false;
				break;
			}
			firstHalfIterator = firstHalfIterator.next;
			secondHalfIterator = secondHalfIterator.next;
		}
		
		return result;
	}
	
	private ListNode reverse(ListNode head) {
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
	
	// ✅ printList() ✅
	public void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		PalindromeLinkedList myObj = new PalindromeLinkedList();
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);
		
		System.out.println("Original: 1 -> 2 -> 2 -> 1");
		boolean result = myObj.isPalindrome(head);
		System.out.println("Is Palindrome? : " + result);
	}
}