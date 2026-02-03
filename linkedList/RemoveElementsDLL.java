// inspired from `RemoveElementsLL` problem of takeUforward

package linkedList;


public class RemoveElementsDLL {
	static class DLLNode {
		int val;
		DLLNode next, prev;
		
		DLLNode(int val) {
			this.val = val;
		}
	}
	
	public DLLNode removeElements(DLLNode head, int val) {
		// 1. Create dummy node to handle head deletion
		DLLNode dummy = new DLLNode(-1);
		dummy.next = head;
		if (head != null) head.prev = dummy;
		
		DLLNode curr = head;
		
		while (curr != null) {
			if (curr.val == val) {
				// 2. Stitch the previous node to the next node
				curr.prev.next = curr.next;
				
				// 3. Stitch the next node back to the previous node (if it exists)
				if (curr.next != null) {
					curr.next.prev = curr.prev;
				}
			}
			// Move to the next node in the original sequence
			curr = curr.next;
		}
		
		// Clean up: set the new head's prev to null
		DLLNode newHead = dummy.next;
		if (newHead != null) newHead.prev = null;
		
		return newHead;
	}
	
	// ✅ printList() ✅
	public void printList(DLLNode head) {
		DLLNode curr = head;
		while (curr != null) {
			System.out.print(curr.val + (curr.next != null ? " <-> " : ""));
			curr = curr.next;
		}
		System.out.println();
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		RemoveElementsDLL myObj = new RemoveElementsDLL();
		
		// 6 <-> 1 <-> 6 <-> 2
		DLLNode n1 = new DLLNode(6);
		DLLNode n2 = new DLLNode(1);
		DLLNode n3 = new DLLNode(6);
		DLLNode n4 = new DLLNode(2);
		
		n1.next = n2;
		n2.prev = n1;
		n2.next = n3;
		n3.prev = n2;
		n3.next = n4;
		n4.prev = n3;
		
		System.out.print("Original DLL: ");
		myObj.printList(n1);
		
		DLLNode result = myObj.removeElements(n1, 6);
		
		System.out.print("After removing 6s: ");
		myObj.printList(result);
	}
}
