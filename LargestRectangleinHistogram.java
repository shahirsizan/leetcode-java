// https://leetcode.com/problems/largest-rectangle-in-histogram/description/

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LargestRectangleinHistogram {

	public int largestRectangleArea(int[] heightsArray) {
		int n = heightsArray.length;

		if (n == 0) {
			return 0;
		}

		int[] prefixSmaller = new int[n];
		int[] postfixSmaller = new int[n];

		Deque<Integer> stack = new ArrayDeque<>();

		// calculate prefix smaller left-to-right
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && heightsArray[stack.peek()] >= heightsArray[i]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				prefixSmaller[i] = -1;
			} else {
				prefixSmaller[i] = stack.peek();
			}

			stack.push(i);
		}

		// calculate postfix smaller right-to-left
		//	clear the stack used previously for prefix smaller
		stack.clear();
		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && heightsArray[stack.peek()] >= heightsArray[i]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				postfixSmaller[i] = n;
			} else {
				postfixSmaller[i] = stack.peek();
			}

			stack.push(i);
		}

		int maxArea = 0;
		for (int i = 0; i < n; i++) {
			int widthForCurrentElement = postfixSmaller[i] - prefixSmaller[i] - 1;
			int heightForCurrentElement = heightsArray[i];
			int currentArea = widthForCurrentElement * heightForCurrentElement;
			maxArea = Math.max(maxArea, currentArea);
		}

		return maxArea;
	}

	// --- Main ---

	public static void main(String[] args) {
		LargestRectangleinHistogram solver = new LargestRectangleinHistogram();

		int[] heights1 = {2, 1, 5, 6, 2, 3};
		System.out.println("Heights: " + Arrays.toString(heights1));

		System.out.println("Largest Area (Two-Pass): " + solver.largestRectangleArea(heights1) + " (Expected: 10)");

		
	}
}