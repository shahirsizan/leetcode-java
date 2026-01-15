// https://leetcode.com/problems/next-permutation/description/

import java.util.Arrays;

public class NextPermutation {
	
	public void nextPermutation(int[] givenNumsList) {
		// if given permutation length <= 2, just reverse it.
		if (givenNumsList.length <= 2) {
			reverse(givenNumsList, 0);
			return;
		}
		
		// for length >= 3
		int i = givenNumsList.length - 2;
		// from right to left, find the first element which is smaller than its right element.
		while (i >= 0 && givenNumsList[i] >= givenNumsList[i + 1]) {
			i--;
		}
		
		// found an element which is smaller than its right one.
		// Time to find its immediate larger element in the right subarray and swap them
		if (i >= 0) {
			int j = givenNumsList.length - 1;
			while (givenNumsList[j] <= givenNumsList[i]) {
				j--;
			}
			// swap
			int temp = givenNumsList[i];
			givenNumsList[i] = givenNumsList[j];
			givenNumsList[j] = temp;
		}
		
		// reverse the remaining array from the specified position to get the smallest possible suffix
		reverse(givenNumsList, i + 1);
	}
	
	private void reverse(int[] givenNumsList, int leftPointer) {
		int rightPointer = givenNumsList.length - 1;
		
		while (leftPointer < rightPointer) {
			// swap
			int temp = givenNumsList[leftPointer];
			givenNumsList[leftPointer] = givenNumsList[rightPointer];
			givenNumsList[rightPointer] = temp;
			
			leftPointer++;
			rightPointer--;
		}
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		NextPermutation myObj = new NextPermutation();
		int[] arr = {1, 9, 4, 3, 2};
		myObj.nextPermutation(arr);
		System.out.println("Next premutation: " + Arrays.toString(arr));
	}
}