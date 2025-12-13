import java.util.HashSet;
import java.lang.Math;

public class LongestSubstring {

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
//			remove characters pointed by `leftPointer` as long as the `rightPointerChar` is still available in the hashset
			while (ourHashSet.contains(rightPointerChar)) {
				ourHashSet.remove(s.charAt(leftPointer));
				leftPointer++;
			}

			ourHashSet.add(rightPointerChar);
			maxLength = Math.max(maxLength, rightPointer - leftPointer + 1);
		}

		return maxLength;
	}

	// --- Main Method for Demonstration ---

	public static void main(String[] args) {
		LongestSubstring solver = new LongestSubstring();

		// Example 1: Longest is "abc" or "bca" or "cab" (length 3)
		String s1 = "abcabcbb";
		int result1 = solver.lengthOfLongestSubstring(s1);
		System.out.println("--- Example 1 ---");
		System.out.println("Input: \"" + s1 + "\"");
		System.out.println("Longest Substring Length: " + result1 + " (Expected: 3)");

		System.out.println("-----------------");

		// Example 2: Longest is "wke" (length 3)
		String s2 = "pwwkew";
		int result2 = solver.lengthOfLongestSubstring(s2);
		System.out.println("--- Example 2 ---");
		System.out.println("Input: \"" + s2 + "\"");
		System.out.println("Longest Substring Length: " + result2 + " (Expected: 3)");

		System.out.println("-----------------");

		// Example 3: Longest is "a" (length 1)
		String s3 = "bbbbb";
		int result3 = solver.lengthOfLongestSubstring(s3);
		System.out.println("--- Example 3 ---");
		System.out.println("Input: \"" + s3 + "\"");
		System.out.println("Longest Substring Length: " + result3 + " (Expected: 1)");
	}
}