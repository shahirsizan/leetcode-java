// https://leetcode.com/problems/3sum/description/?q=15

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	
	public List<List<Integer>> threeSum(int[] givenNumsList) {
		List<List<Integer>> resultList = new ArrayList<>();
		Arrays.sort(givenNumsList);
		// example: [-1,0,0,0,0,1,2,-1,-4,-4,-4] -> sort -> [-4,-4,-4,-1,-1,0,0,0,0,1,2]
		
		for (int i = 0; i < givenNumsList.length - 2; i++) {
			// if for 1st position, current element is similar to previous one, skip it as it will contribute to duplicate triplet.
			if (i > 0 && givenNumsList[i] == givenNumsList[i - 1]) {
				continue;
			}
			
			int left = i + 1;
			int right = givenNumsList.length - 1;
			
			// for 2nd and 3rd positions
			while (left < right) {
				int sum = givenNumsList[i] + givenNumsList[left] + givenNumsList[right];
				
				if (sum == 0) {
					resultList.add(Arrays.asList(givenNumsList[i], givenNumsList[left], givenNumsList[right]));
					left++;
					right--;
					
					// if for left pointer, current element is similar to its left one, skip it as it will contribute to duplicate triplet.
					while (left < right && givenNumsList[left] == givenNumsList[left - 1]) {
						left++;
					}
					// if for right pointer, current element is similar its right one, skip it as it will contribute to duplicate triplet.
					while (left < right && givenNumsList[right] == givenNumsList[right + 1]) {
						right--;
					}
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}
		
		return resultList;
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		ThreeSum myObj = new ThreeSum();
		int[] nums = {-1, 0, 0, 0, 0, 1, 2, -1, -4};
		
		List<List<Integer>> result = myObj.threeSum(nums);
		System.out.println("Unique triplets that sum to zero: ");
		for (List<Integer> triplet : result) {
			System.out.println(triplet);
		}
	}
}