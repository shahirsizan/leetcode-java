// https://leetcode.com/problems/longest-valid-parentheses/description/

import java.util.ArrayDeque;

public class LongestValidParentheses {

	public int longestValidParentheses(String givenString) {
		if(givenString.length() < 2){
			return 0;
		}

		int maxLength = 0;
		int localLength = 0;
		ArrayDeque<Integer> ourDeque = new ArrayDeque<>();

		int startPos = -1;
		for (int i = 0; i < givenString.length(); i++) {
			char currentChar = givenString.charAt(i);

			// if current char `(`
			// just push into stack
			if (currentChar == '(') {
				ourDeque.addLast(i);
			}
			// if current char `)`
			//    ->if stack empty, set `startPos` to current position and continue.
			// 	->if stack not empty
			// 		 -> pop from stack
			//					-> if stack becomes empty, calculate valid string length: `i - startPos`
			//					-> if stack does not become empty, calculate valid string length: `i - stack[top]`
			else {
				if (ourDeque.isEmpty()) {
					startPos = i;
				}
				else {
					ourDeque.removeLast();

					if (ourDeque.isEmpty()) {
						localLength = i - startPos;
						maxLength = Math.max(maxLength, localLength);
					}
					else{
						localLength = i - ourDeque.getLast();
						maxLength = Math.max(maxLength, localLength);
					}
				}
			}
		}
		return maxLength;
	}

	/*
	 🧩🧩🧩 Main 🧩🧩🧩
	 	Input: tokens = ["4","13","5","/","+"]
		Input: s = ")()())"
		Output: 4
		Explanation: The longest valid parentheses substring is "()()".
	*/

	public static void main(String[] args) {
		LongestValidParentheses solver = new LongestValidParentheses();

		String s1 = "(()";
		System.out.println("Input: " + s1 + ", Longest Valid Length: " + solver.longestValidParentheses(s1) + " (Expected: 2)");

		String s2 = ")()())";
		System.out.println("Input: " + s2 + ", Longest Valid Length: " + solver.longestValidParentheses(s2) + " (Expected: 4)");

		String s3 = "()(()";
		System.out.println("Input: " + s3 + ", Longest Valid Length: " + solver.longestValidParentheses(s3) + " (Expected: 2)");

		String s4 = "()(())";
		System.out.println("Input: " + s4 + ", Longest Valid Length: " + solver.longestValidParentheses(s4) + " (Expected: 6)");
	}
}