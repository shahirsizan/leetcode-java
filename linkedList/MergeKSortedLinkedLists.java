// CPS academy DSA sheet (Linked Lists, Heaps & Priority Queues)
// https://leetcode.com/problems/merge-k-sorted-lists/description/

package linkedList;

import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {
	
	public static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int val) {
			this.val = val;
		}
	}
	
	
	public ListNode mergeKLists(ListNode[] givenHeadsList) {
		// if `givenHeadsList` empty, return null
		if (givenHeadsList.length == 0) {
			return null;
		}
		
		// if each of the head nodes in `givenHeadsList` is null, return null
		boolean flag = false;
		for (int i = 0; i < givenHeadsList.length; i++) {
			if (givenHeadsList[i] != null) {
				flag = true;
			}
		}
		if (!flag) {
			return null;
		}
		
		PriorityQueue<ListNode> minHeap = new PriorityQueue<>((ListNode a, ListNode b) -> {
			return a.val - b.val;
		});
		
		// insert first node of all non-empty lists into `min-heap`
		for (ListNode currListHead : givenHeadsList) {
			if (currListHead != null) {
				minHeap.offer(currListHead);
			}
		}
		
		// time to insert remaining nodes
		ListNode mergedListDummyHead = new ListNode(0);
		ListNode currentNode = mergedListDummyHead;
		while (!minHeap.isEmpty()) {
			// get the smallest node
			ListNode minNode = minHeap.poll();
			// append minNode to the result list
			currentNode.next = minNode;
			currentNode = currentNode.next;
			
			// add next node of already processed node into heap
			if (minNode.next != null) {
				minHeap.add(minNode.next);
			}
		}
		
		//	return new head
		return mergedListDummyHead.next;
	}
	
	// ✅ printList() ✅
	private static void printList(ListNode head) {
		ListNode currNode = head;
		while (currNode != null) {
			System.out.print(currNode.val + (currNode.next != null ? " -> " : ""));
			currNode = currNode.next;
		}
		System.out.println();
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		MergeKSortedLinkedLists myObj = new MergeKSortedLinkedLists();
		
		// 1 -> 4 -> 5
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(5);
		// 1 -> 3 -> 4
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		// 2 -> 6
		ListNode l3 = new ListNode(2);
		l3.next = new ListNode(6);
		
		ListNode[] headsList = new ListNode[]{l1, l2, l3};
		ListNode mergedHead = myObj.mergeKLists(headsList);
		System.out.println("After merge (expected: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6) : ");
		printList(mergedHead);
	}
}