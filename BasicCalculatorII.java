// CPS academy DSA sheet (stack. list chilo na, tobuo korechi)
// https://leetcode.com/problems/basic-calculator-ii/description/
// This code contains all `+`, `-`, `*` and `/` operations

import java.util.Stack;


public class BasicCalculatorII {
	
	public int calculate(String givenStringg) {
		String givenString = trimAll(givenStringg);
		System.out.println(givenString);
		Stack<Integer> stackOperands = new Stack<>();
		Stack<Character> stackOperators = new Stack<>();
		
		for (int i = 0; i < givenString.length(); i++) {
			char currentChar = givenString.charAt(i);
			
			// 🥎 if digit/number
			if (Character.isDigit(currentChar)) {
				/**
				 * parse multi-digit number
				 * "425":
				 *     Initial: val = 0
				 *     Step 1 (char '4'): 0×10+4=4
				 *     Step 2 (char '2'): 4×10+2=42
				 *     Step 3 (char '5'): 42×10+5=425
				 * */
				int val = 0;
				while (i < givenString.length() && Character.isDigit(givenString.charAt(i))) {
					// convert `string` number into `integer` number
					val = val * 10 + (givenString.charAt(i) - '0');
					i++;
				}
				
				stackOperands.push(val);
				// adjust the last increment
				i--;
			}
			
			// 🥎 if `(`
			else if (currentChar == '(') {
				stackOperators.push(currentChar);
			}
			
			
			// 🥎 if +, -, *, /
			else if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/') {
				// ✨ fix for unary operators✨
				// If unary '-' or '+' is at the start of string
				// or after a '(', push a `0` into `stackOperands`
				if (i == 0 || (i > 0 && givenString.charAt(i - 1) == '(')) {
					stackOperands.push(0);
				}
				
				
				// Before pushing new operator (currentChar),
				// Check while current top operator (stackOperator) has `equal` or `higher` precedence,
				// If so, apply it first
				while (!stackOperators.isEmpty() && precedenceLevel(stackOperators.peek()) >= precedenceLevel(currentChar)) {
					int calculation = applyOperation(stackOperators.pop(), stackOperands.pop(), stackOperands.pop());
					stackOperands.push(calculation);
				}
				
				stackOperators.push(currentChar);
			}
			
			// 🥎 if `)`
			else if (currentChar == ')') {
				while (stackOperators.peek() != '(') {
					int calculation = applyOperation(stackOperators.pop(), stackOperands.pop(), stackOperands.pop());
					stackOperands.push(calculation);
				}
				
				// Remove '('
				stackOperators.pop();
			}
		}
		
		// traverse complete, now process the remaining elements of the stacks
		while (!stackOperators.isEmpty()) {
			int calculation = applyOperation(stackOperators.pop(), stackOperands.pop(), stackOperands.pop());
			stackOperands.push(calculation);
		}
		
		return stackOperands.pop();
	}
	
	
	private int precedenceLevel(char op) {
		if (op == '+' || op == '-') {
			return 1;
		}
		if (op == '*' || op == '/') {
			return 2;
		}
		// for '('
		return 0;
	}
	
	private int applyOperation(char operator, int b, int a) {
		switch (operator) {
			case '+':
				return a + b;
			case '-':
				return a - b;
			case '*':
				return a * b;
			case '/':
				return a / b;
		}
		return 0;
	}
	
	public String trimAll(String givenString) {
		if (givenString == null) {
			return null;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < givenString.length(); i++) {
			char currChar = givenString.charAt(i);
			// Character.isWhitespace(currChar) handles spaces, tabs, and newlines
			if (!Character.isWhitespace(currChar)) {
				sb.append(currChar);
			}
		}
		
		return sb.toString();
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		BasicCalculatorII myObj = new BasicCalculatorII();
		System.out.println("Result: " + myObj.calculate("1-(     -2)") + " (Expected: 3)");
		System.out.println("Result: " + myObj.calculate("1 + 1") + " (Expected: 2)");
		System.out.println("Result: " + myObj.calculate("10 + 2 * (6 - 4)") + " (Expected: 14)");
		System.out.println("Result: " + myObj.calculate("(1+(4+5+2)-3)+(6+8)") + " (Expected: 23)");
	}
}