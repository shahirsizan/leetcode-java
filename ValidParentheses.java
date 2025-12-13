import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {

	public boolean isValid(String givenString) {
		//	if string length less than 2 OR string has odd number of characters, return false
		if (givenString.length() < 2 || givenString.length() % 2 != 0) {
			return false;
		}

		ArrayDeque<Character> stack = new ArrayDeque<>();
		HashMap<Character, Character> mappings = new HashMap<>();
		mappings.put(')', '(');
		mappings.put('}', '{');
		mappings.put(']', '[');

		for (int i = 0; i < givenString.length(); i++) {
			char currentChar = givenString.charAt(i);

			if(currentChar == '(' || currentChar == '{' || currentChar == '['){
				stack.addLast(currentChar);
			}
			else {
				if (stack.isEmpty()) {
					return false;
				}
				char topChar = stack.pollLast();
				if (topChar != mappings.get(currentChar)) {
					return false;
				}
			}

		}

		// at this point, if stack is still not empty, means opening-closing pairs are inconsistent, return false.
		// if stack empty, return true.
		return stack.isEmpty();
	}

	// --- Main ---

	public static void main(String[] args) {
		ValidParentheses solver = new ValidParentheses();

		String s1 = "()[]{}";
		System.out.println("'" + s1 + "' is valid: " + solver.isValid(s1) + " (Expected: true)");

		String s2 = "([{}])";
		System.out.println("'" + s2 + "' is valid: " + solver.isValid(s2) + " (Expected: true)");

		String s3 = "(]";
		System.out.println("'" + s3 + "' is valid: " + solver.isValid(s3) + " (Expected: false)");

		String s4 = "(((";
		System.out.println("'" + s4 + "' is valid: " + solver.isValid(s4) + " (Expected: false)");

		String s5 = "}";
		System.out.println("'" + s5 + "' is valid: " + solver.isValid(s5) + " (Expected: false)");
	}
}