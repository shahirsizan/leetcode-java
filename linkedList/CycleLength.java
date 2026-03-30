// `Kunal Kushwaha` youtube LL playlist

package linkedList;

public class CycleLength {
	private Node head;
	
	private static class Node {
		int value;
		Node next;
		
		Node(int value) {
			this.value = value;
		}
	}
	
	/**
	 * 1. First detect cycle
	 * 2. Keeping `fast pointer` static, traverse `slow pointer` around the cycle to meet again with `fast pointer`
	 * 3. We find the length of the cycle
	 *
	 */
	
	public int lengthOfCycle(Node head) {
		Node fast = head;
		Node slow = head;
		
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			
			// Cycle detected
			if (fast == slow) {
				return calculateLength(slow);
			}
		}
		
		// No cycle found
		return 0;
	}
	
	private int calculateLength(Node slow) {
		Node temp = slow;
		int length = 0;
		
		do {
			temp = temp.next;
			length++;
		} while (temp != slow);
		
		return length;
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		CycleLength myObj = new CycleLength();
		
		Node first = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(5);
		// 1 -> 2 -> 3 -> 4 -> 5
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		// cycle: 5 points back to 2
		fifth.next = second;
		
		int cycleLen = myObj.lengthOfCycle(first);
		System.out.println("Length of the cycle: " + cycleLen + " (Expected: 4 (The cycle is 2 -> 3 -> 4 -> 5 -> back to 2))");
	}
}