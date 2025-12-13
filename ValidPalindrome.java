import java.lang.Character;

public class ValidPalindrome {

	public boolean isPalindrome(String s) {
		if (s.length() == 0) {
			// an empty string is a palindrome
			return true;
		}

		int leftPointer = 0;
		int rightPointer = s.length() - 1;

		while (leftPointer < rightPointer) {
			char leftChar = s.charAt(leftPointer);
			char rightChar = s.charAt(rightPointer);

			if (!Character.isLetterOrDigit(leftChar)) {
				leftPointer++;
				continue;
			}
			if (!Character.isLetterOrDigit(rightChar)) {
				rightPointer--;
				continue;
			}

			// compare the alphanumeric characters pointed by `leftPointer` and `rightPointer`
			if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
				return false;
			}

			// characters same. Go on.
			leftPointer++;
			rightPointer--;
		}

		// loop completes without returning `false`, it's a valid palindrome
		return true;
	}

	// --- Main Method for Demonstration ---

	public static void main(String[] args) {
		ValidPalindrome solver = new ValidPalindrome();

		// Example 1: True
		String s1 = "A man, a plan, a canal: Panama";
		boolean result1 = solver.isPalindrome(s1);
		System.out.println("--- Example 1 ---");
		System.out.println("Input: \"" + s1 + "\"");
		System.out.println("Result: " + result1 + " (Expected: true)");

		System.out.println("-----------------");

		// Example 2: False
		String s2 = "race a car";
		boolean result2 = solver.isPalindrome(s2);
		System.out.println("--- Example 2 ---");
		System.out.println("Input: \"" + s2 + "\"");
		System.out.println("Result: " + result2 + " (Expected: false)");
	}
}