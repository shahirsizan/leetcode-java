// CPS academy DSA sheet (String)
// https://leetcode.com/problems/minimum-window-substring/description/

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		// constraint edge case
		if (s.length() < t.length()) {
			return "";
		}
		
		// map character frequency of `t`
		Map<Character, Integer> mapT = new HashMap<>();
		for (char ch : t.toCharArray()) {
			mapT.put(ch, mapT.getOrDefault(ch, 0) + 1);
		}
		
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
		
		int leftPointer = 0;
		// expand the right pointer
		for (int rightPointer = 0; rightPointer < s.length(); rightPointer++) {
			char currentChar = s.charAt(rightPointer);
			mapCurrentWindow.put(currentChar, mapCurrentWindow.getOrDefault(currentChar, 0) + 1);
			
			// If `currentChar` in `currentWindow` matches frequency in string `t`...
			if (mapT.containsKey(currentChar) && mapCurrentWindow.get(currentChar).equals(mapT.get(currentChar))) {
				haveChars++;
			}
			
			// `mapCurrentWindow` is valid
			// compress the leftPointer pointer as long as it is valid
			while (haveChars == needChars) {
				// update result if this `mapCurrentWindow` is smaller than previous window
				int shortestWindowSizeUntilNow = rightPointer - leftPointer + 1;
				
				if (res[0] == -1 || shortestWindowSizeUntilNow < res[0]) {
					res[0] = shortestWindowSizeUntilNow;
					res[1] = leftPointer;
					res[2] = rightPointer;
				}
				
				// compress `leftPointer` to find smaller mapCurrentWindow
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