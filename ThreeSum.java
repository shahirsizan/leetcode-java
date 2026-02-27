// CPS academy DSA sheet (Arrays)
// https://leetcode.com/problems/3sum/description/?q=15

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	
	public List<List<Integer>> threeSum(int[] givenNumsList) {
		List<List<Integer>> resultList = new ArrayList<>();
		Arrays.sort(givenNumsList);
		int target = 0;
		// example: [-1,0,0,0,0,1,2,-1,-4,-4,-4] -> sort -> [-4,-4,-4,-1,-1,0,0,0,0,1,2]
		
		for (int i = 0; i < givenNumsList.length - 2; i++) {
			// ⚠️ duplication alert
			// if for 1st position, current element is similar to previous one, skip it
			// as it could contribute to another duplicate triplet.
			if (i > 0 && givenNumsList[i] == givenNumsList[i - 1]) {
				continue;
			}
			
			int leftPointer = i + 1;
			int rightPointer = givenNumsList.length - 1;
			
			// for 2nd and 3rd positions
			while (leftPointer < rightPointer) {
				int sum = givenNumsList[i] + givenNumsList[leftPointer] + givenNumsList[rightPointer];
				
				if (sum == target) {
					resultList.add(Arrays.asList(givenNumsList[i], givenNumsList[leftPointer], givenNumsList[rightPointer]));
					leftPointer++;
					rightPointer--;
					
					// ⚠️ duplication alert
					// if current `leftPointer` element is similar to its `left side` one,
					// skip it as it could contribute to another duplicate triplet.
					// don't worry about indexOutOfBound error because in this if statement above, we have changed `leftPointer`
					while (leftPointer < rightPointer && givenNumsList[leftPointer] == givenNumsList[leftPointer - 1]) {
						leftPointer++;
					}
					
					// ⚠️ duplication alert
					// if current `rightPointer` element is similar to its `right side` one,
					// skip it as it could contribute to another duplicate triplet.
					// don't worry about indexOutOfBound error because in this if statement above, we have changed `rightPointer`
					while (leftPointer < rightPointer && givenNumsList[rightPointer] == givenNumsList[rightPointer + 1]) {
						rightPointer--;
					}
				} else if (sum < target) {
					leftPointer++;
				} else {
					rightPointer--;
				}
			}
		}
		
		return resultList;
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		ThreeSum myObj = new ThreeSum();
		int[] nums = {-1, 0, 0, 0, 0, 1, 2, -1, -4};
		int[] nums2 = {0, 0, 1};
		
		List<List<Integer>> result = myObj.threeSum(nums2);
		System.out.println("Unique triplets that sum to zero: ");
		for (List<Integer> triplet : result) {
			System.out.println(triplet);
		}
	}
}