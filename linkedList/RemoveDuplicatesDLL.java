// https://www.youtube.com/watch?v=YJKVTnOJXSY&list=PLgUwDviBIf0rAuz8tVcM0AymmhTRsfaLU&index=21

package linkedList;


public class RemoveDuplicatesDLL {
	static class DLLNode {
		int val;
		DLLNode next, prev;
		
		DLLNode(int val) {
			this.val = val;
		}
	}
	
	public DLLNode removeDuplicates(DLLNode head) {
		if (head == null) {
			return head;
		}
		
		DLLNode currNode = head;
		
		while (currNode.next != null) {
			// duplicate
			if (currNode.val == currNode.next.val) {
				currNode.next = currNode.next.next;
				
				if (currNode.next != null) {
					currNode.next.prev = currNode;
				}
				
				// no need to move `currNode` as its `next` will propagate farther if duplicates found
			}
			// no duplicate
			else {
				currNode = currNode.next;
			}
		}
		
		return head;
	}
	
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
		RemoveDuplicatesDLL myObj = new RemoveDuplicatesDLL();
		
		// 1 <-> 2 <-> 2 <-> 2 <-> 3 <-> 3
		DLLNode n1 = new DLLNode(1);
		DLLNode n2 = new DLLNode(2);
		DLLNode n3 = new DLLNode(2);
		DLLNode n4 = new DLLNode(2);
		DLLNode n5 = new DLLNode(3);
		DLLNode n6 = new DLLNode(3);
		
		n1.next = n2;
		n2.prev = n1;
		n2.next = n3;
		n3.prev = n2;
		n3.next = n4;
		n4.prev = n3;
		n4.next = n5;
		n5.prev = n4;
		n5.next = n6;
		n6.prev = n5;
		
		
		System.out.print("Original DLL: ");
		myObj.printList(n1);
		
		DLLNode result = myObj.removeDuplicates(n1);
		
		System.out.print("After removing duplicates: ");
		myObj.printList(result);
	}
}