// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneLetterCombinations {
	private final Map<String, String> keypadMapping = new HashMap<>();
	
	// Common way to initialize a private map that belongs to a class. Keeps the logic separate from the class methods. [chatgpt]
	{
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
		backtrack(0, currentString, givenDigits, resultList);
		return resultList;
	}
	
	private void backtrack(int currentIndex, StringBuilder currentString, String givenDigits, List<String> resultList) {
		// base case: `currentString.length == givenDigits.length()`,
		// we found a valid string, append to `resultList`
		if (currentString.length() == givenDigits.length()) {
			resultList.add(currentString.toString());
			return;
		}
		
		// get the available options (letters) for current position
		String lettersOfCurrentButton = keypadMapping.get(givenDigits.charAt(currentIndex) + ""); // `Char -> String` typecasting
		
		for (char c : lettersOfCurrentButton.toCharArray()) {
			// add current option (letter)
			currentString.append(c);
			// recursive call to backtrack()
			backtrack(currentIndex + 1, currentString, givenDigits, resultList);
			// remove current option (letter), we'll go for next option
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