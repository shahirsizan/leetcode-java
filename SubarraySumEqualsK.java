// https://leetcode.com/problems/subarray-sum-equals-k/description/
// CPS academy sheet (Arrays)

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
	
	// 🥎 draw diagram for [1, 1, 1, 2, 3, 4, 5, 4, 1] and k = 5. It's easy.
	
	public int subarraySum(int[] givenNums, int k) {
		int count = 0;
		int currentSum = 0;
		
		// [key: prefix sum] | [value: Frequency of that sum]
		Map<Integer, Integer> myMap = new HashMap<>();
		
		// have to put [0:1] in map because the first few consecutive numbers can sum up to `k`.
		myMap.put(0, 1);
		
		for (int num : givenNums) {
			currentSum += num;
			
			// We have to develop a `prefix sum` array.
			// If (currentSum - k) exists in myMap, it means there is a subarray.
			// [1, 1, 1, 2, 3, 4, 5, 4, 1] and k = 5
			// 👆       👆   sum up to 5.
			// [1, 1, 1, 2, 3, 4, 5, 4, 1] and k = 5
			//          👆 👆   sum up to 5.
			// and so on...
			
			if (myMap.containsKey(currentSum - k)) {
				count += myMap.get(currentSum - k);
			}
			
			// Update current prefix sum frequency
			myMap.put(currentSum, myMap.getOrDefault(currentSum, 0) + 1);
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		SubarraySumEqualsK myObj = new SubarraySumEqualsK();
		int[] arr1 = {1, 1, 1, 2, 3, 4, 5, 4, 1};
		int result = myObj.subarraySum(arr1, 5);
		System.out.println("Result: " + result);
	}
	
}

