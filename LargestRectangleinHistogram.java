// https://leetcode.com/problems/largest-rectangle-in-histogram/description/

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LargestRectangleinHistogram {
	
	public int largestRectangleArea(int[] heightsArray) {
		int givenArrayLength = heightsArray.length;
		int[] prefixSmaller = new int[givenArrayLength];
		int[] postfixSmaller = new int[givenArrayLength];
		
		Deque<Integer> stack = new ArrayDeque<>();
		
		// calculate previous-smaller-element for each of the elements: left-to-right
		for (int i = 0; i < givenArrayLength; i++) {
			// while stack not empty AND stack top element is larger, they are of no use, pop them
			while (!stack.isEmpty() && heightsArray[stack.peek()] >= heightsArray[i]) {
				stack.pop();
			}
			
			// if stack empty, then the left-most index is assigned to `prefixSmaller[i]`
			if (stack.isEmpty()) {
				prefixSmaller[i] = -1;
			}
			// if stack top element smaller, then assign its index to `prefixSmaller[i]`
			else {
				prefixSmaller[i] = stack.peek();
			}
			
			// push current index into stack
			stack.push(i);
		}
		
		//	clear the stack used previously for prefix smaller
		stack.clear();
		
		// calculate next-smaller-element for each of the elements: right-to-left
		for (int i = givenArrayLength - 1; i >= 0; i--) {
			// while stack not empty AND stack top element is larger, they are of no use, pop them
			while (!stack.isEmpty() && heightsArray[stack.peek()] >= heightsArray[i]) {
				stack.pop();
			}
			
			// if stack empty, then the right-most index is assigned to `postfixSmaller[i]`
			if (stack.isEmpty()) {
				postfixSmaller[i] = givenArrayLength;
			}
			// if stack top element smaller, then assign its index to `postfixSmaller[i]`
			else {
				postfixSmaller[i] = stack.peek();
			}
			
			// push current index into stack
			stack.push(i);
		}
		
		int maxArea = 0;
		for (int i = 0; i < givenArrayLength; i++) {
			// rectangle width
			int widthForCurrentElement = postfixSmaller[i] - prefixSmaller[i] - 1;
			// rectangle height
			int heightForCurrentElement = heightsArray[i];
			int currentArea = widthForCurrentElement * heightForCurrentElement;
			maxArea = Math.max(maxArea, currentArea);
		}
		
		return maxArea;
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		LargestRectangleinHistogram solver = new LargestRectangleinHistogram();
		int[] heights1 = {2, 1, 5, 6, 2, 3};
		System.out.println("Given Heights: " + Arrays.toString(heights1));
		System.out.println("Largest rectangle area: " + solver.largestRectangleArea(heights1) + " (Expected: 10)");
		
		
	}
}