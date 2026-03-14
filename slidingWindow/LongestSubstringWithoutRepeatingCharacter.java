// CPS academy DSA sheet (Sliding Window)
// https://leetcode.com/problems/longest-substring-without-repeating-characters/

package slidingWindow;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacter {
	
	public int lengthOfLongestSubstring(String s) {
		if (s.length() == 0) {
			return 0;
		}
		
		HashSet<Character> ourHashSet = new HashSet<>();
		int leftPointer = 0;
		int rightPointer = 0;
		int maxLength = 0;
		
		for (rightPointer = 0; rightPointer < s.length(); rightPointer++) {
			char rightPointerChar = s.charAt(rightPointer);
			// remove characters pointed by `leftPointer` as long as the `rightPointerChar` is still available in the hashset
			while (ourHashSet.contains(rightPointerChar)) {
				ourHashSet.remove(s.charAt(leftPointer));
				leftPointer++;
			}
			
			ourHashSet.add(rightPointerChar);
			maxLength = Math.max(maxLength, rightPointer - leftPointer + 1);
		}
		
		return maxLength;
	}
	
	// --- main() ---
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacter myObj = new LongestSubstringWithoutRepeatingCharacter();
		
		String s1 = "abcdabcbb";
		int result1 = myObj.lengthOfLongestSubstring(s1);
		System.out.println("Input: \"" + s1 + "\"");
		System.out.println("Longest Substring Length: " + result1 + " (Expected: 4)");
		
	}
}