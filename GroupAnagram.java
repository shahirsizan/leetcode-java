// CPS academy DSA sheet (Arrays)
// https://leetcode.com/problems/group-anagrams/description/

import java.util.*;

public class GroupAnagram {
	
	public List<List<String>> groupAnagrams(String[] givenStrings) {
		Map<String, List<String>> ourMap = new HashMap<>();
		
		// ["eat","tea","tan","ate","nat","bat"]
		
		for (String str : givenStrings) {
			// convert `str` to character array
			char[] charArray = str.toCharArray();
			// sort the character array
			Arrays.sort(charArray);
			// convert the character array back to string
			String sortedStr = String.valueOf(charArray);
			
			// if key (sortedStr) exists, update
			if (ourMap.containsKey(sortedStr)) {
				ourMap.get(sortedStr).add(str);
			}
			// if not, create key-value pair and then update
			else {
				ourMap.put(sortedStr, new ArrayList<>());
				ourMap.get(sortedStr).add(str);
			}
		}
		
		// The ourMap values contain our grouped lists
		List<List<String>> result = new ArrayList<>(ourMap.values());
		return result;
	}
	
	// ✅ main() method ✅
	public static void main(String[] args) {
		GroupAnagram myObj = new GroupAnagram();
		String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> result = myObj.groupAnagrams(input);
		
		System.out.println("Group Anagrams: " + result + " Expected: [[eat, tea, ate], [bat], [tan, nat]]");
	}
}