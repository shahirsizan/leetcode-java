// https://leetcode.com/problems/contains-duplicate-ii/?q=219

import java.util.HashMap;

public class ContainsDuplicate2 {
	public boolean containsNearbyDuplicate(int[] givenNums, int k) {
		HashMap<Integer, Integer> ourHashMap = new HashMap<>();
		
		for (int i = 0; i < givenNums.length; i++) {
			int currentNum = givenNums[i];
			
			if (ourHashMap.containsKey(currentNum)) {
				int previousIndex = ourHashMap.get(currentNum);
				
				if (Math.abs(i - previousIndex) <= k) {
					return true;
				}
			}
			
			// record (element, it's index) as (key,value) in hashmap
			// If the map previously contained a mapping for the key, the old value is replaced.
			// We need the updated index.
			ourHashMap.put(currentNum, i);
		}
		
		return false;
	}
	
	
	public static void main(String[] args) {
		ContainsDuplicate2 myObj = new ContainsDuplicate2();
		int[] nums = {1, 2, 3, 1, 2, 3};
		int k = 2;
		boolean result = myObj.containsNearbyDuplicate(nums, k);
		System.out.println("Result: " + result + " (Expected: false)");
	}
}
