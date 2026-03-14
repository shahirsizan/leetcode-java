// CPS academy DSA sheet (String, Sliding Window)
// https://leetcode.com/problems/minimum-window-substring/description/

package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		// edge case
		if (s.length() < t.length()) {
			return "";
		}
		
		// `string t` character frequency
		Map<Character, Integer> mapT = new HashMap<>();
		for (char ch : t.toCharArray()) {
			mapT.put(ch, mapT.getOrDefault(ch, 0) + 1);
		}
		// `current window` character frequency
		Map<Character, Integer> mapCurrentWindow = new HashMap<>();
		
		/**
		 * `haveChars` & `needChars`:
		 * Keep count (haveChars) of how many unique characters in the mapCurrentWindow matches the required
		 * frequency in string `t` (needChars).
		 * This will help us to get rid of re-scanning the maps constantly during leftPointer-right pointer compression section.
		 * */
		int haveChars = 0;
		int needChars = mapT.size();
		
		// res: [shortest substring length, leftIndex, rightIndex]
		int[] res = {-1, 0, 0};
		
		/**
		 * 1. Locate the very first substring in `large string` where all characters of `short string` are included.
		 * 2. Then shrink the `left pointer` as long as above property stays valid.
		 * 3. As soon as above property invalidates, again extend `right pointer`.
		 * 4. Keep track of the minimum substring `length` in a global count variable
		 * */
		int leftPointer = 0;
		for (int rightPointer = 0; rightPointer < s.length(); rightPointer++) {
			char currentChar = s.charAt(rightPointer);
			mapCurrentWindow.put(currentChar, mapCurrentWindow.getOrDefault(currentChar, 0) + 1);
			
			// If `currentChar` frequency in `currentWindow` matches corresponding frequency in `short string`,
			// increase `haveChars`
			if (mapT.containsKey(currentChar) && mapCurrentWindow.get(currentChar).equals(mapT.get(currentChar))) {
				haveChars++;
			}
			
			// We enter into below loop as soon as `current substring` contains all characters of the given `short string`
			while (haveChars == needChars) {
				// update result if `current window` is smaller than `previous window`
				int shortestWindowSizeUntilNow = rightPointer - leftPointer + 1;
				if (res[0] == -1 || shortestWindowSizeUntilNow < res[0]) {
					res[0] = shortestWindowSizeUntilNow;
					res[1] = leftPointer;
					res[2] = rightPointer;
				}
				
				// compress `leftPointer` to find a smaller `current window`
				char leftChar = s.charAt(leftPointer);
				mapCurrentWindow.put(leftChar, mapCurrentWindow.get(leftChar) - 1);
				leftPointer++;
				
				if (mapT.containsKey(leftChar) && mapCurrentWindow.get(leftChar) < mapT.get(leftChar)) {
					haveChars--;
				}
			}
		}
		
		String result = res[0] == -1 ? "" : s.substring(res[1], res[2] + 1);
		return result;
	}
	
	// ✅ main() method ✅
	public static void main(String[] args) {
		MinimumWindowSubstring myObj = new MinimumWindowSubstring();
		String s = "shahiradilsizanrail";
		String t = "rail";
		System.out.println("S: " + s + ", T: " + t);
		System.out.println("Result: " + myObj.minWindow(s, t) + " (Expected: rail (at the very end))");
	}
}