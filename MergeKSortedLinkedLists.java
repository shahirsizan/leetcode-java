import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Arrays;

public class MergeKSortedLinkedLists {

	//	✨✨✨
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	// ✨✨✨
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) {
			return null;
		}

		// create a `min-Heap` which will contain `ListNode` types.
		// their priority will be determined by comparing their respective `val` fields.
		PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
				  new Comparator<ListNode>(){
					  @Override
					  public int compare(ListNode o1, ListNode o2) {
						  return o1.val - o2.val;
					  }
				  }
		);

		// insert left-most node (current head) of every non-empty list into the min-heap
		for (ListNode listHead : lists) {
			if (listHead != null) {
				minHeap.add(listHead);
			}
		}

		ListNode dummyHead = new ListNode(0);
		ListNode currentNode = dummyHead;
		while (!minHeap.isEmpty()) {
			// get the smallest node
			ListNode minNode = minHeap.poll();
			// append minNode to the result list
			currentNode.next = minNode;
			currentNode = currentNode.next;

			// add the `next node` of the currently processed node into heap (if any)
			if (minNode.next != null) {
				minHeap.add(minNode.next);
			}
		}

		//	return new head
		return dummyHead.next;
	}

	// ✨✨✨ Main ✨✨✨

	public static void main(String[] args) {
		MergeKSortedLinkedLists solver = new MergeKSortedLinkedLists();

		// List 1: 1 -> 4 -> 5
		ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
		// List 2: 1 -> 3 -> 4
		ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
		// List 3: 2 -> 6
		ListNode l3 = new ListNode(2, new ListNode(6));

		ListNode[] lists = new ListNode[]{l1, l2, l3};

		System.out.println("Merging 3 lists.");
		ListNode mergedHead = solver.mergeKLists(lists);
		System.out.print("Merged List: ");
		printList(mergedHead); // Expected: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6
	}

	// ✨✨✨ Helper function to print list ✨✨✨
	private static void printList(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.val + (current.next != null ? " -> " : ""));
			current = current.next;
		}
		System.out.println();
	}
}