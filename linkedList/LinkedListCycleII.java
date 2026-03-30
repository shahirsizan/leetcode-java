// https://leetcode.com/problems/linked-list-cycle-ii/description/
// CPS academy sheet (LL), Kunal Kushwaha (LL)

package linkedList;

public class LinkedListCycleII {
	static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	/**
	 * 🥎 Mathematically proved: The starting point of the cycle is equally distanced
	 * from both the `LL start point` and the `slow-fast meet point`.
	 * So, traverse from both the points and the next `meeting point` is the `cycle entry point`
	 * Just draw a diagram, nothing special.
	 */
	
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		
		ListNode slow = head;
		ListNode fast = head;
		
		// 1. Detect if cycle exists
		boolean hasCycle = false;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				hasCycle = true;
				break;
			}
		}
		
		// If no cycle, return null
		if (!hasCycle) {
			return null;
		}
		
		// 2. Find cycle start point
		// Explanation described above
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		// Both pointers now point to the start of the cycle
		return slow;
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		LinkedListCycleII myObj = new LinkedListCycleII();
		
		// 3 -> 2 -> 0 -> -4
		ListNode head = new ListNode(3);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(0);
		ListNode fourth = new ListNode(-4);
		head.next = second;
		second.next = third;
		third.next = fourth;
		// Create cycle: -4 points to 2
		fourth.next = second;
		
		ListNode cycleStart = myObj.detectCycle(head);
		
		if (cycleStart != null) {
			System.out.println("Cycle begins at node: " + cycleStart.val);
		} else {
			System.out.println("No cycle at all.");
		}
	}
}