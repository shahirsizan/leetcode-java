// CPS academy DSA sheet (Stack)
// https://leetcode.com/problems/decode-string/description/

import java.util.Stack;

public class DecodeString {
	public String decodeString(String givenString) {
		Stack<Integer> stackCount = new Stack<>();
		Stack<StringBuilder> stackrRes = new Stack<>();
		StringBuilder currentString = new StringBuilder();
		int k = 0;
		
		for (char currChar : givenString.toCharArray()) {
			if (Character.isDigit(currChar)) {
				// Build the multiplier (handles multi-digit like 100[a])
				k = k * 10 + (currChar - '0');
			} else if (currChar == '[') {
				// 1. Push the multiplier
				stackCount.push(k);
				// 2. Push the string we've built so far to save its context
				stackrRes.push(currentString);
				// 3. Reset for the new scope inside the brackets
				currentString = new StringBuilder();
				k = 0;
			} else if (currChar == ']') {
				// 1. Get the repeat count
				int repeatTimes = stackCount.pop();
				// 2. Get the string context from before the '['
				StringBuilder decodedString = stackrRes.pop();
				// 3. Append the currentString k times to that context
				for (int i = 0; i < repeatTimes; i++) {
					decodedString.append(currentString);
				}
				// 4. The result is now our new current working string
				currentString = decodedString;
			} else {
				// It'givenString a normal character, just append
				currentString.append(currChar);
			}
		}
		
		return currentString.toString();
	}
	
	// ✅ main() method ✅
	public static void main(String[] args) {
		DecodeString myObj = new DecodeString();
		
		String test1 = "3[a]2[bc]";
		String test2 = "3[a2[c]]";
		
		System.out.println("Input: " + test1 + " -> Output: " + myObj.decodeString(test1) + " -> Expected: \"aaabcbc\" ");
		System.out.println("Input: " + test2 + " -> Output: " + myObj.decodeString(test2) + " -> Expected: \"accaccacc\" ");
	}
}