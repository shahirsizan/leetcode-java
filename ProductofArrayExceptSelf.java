// CPS academy DSA sheet (Arrays & Matrix)
// https://leetcode.com/problems/product-of-array-except-self/description/

import java.util.Arrays;

public class ProductofArrayExceptSelf {
	
	// given:                   [1,2,3,4]
	// prefix multiplication:   [1,1,2,6]
	// suffix multiplication    [24,12,4,1]
	// after multiplying:       [24,12,8,6] (result)
	
	// given:                   [-1, 1, 0, -3, 3]
	// prefix multiplication:   [1, -1, -1, 0, 0]
	// suffix multiplication:   [0, 0, -9, 3, 1]
	// after multiplying:       [0, 0, 9, 0, 0] (result)
	
	
	public int[] productExceptSelf(int[] givenArray) {
		int arrayLength = givenArray.length;
		int[] answerArray = new int[arrayLength];
		
		int prefixProduct = 1;
		for (int i = 0; i < arrayLength; i++) {
			answerArray[i] = prefixProduct;
			// update prefix product
			prefixProduct = prefixProduct * givenArray[i];
		}
		
		int suffixProduct = 1;
		for (int i = arrayLength - 1; i >= 0; i--) {
			answerArray[i] = answerArray[i] * suffixProduct;
			// update suffix product
			suffixProduct = suffixProduct * givenArray[i];
		}
		
		return answerArray;
	}
	
	
	public static void main(String[] args) {
		ProductofArrayExceptSelf myObj = new ProductofArrayExceptSelf();
		
		// Example 1:
		int[] nums1 = {1, 2, 3, 4};
		int[] result1 = myObj.productExceptSelf(nums1);
		// Expected: [2*3*4, 1*3*4, 1*2*4, 1*2*3] = [24, 12, 8, 6]
		System.out.println("Input: " + Arrays.toString(nums1));
		System.out.println("Result: " + Arrays.toString(result1));
		
		System.out.println("-----------------");
		
		// Example 2: Includes zeros (must handle correctly without division)
		int[] nums2 = {-1, 1, 0, -3, 3};
		
		int[] result2 = myObj.productExceptSelf(nums2);
		// Expected: [0, 0, 9, 0, 0]
		System.out.println("Input: " + Arrays.toString(nums2));
		System.out.println("Result: " + Arrays.toString(result2));
	}
}