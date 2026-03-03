// CPS academy DSA sheet (String)
// https://leetcode.com/problems/reverse-words-in-a-string/description/

public class reverseWordsInString {
	
	public String reverseWords(String givenString) {
		
		// trim and convert to StringBuilder
		// "     the sky     is blue     " -> "the sky is blue"
		StringBuilder givenStringSB = cleanSpaces(givenString);
		
		// reverse entire `givenStringSB`
		// "the sky is blue" -> "eulb si yks eht"
		reverse(givenStringSB, 0, givenStringSB.length() - 1);
		
		// reverse each word in the reversed `givenStringSB`
		int left = 0;
		for (int right = 0; right < givenStringSB.length(); right++) {
			// find end of a word (either next char is a space OR end of the string)
			/**
			 * // ⚠️careful about the serial of the condition checks below.
			 * 		first check if `right` is withing bound or not, then check the character.
			 * 		Else will get `Index xyz out of bounds for length xyz` error
			 * */
			if (right + 1 == givenStringSB.length() || givenStringSB.charAt(right + 1) == ' ') {
				reverse(givenStringSB, left, right);
				
				// left = right = beginning of next word
				left = right + 2;
				right++;
			}
		}
		
		return givenStringSB.toString();
	}
	
	// Helper to reverse a portion of StringBuilder in-place
	private void reverse(StringBuilder givenStringSB, int left, int right) {
		while (left < right) {
			char temp = givenStringSB.charAt(left);
			givenStringSB.setCharAt(left, givenStringSB.charAt(right));
			givenStringSB.setCharAt(right, temp);
			left++;
			right--;
		}
	}
	
	private StringBuilder cleanSpaces(String givenString) {
		
		StringBuilder sb = new StringBuilder();
		int left = 0;
		int right = givenString.length() - 1;
		
		// 1. trim leading and trailing spaces with `left-right` pointers
		while (left <= right && givenString.charAt(left) == ' ') {
			left++;
		}
		while (left <= right && givenString.charAt(right) == ' ') {
			right--;
		}
		
		// 2. trim internal extra spaces with `left` pointer
		while (left <= right) {
			char ch = givenString.charAt(left);
			
			// not space. append
			if (ch != ' ') {
				sb.append(ch);
			}
			// space. check if more than one. (check whether `sb` already has a trailing space)
			else if (sb.charAt(sb.length() - 1) != ' ') {
				// Only add a space if the previous char wasn't a space
				sb.append(ch);
			}
			
			left++;
		}
		return sb;
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		reverseWordsInString myObj = new reverseWordsInString();
		String input = "     the sky     is blue     ";
		
		System.out.println("Input: '" + input + "'");
		String result = myObj.reverseWords(input);
		System.out.println("Output: '" + result + "' (Expected: \"blue is sky the\")");
	}
}