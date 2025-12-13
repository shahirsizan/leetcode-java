public class LongestPalindromicSubstring {

	private int globalPalindromeLength = 0;
	private int startIndex = 0;


	public String longestPalindrome(String givenString) {
		if (givenString.length() < 2) {
			return givenString;
		}

		for (int i = 0; i < givenString.length(); i++) {
			// For single center-character. `startIndex` and `maxLength` will be updated globally
			checkPalindrome(givenString, i, i);
			// For double center-character. `startIndex` and `maxLength` will be updated globally
			checkPalindrome(givenString, i, i + 1);
		}

		return givenString.substring(startIndex, startIndex + globalPalindromeLength);
	}

	private void checkPalindrome(String givenString, int leftPointer, int rightPointer) {

		while(leftPointer >= 0 && rightPointer < givenString.length()
				&& givenString.charAt(leftPointer) == givenString.charAt(rightPointer)
		){
			leftPointer--;
			rightPointer++;
		}

		int currentPalindromeLength = (rightPointer - 1) - (leftPointer + 1) + 1;
		//		time to set the global variables
		if (currentPalindromeLength > globalPalindromeLength) {
			globalPalindromeLength = currentPalindromeLength;
			startIndex = leftPointer + 1;
		}
	}

	// --- Main Method for Demonstration ---

	public static void main(String[] args) {
		LongestPalindromicSubstring solver = new LongestPalindromicSubstring();

		// Example 1:
		String s1 = "babad";
		String result1 = solver.longestPalindrome(s1);
		System.out.println("--- Example 1 ---");
		System.out.println("Input: \"" + s1 + "\"");
		// Output could be "bab" or "aba"
		System.out.println("LPS: \"" + result1 + "\"");

		System.out.println("-----------------");

		// Example 2:
		String s2 = "cbbd";
		String result2 = solver.longestPalindrome(s2);
		System.out.println("--- Example 2 ---");
		System.out.println("Input: \"" + s2 + "\"");
		System.out.println("LPS: \"" + result2 + "\"");
	}
}