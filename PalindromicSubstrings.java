// nije nije korechi vaya :)

public class PalindromicSubstrings {
	private int palindromeCount = 0;

	public int countSubstrings(String givenString) {
		if(givenString.length() == 1){
			return 1;
		}

		for (int i = 0; i < givenString.length(); i++) {
			// For single center-character. `startIndex` and `maxLength` will be updated globally
			checkPalindrome(givenString, i, i);
			// For double center-character. `startIndex` and `maxLength` will be updated globally
			checkPalindrome(givenString, i, i + 1);
		}

		return palindromeCount;
	}

	private void checkPalindrome(String givenString, int leftPointer, int rightPointer) {

		while( ( leftPointer >= 0 && rightPointer < givenString.length() ) &&
				  givenString.charAt(leftPointer) == givenString.charAt(rightPointer)
		){
			palindromeCount++;

			leftPointer--;
			rightPointer++;
		}

	}

	// --- Main ---

	public static void main(String[] args) {
		PalindromicSubstrings solver = new PalindromicSubstrings();

		// Example 1:
		String s1 = "babad";
		int result1 = solver.countSubstrings(s1);
		System.out.println("--- Example 1 ---");
		System.out.println("Input: \"" + s1 + "\"");
		// Output could be "bab" or "aba"
		System.out.println("LPS: \"" + result1 + "\"");

		System.out.println("-----------------");

		// Example 2:
		String s2 = "cbbd";
		int result2 = solver.countSubstrings(s2);
		System.out.println("--- Example 2 ---");
		System.out.println("Input: \"" + s2 + "\"");
		System.out.println("LPS: \"" + result2 + "\"");
	}
}
