// https://leetcode.com/problems/valid-palindrome/description/
// CPS academy DSA sheet (Strings, Two Pointers)


public class ValidPalindrome {
	
	public boolean isPalindrome(String s) {
		if (s.length() == 1) {
			return true;
		}
		
		int leftPointer = 0;
		int rightPointer = s.length() - 1;
		
		while (leftPointer < rightPointer) {
			
			// increment/decrement pointers as long as they are spaces
			while (!Character.isLetterOrDigit(s.charAt(leftPointer)) && leftPointer < rightPointer) {
				leftPointer++;
			}
			while (!Character.isLetterOrDigit(s.charAt(rightPointer)) && rightPointer > leftPointer) {
				rightPointer--;
			}
			
			// compare the two alphanumeric characters
			if (Character.toLowerCase(s.charAt(leftPointer)) != Character.toLowerCase(s.charAt(rightPointer))) {
				return false;
			}
			
			// characters same. Go on.
			leftPointer++;
			rightPointer--;
		}
		
		// loop completes without returning `false`, it's a valid palindrome
		return true;
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		ValidPalindrome myObj = new ValidPalindrome();
		
		String s1 = "A man, a plan, a canal: Panama";
		boolean result1 = myObj.isPalindrome(s1);
		System.out.println("Input: \"" + s1 + "\"");
		System.out.println("Result: " + result1 + " (Expected: true)");
		
		System.out.println("-----------------");
		
		String s2 = "race a car";
		boolean result2 = myObj.isPalindrome(s2);
		System.out.println("Input: \"" + s2 + "\"");
		System.out.println("Result: " + result2 + " (Expected: false)");
	}
}