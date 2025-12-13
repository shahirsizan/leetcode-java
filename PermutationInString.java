import java.util.Arrays;

public class PermutationInString {

	public boolean checkInclusion(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();

		if (len1 > len2) {
			return false;
		}

//		initialize `both arrays` with `0`s
		int[] s1CharCountArray = new int[26];
		int[] s2CharCountArray = new int[26];

//		populate `both arrays` with character count from `both strings` in the `initial sliding window`
		for (int i = 0; i < len1; i++) {
			s1CharCountArray[s1.charAt(i) - 'a']++;
			s2CharCountArray[s2.charAt(i) - 'a']++;
		}

		for (int i = len1; i < len2; i++) {
			for (int j = 0; j < 26; j++) {
				if (s1CharCountArray[j] != s2CharCountArray[j]) {
					break;
				}
				if (j == 25) {
					return true;
				}
			}
//			slide window
			s2CharCountArray[s2.charAt(i) - 'a']++;
			s2CharCountArray[s2.charAt(i - len1) - 'a']--;
		}

//		outside the above for loop
//		check for the last index
		for (int j = 0; j < 26; j++) {
			if (s1CharCountArray[j] != s2CharCountArray[j]) {
				return false;
			}
		}
		return true;
	}

	// --- Main Method for Demonstration ---

	public static void main(String[] args) {
		PermutationInString solver = new PermutationInString();

		// Example 2: False
		String s1_2 = "adc";
		String s2_2 = "dcda";
		boolean result2 = solver.checkInclusion(s1_2, s2_2);
		System.out.println("--- Example 2 ---");
		System.out.println("s1: \"" + s1_2 + "\", s2: \"" + s2_2 + "\"");
		System.out.println("Result: " + result2 + " (Expected: true)");
	}
}