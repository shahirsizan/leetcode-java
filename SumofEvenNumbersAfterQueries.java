// https://leetcode.com/problems/sum-of-even-numbers-after-queries/description/?q=985

import java.util.Arrays;

public class SumofEvenNumbersAfterQueries {
	public int[] sumEvenAfterQueries(int[] givenNumsList, int[][] givenQueries) {
		int evenSum = 0;
		
		// calculate initial `evenSum` of all even numbers in `givenNumsList`
		for (int x : givenNumsList) {
			if (x % 2 == 0) {
				evenSum += x;
			}
		}
		
		int[] resultList = new int[givenQueries.length];
		
		/**
		 * Approach:
		 * If `currentVal` that is being manipulated was `even` and after operation becomes `odd`,
		 *      we subtract `currentVal` from `evenSum` as it will have no contribution to the sum after becoming `odd`.
		 * If `currentVal` that is being manipulated was `even` and after operation stays `even`,
		 *      we add/subtract the `queryVal` to `evenSum`.
		 * If `currentVal` that is being manipulated was `odd` and after operation becomes `odd`,
		 *      do nothing.
		 * If `currentVal` that is being manipulated was `odd` and after operation becomes `even`,
		 *      add the new even `currentVal`.
		 * This way we won't have to calculate evenSum after every query which requires O(n) time complexity.
		 * */
		for (int i = 0; i < givenQueries.length; i++) {
			int queryVal = givenQueries[i][0];
			int queryIdx = givenQueries[i][1];
			
			// if currentVal even
			if (givenNumsList[queryIdx] % 2 == 0) {
				// becomes odd
				if ((givenNumsList[queryIdx] + queryVal) % 2 != 0) {
					evenSum -= givenNumsList[queryIdx];
				}
				// stays even
				else {
					evenSum += queryVal;
				}
			}
			// if currentVal odd
			else {
				// stays odd
				if ((givenNumsList[queryIdx] + queryVal) % 2 != 0) {
					// skip. But have to reach at the end of the code because we have to update the `givenNumsList`
				}
				// becomes even
				else {
					evenSum += givenNumsList[queryIdx] + queryVal;
				}
			}
			
			// store result to resultList
			resultList[i] = evenSum;
			// irrespective of result, we have to update the original array
			givenNumsList[queryIdx] += queryVal;
		}
		
		return resultList;
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		SumofEvenNumbersAfterQueries myObj = new SumofEvenNumbersAfterQueries();
		int[] nums = {1, 2, 3, 4};
		int[] nums2 = {3, 2};
		int[][] queries = {{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
		int[][] queries2 = {{4, 0}, {3, 0}};
		int[] result = myObj.sumEvenAfterQueries(nums2, queries2);
		System.out.println("Result after each query: " + Arrays.toString(result));
		// Output: [8, 6, 2, 4]
	}
}