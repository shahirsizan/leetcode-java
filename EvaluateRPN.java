import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateRPN {

	public int evalRPN(String[] tokenArray) {
		ArrayDeque<Integer> ourDeque = new ArrayDeque<>();

		for (String currentChar : tokenArray) {
			// current character is an operator, pop integers from stack to perform operation
			if (currentChar.equals("+") || currentChar.equals("-") || currentChar.equals("*") || currentChar.equals("/")) {
				// first popped element is second operand
				int operand2 = ourDeque.getLast().intValue();
				ourDeque.removeLast();
				// second popped element is first operand
				int operand1 = ourDeque.getLast().intValue();
				ourDeque.removeLast();

				int result = 0;
				// perform operation
				switch (currentChar) {
					case "+":
						result = operand1 + operand2;
						break;
					case "-":
						result = operand1 - operand2;
						break;
					case "*":
						result = operand1 * operand2;
						break;
					case "/":
						// as per constraint: The division between two integers always truncates toward zero
						result = operand1 / operand2;
						break;
				}

				// push `result` into stack
				ourDeque.addLast(result);
			}
			// current character is an operand, push to stack
			else {
				ourDeque.addLast(Integer.parseInt(currentChar));
			}
		}

		// the only remaining element in the stack is the final result
		return ourDeque.getLast();
	}

	/*
	 🧩🧩🧩 Main 🧩🧩🧩
	 	Input: tokens = ["4","13","5","/","+"]
		Output: 6
		Explanation: (4 + (13 / 5)) = 6
	*/

	public static void main(String[] args) {
		EvaluateRPN solver = new EvaluateRPN();

		// Example 1: (2 + 1) * 3 = 9
		String[] tokens1 = {"2", "1", "+", "3", "*"};
		System.out.println("Result 1: " + solver.evalRPN(tokens1) + " (Expected: 9)");

		// Example 2: 4 * (13 / 5) + 6 = 4 * 2 + 6 = 14
		String[] tokens2 = {"4", "13", "5", "/", "+", "6", "+"};
		System.out.println("Result 2: " + solver.evalRPN(tokens2) + " (Expected: 12)");

		// Example 3: 10 * 6 / (9 - 3) + 11 / 17 + 5 * 2 = 10 + 0 + 10 = 20
		String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
		System.out.println("Result 3: " + solver.evalRPN(tokens3) + " (Expected: 22)"); // Note: Example 3 logic is complex, expected is 22.

		// Detailed Trace of Example 3:
		// 1. [10, 6, 9, 3, +, -11, *, /, *, 17, +, 5, +]
		// [10, 6, 9, 3, +] -> [10, 6, 12, -11, *, /, *, 17, +, 5, +]
		// [10, 6, 12, -11, *] -> [10, 6, -132, /, *, 17, +, 5, +]
		// [10, 6, -132, /] -> [10, -22, *, 17, +, 5, +]  <- 6 / -132 = 0 in integer math. Let's fix the trace based on the actual problem:
		// [10, 6, 9, 3, +, -11, *, /, *, 17, +, 5, +]
		// 10 6 9 3 - * / 17 + 5 * 2 +  (The input must be wrong for the expected 22)

		// Using a standard calculator for the given input: {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}
		// This is not a standard expression. Let's trace simpler example:

		String[] tokens4 = {"3", "4", "5", "*", "-"}; // 3 - (4 * 5) = -17
		System.out.println("Result 4: " + solver.evalRPN(tokens4) + " (Expected: -17)");
	}
}