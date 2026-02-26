// CPS academy sheet (Arrays & Matrix)
// https://leetcode.com/problems/valid-anagram/description/

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
	
	public boolean isAnagram(String str1, String str2) {
		
		if (str1.length() != str2.length()) {
			return false;
		}
		
		// We traverse str1, make character frequency hashmap
		// We then traverse str2, deduct count for each encountered character
		// If all hashmap entry frequency is `0`, they are anagram
		
		Map<Character, Integer> ourHashMap = new HashMap<Character, Integer>();
		
		for (int i = 0; i < str1.length(); i++) {
			if (ourHashMap.containsKey(str1.charAt(i))) {
				ourHashMap.put(str1.charAt(i), ourHashMap.get(str1.charAt(i)) + 1);
			} else {
				ourHashMap.put(str1.charAt(i), 1);
			}
		}
		
		for (int i = 0; i < str2.length(); i++) {
			if (!ourHashMap.containsKey(str2.charAt(i))) {
				return false;
			} else {
				ourHashMap.put(str2.charAt(i), ourHashMap.get(str2.charAt(i)) - 1);
			}
			
			if (ourHashMap.get(str2.charAt(i)) == 0) {
				ourHashMap.remove(str2.charAt(i));
			}
		}
		
		return ourHashMap.isEmpty();
	}
	
	public static void main(String[] args) {
		ValidAnagram myObj = new ValidAnagram();
		
		String str1 = "anagram";
		String str2 = "nagaram";
		boolean result1 = myObj.isAnagram(str1, str2);
		System.out.println("Result: " + result1 + " (Expected: true)");
	}
}
