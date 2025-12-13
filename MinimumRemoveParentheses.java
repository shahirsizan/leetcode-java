// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class MinimumRemoveParentheses {

	public String minRemoveToMakeValid(String givenString) {
		HashSet<Integer> indicesToRemoveSet = new HashSet<>();
		ArrayDeque<Integer> ourDeque = new ArrayDeque<>();

		for (int i = 0; i < givenString.length(); i++) {
			char currentChar = givenString.charAt(i);

			if (currentChar == '(') {
				// push `index` of current opening parenthesis into stack.
				ourDeque.addLast(i);
			}
			else if (currentChar == ')') {
				// check for corresponding opening parenthesis
				if (ourDeque.isEmpty()) {
					// no corresponding opening parenthesis in stack. Push current index to `Set` for later removal.
					indicesToRemoveSet.add(i);
				}
				else {
					// corresponding opening parenthesis found in stack. Pop opening parenthesis and continue.
					ourDeque.removeLast();
				}
			}
			// ignore alphanumeric characters
		}

		// add any remaining unmatched opening parenthesis indexes to the removal set.
		while (!ourDeque.isEmpty()) {
			indicesToRemoveSet.add(ourDeque.removeLast().intValue());
		}

		// build result string
		StringBuilder resultString = new StringBuilder();
		for (int i = 0; i < givenString.length(); i++) {
			if (!indicesToRemoveSet.contains(i)) {
				resultString.append(givenString.charAt(i));
			}
		}

		return resultString.toString();
	}

	/*
	 🧩🧩🧩 Main 🧩🧩🧩
	 	Input: tokens = ["4","13","5","/","+"]
		Input: s = "lee(t(c)o)de)"
		Output: "lee(t(c)o)de"
		Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
	*/

	public static void main(String[] args) {
		MinimumRemoveParentheses solver = new MinimumRemoveParentheses();

		String s1 = "lee(t(c)o)de)";
		System.out.println("Input:  " + s1);
		System.out.println("Output: " + solver.minRemoveToMakeValid(s1)); // Expected: lee(t(c)o)de

		String s2 = "a)b(c)d";
		System.out.println("\nInput:  " + s2);
		System.out.println("Output: " + solver.minRemoveToMakeValid(s2)); // Expected: ab(c)d

		String s3 = "))((";
		System.out.println("\nInput:  " + s3);
		System.out.println("Output: " + solver.minRemoveToMakeValid(s3)); // Expected: ""

		String s4 = "((";
		System.out.println("\nInput:  " + s4);
		System.out.println("Output: " + solver.minRemoveToMakeValid(s4)); // Expected: ""
	}
}