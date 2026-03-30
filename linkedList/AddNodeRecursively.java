// https://www.youtube.com/watch?v=70tx7KcMROc
// `Kunal Kushwaha` youtube LL playlist

package linkedList;

public class AddNodeRecursively {
	private Node head;
	private int size;
	
	private class Node {
		private int value;
		private Node next;
		
		public Node(int value) {
			this.value = value;
		}
		
		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}
	}
	
	public AddNodeRecursively() {
		this.size = 0;
	}
	
	public void insertRec(int val, int index) {
		if (index < 0 || index > size) {
			System.out.println("Index out of bounds");
			return;
		}
		head = insertRec(val, index, head);
	}
	
	private Node insertRec(int val, int stepsToGo, Node currNode) {
		// Base case: We've reached the insertion point
		if (stepsToGo == 0) {
			Node temp = new Node(val, currNode);
			this.size++;
			return temp;
		}
		
		// Recursive step: Link the current currNode's next to the result of the next call
		currNode.next = insertRec(val, stepsToGo - 1, currNode.next);
		return currNode;
	}
	
	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value + " -> ");
			temp = temp.next;
		}
		System.out.println("END");
		System.out.println("Expected: 40 -> 10 -> 30 -> 20 -> END");
		
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		AddNodeRecursively myList = new AddNodeRecursively();
		
		System.out.println("Inserting 10 at index 0:");
		myList.insertRec(10, 0);
		
		System.out.println("Inserting 20 at index 1:");
		myList.insertRec(20, 1);
		
		System.out.println("Inserting 30 at index 1:");
		myList.insertRec(30, 1);
		
		System.out.println("Inserting 40 at index 0:");
		myList.insertRec(40, 0);
		
		System.out.print("Final List: ");
		myList.display();
	}
}