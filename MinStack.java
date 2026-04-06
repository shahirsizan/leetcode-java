//https://leetcode.com/problems/min-stack/description/
// CPS academy DSA sheet (Stack, Design Problems)

import java.util.ArrayDeque;

public class MinStack {
	record Pair(int a, int b) {
	}
	
	;
	
	private ArrayDeque<Pair> minStack;
	
	public MinStack() {
		minStack = new ArrayDeque<>();
	}
	
	public void push(int currentVal) {
		if (minStack.isEmpty()) {
			minStack.push(new Pair(currentVal, currentVal));
		} else {
			minStack.push(new Pair(currentVal, Math.min(currentVal, minStack.peek().b())));
		}
	}
	
	public void pop() {
		if (minStack.isEmpty()) {
			return;
		}
		minStack.pop();
	}
	
	public int top() {
		if (minStack.isEmpty()) {
			throw new IllegalStateException("minStack empty!");
		}
		return minStack.peek().a();
	}
	
	public int getMin() {
		if (minStack.isEmpty()) {
			throw new IllegalStateException("minStack empty!");
		}
		return minStack.peek().b();
	}
	
	/*
	 🧩🧩🧩 Main 🧩🧩🧩
	 /**
	 * Your MinStack object will be instantiated and called as such:
	 * MinStack obj = new MinStack();
	 * obj.push(val);
	 * obj.pop();
	 * int param_3 = obj.top();
	 * int param_4 = obj.getMin();
	
		Input
				["MinStack","push","push","push","getMin","pop","top","getMin"]
				  [[],[-2],[0],[-3],[],[],[],[]]
		Output
				[null,null,null,null,-3,null,0,-2]
	*/
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		
		System.out.println("Pushing 0, 1, 0");
		minStack.push(0);
		minStack.push(1);
		minStack.push(0); // New minimum is 0, pushed again.
		
		System.out.println("Min: " + minStack.getMin()); // Expected: 0
		System.out.println("Top: " + minStack.top());    // Expected: 0
		
		minStack.pop(); // Pop 0 (The top of mainStack and minStack)
		
		System.out.println("\nAfter pop:");
		System.out.println("Min: " + minStack.getMin()); // Expected: 0 (The original 0 is still the minimum)
		System.out.println("Top: " + minStack.top());    // Expected: 1
		
		minStack.pop(); // Pop 1
		
		System.out.println("\nAfter second pop:");
		System.out.println("Min: " + minStack.getMin()); // Expected: 0
		System.out.println("Top: " + minStack.top());    // Expected: 0
	}
}