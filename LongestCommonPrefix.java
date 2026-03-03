// CPS academy DSA sheet (String)
// https://leetcode.com/problems/longest-common-prefix/description/

import java.util.Arrays;

/**
 * Time Complexity: O(S), where S is the sum of all characters in all strings. We visit each character at most once.
 * Space Complexity: O(L), where L is the length of the first string (to store the StringBuilder).
 *
 */

public class LongestCommonPrefix {
	
	public String longestCommonPrefix(String[] givenStrings) {
		
		// start with first string as prefixSB
		StringBuilder prefixSB = new StringBuilder(givenStrings[0]);
		
		// compare current prefixSB to every other string
		for (int i = 1; i < givenStrings.length; i++) {
			// constraint edge case. If any of the string length is 0, final answer is ""
			if (givenStrings[0].length() == 0) {
				return "";
			}
			
			String currentStr = givenStrings[i];
			
			// find the common portion
			int j = 0;
			while (j < prefixSB.length()
					&& j < currentStr.length()
					&& prefixSB.charAt(j) == currentStr.charAt(j)) {
				j++;
			}
			
			// trim `prefixSB` to the length of the matching part
			// setLength() is O(1) (google)
			prefixSB.setLength(j);
			
			// if at any point `prefixSB` becomes empty, return ""
			if (prefixSB.length() == 0) {
				return "";
			}
		}
		
		return prefixSB.toString();
	}
	
	// --- Main Method for Demonstration ---
	
	public static void main(String[] args) {
		LongestCommonPrefix myObj = new LongestCommonPrefix();
		
		String[] strs1 = {"flower", "flow", "flight"};
		String result1 = myObj.longestCommonPrefix(strs1);
		System.out.println("Input: " + Arrays.toString(strs1));
		System.out.println("Output: \"" + result1 + "\"" + " Expected: \"fl\"");
		
		
		String[] strs2 = {"dog", "racecar", "car"};
		String result2 = myObj.longestCommonPrefix(strs2);
		System.out.println("Input: " + Arrays.toString(strs2));
		System.out.println("Output: \"" + result2 + "\"" + " Expected: \"\"");
	}
}