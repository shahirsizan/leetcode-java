// CPS academy DSA sheet (Recursion and Backtracking)
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneLetterCombinations {
	
	/**
	 * TC: O(4^n * n)
	 * SC: O(n)
	 * https://share.google/aimode/TRpXFNpcCxsn5Vpho
	 */
	
	private final Map<String, String> keypadMapping = new HashMap<>();
	
	public PhoneLetterCombinations() {
		keypadMapping.put("0", "");
		keypadMapping.put("1", "");
		keypadMapping.put("2", "abc");
		keypadMapping.put("3", "def");
		keypadMapping.put("4", "ghi");
		keypadMapping.put("5", "jkl");
		keypadMapping.put("6", "mno");
		keypadMapping.put("7", "pqrs");
		keypadMapping.put("8", "tuv");
		keypadMapping.put("9", "wxyz");
	}
	
	public List<String> letterCombinations(String givenDigits) {
		List<String> resultList = new ArrayList<>();
		
		StringBuilder currentString = new StringBuilder();
		backtrack(givenDigits, 0, currentString, resultList);
		
		return resultList;
	}
	
	private void backtrack(String givenDigits, int currentStartIndex, StringBuilder currentString, List<String> resultList) {
		// Base case: valid string found, append to result
		if (currentString.length() == givenDigits.length()) {
			resultList.add(currentString.toString());
			return;
		}
		
		// get the available options (characters) of current position
		String lettersOfCurrentButton = keypadMapping.get(givenDigits.charAt(currentStartIndex) + ""); // `Char -> String` typecasting
		char[] charsOfCurrentButton = lettersOfCurrentButton.toCharArray();
		
		for (char ch : charsOfCurrentButton) {
			// Add current option
			currentString.append(ch);
			// Explore current option
			backtrack(givenDigits, currentStartIndex + 1, currentString, resultList);
			// Backtrack and remove current option. We'll go for next option
			currentString.deleteCharAt(currentString.length() - 1);
		}
	}
	
	// ✅ main ✅
	public static void main(String[] args) {
		PhoneLetterCombinations myObj = new PhoneLetterCombinations();
		
		String digits1 = "23";
		System.out.println("Input: '23'");
		System.out.println("Output: " + myObj.letterCombinations(digits1));
		
		String digits2 = "";
		System.out.println("\nInput: ''");
		System.out.println("Output: " + myObj.letterCombinations(digits2));
		
		String digits3 = "7";
		System.out.println("\nInput: '7'");
		System.out.println("Output: " + myObj.letterCombinations(digits3));
	}
}