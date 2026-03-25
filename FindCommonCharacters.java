// https://leetcode.com/problems/find-common-characters/description/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCommonCharacters {
	public List<String> commonChars(String[] givenWords) {
		Map<Character, Integer> globalMinFreqMap = new HashMap<>();
		for (char c : givenWords[0].toCharArray()) {
			globalMinFreqMap.put(c, globalMinFreqMap.getOrDefault(c, 0) + 1);
		}
		
		// Intersect with every other words
		for (int i = 1; i < givenWords.length; i++) {
			Map<Character, Integer> currentFreqMap = new HashMap<>();
			for (char c : givenWords[i].toCharArray()) {
				currentFreqMap.put(c, currentFreqMap.getOrDefault(c, 0) + 1);
			}
			
			// temporary frequency map
			Map<Character, Integer> tempFreqMap = new HashMap<>();
			for (char key : globalMinFreqMap.keySet()) {
				if (currentFreqMap.containsKey(key)) {
					tempFreqMap.put(key, Math.min(globalMinFreqMap.get(key), currentFreqMap.get(key)));
				}
			}
			// Update global frequency map
			globalMinFreqMap = tempFreqMap;
		}
		
		// Convert Map to `List of characters`
		List<String> result = new ArrayList<>();
		for (Map.Entry<Character, Integer> entry : globalMinFreqMap.entrySet()) {
			for (int i = 0; i < entry.getValue(); i++) {
				result.add(String.valueOf(entry.getKey()));
			}
		}
		
		return result;
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		FindCommonCharacters myObj = new FindCommonCharacters();
		String[] input = {"sizan", "siz", "s"};
		System.out.println("Common Characters: " + myObj.commonChars(input));
	}
}