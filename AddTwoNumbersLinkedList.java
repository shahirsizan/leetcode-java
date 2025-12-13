public class AddTwoNumbersLinkedList {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
		ListNode dummyHeadToBeReturned = new ListNode(0);
		ListNode currentNode = dummyHeadToBeReturned;

		ListNode list1Pointer = list1;
		ListNode list2Pointer = list2;
		int carry = 0;

		// loop as long as there is non-null `list1Pointer` or `list2Pointer` or `carry`
		while (list1Pointer != null || list2Pointer != null || carry != 0) {
			int digit1 = (list1Pointer != null) ? list1Pointer.val : 0 ;
			int digit2 = (list2Pointer != null) ? list2Pointer.val : 0 ;
			int sum = digit1 + digit2 + carry;
			int newDigit = sum % 10;
			carry = sum / 10;

			ListNode newNode = new ListNode(newDigit);
			currentNode.next = newNode;
			currentNode = currentNode.next;

			if(list1Pointer != null){
				list1Pointer = list1Pointer.next;
			}
			if(list2Pointer != null){
				list2Pointer = list2Pointer.next;
			}
		}

		return dummyHeadToBeReturned.next;
	}

	// --- Main ---

	public static void main(String[] args) {
		AddTwoNumbersLinkedList solver = new AddTwoNumbersLinkedList();

		// Example: (2 -> 4 -> 3) + (5 -> 6 -> 4) = 342 + 465 = 807
		// Result list should be: 7 -> 0 -> 8
		ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
		ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

		ListNode result = solver.addTwoNumbers(l1, l2);

		System.out.print("Input 1: ");
		printList(l1);
		System.out.print("Input 2: ");
		printList(l2);

		System.out.print("Sum (Reversed): ");
		printList(result); // Expected: 7 -> 0 -> 8

		// Example 2: Lists of different length with final carry (9) + (9) = 18
		// (9 -> 9) + (1) = 99 + 1 = 100
		// Result list should be: 0 -> 0 -> 1
		ListNode l3 = new ListNode(9, new ListNode(9));
		ListNode l4 = new ListNode(1);
		ListNode result2 = solver.addTwoNumbers(l3, l4);

		System.out.print("\nSum (99 + 1): ");
		printList(result2); // Expected: 0 -> 0 -> 1
	}

	// Helper function to print the list
	private static void printList(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.val + (current.next != null ? " -> " : ""));
			current = current.next;
		}
		System.out.println();
	}
}