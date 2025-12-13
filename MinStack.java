//https://leetcode.com/problems/min-stack/description/

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
	private ArrayDeque<Integer> mainStack;
	private ArrayDeque<Integer> minStack;

	//	initialize two stacks: one to store `regular` values, another to store `minimum` values encountered so far
	public MinStack() {
		mainStack = new ArrayDeque<>();
		minStack = new ArrayDeque<>();
	}

	public void push(int currentVal) {
		mainStack.push(currentVal);
		// currentVal is less than or equal to the current minimum, push into minStack
		if (minStack.isEmpty() || minStack.peek() >= currentVal) {
			minStack.push(currentVal);
		}
	}

	public void pop() {
		if (mainStack.isEmpty()) {
			return;
		}
		/* Avoid using `==` to compare elements while dealing with java collections.
		* two `Integer` objects, even if hold the same `value`, may be from different `memory` addresses.
		* ✅ Solution: Use `.equals()`. This method is defined in the Object class (the parent of all Java classes) and is intended
		* to compare the actual value of two objects.*/
		if (mainStack.peek().equals(minStack.peek())) {
			minStack.pop();
		}
		mainStack.pop();
	}

	public int top() {
		if (mainStack.isEmpty()) {
			throw new IllegalStateException("mainStack empty!");
		}
		return mainStack.peek();
	}

	public int getMin() {
		if (minStack.isEmpty()) {
			throw new IllegalStateException("minStack empty!");
		}
		return minStack.peek();
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