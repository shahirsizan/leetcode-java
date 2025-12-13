import java.util.Arrays;

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] stringList) {
		if (stringList == null || stringList.length == 0) {
			return "";
		}

		String longestPrefix = stringList[0];

		for (int i = 1; i < stringList.length; i++) {
			String currentWord = stringList[i];

			while (currentWord.indexOf(longestPrefix) != 0) {
				// as long as index of `longestPrefix` in `currentWord` is not 0,
				// we remove characters from the back of `longestPrefix` one-by-one
				if (longestPrefix.length() == 0) {
					return "";
				}
				else{
					longestPrefix = longestPrefix.substring(0, longestPrefix.length() - 1);
				}
			}
		}

		return longestPrefix;
	}

	// --- Main Method for Demonstration ---

	public static void main(String[] args) {
		LongestCommonPrefix solver = new LongestCommonPrefix();

		// Example 1:
		String[] strs1 = {"flower", "flow", "flight"};
		String result1 = solver.longestCommonPrefix(strs1); // Expected: "fl"
		System.out.println("--- Example 1 ---");
		System.out.println("Input: " + Arrays.toString(strs1));
		System.out.println("LCP: \"" + result1 + "\"");

		System.out.println("-----------------");

		// Example 2:
		String[] strs2 = {"dog", "racecar", "car"};
		String result2 = solver.longestCommonPrefix(strs2); // Expected: ""
		System.out.println("--- Example 2 ---");
		System.out.println("Input: " + Arrays.toString(strs2));
		System.out.println("LCP: \"" + result2 + "\"");
	}
}