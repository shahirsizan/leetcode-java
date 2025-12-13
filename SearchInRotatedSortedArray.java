import java.util.Arrays;

public class SearchInRotatedSortedArray {

	public int search(int[] numsArray, int target) {
		int leftPointer = 0;
		int rightPointer = numsArray.length - 1;

		while (leftPointer <= rightPointer) {
			int midPointer = leftPointer + (rightPointer - leftPointer) / 2;

			// `target` at `midPointer`, return `midPointer`
			if (numsArray[midPointer] == target) {
				return midPointer;
			}

			//	`target` not at `midPointer`. So it might be in `right subArray` or in `left subArray`.

		// 🧩 consider {4, 5, 6, 👉7👈, 8, 1, 2, 3} where 7 is `midPointer`

			//	left subArray sorted. Check there first because it'll be easy
			if(numsArray[leftPointer] <= numsArray[midPointer]){
				//	if `target` < midPointer element AND ALSO `target` >= leftmost element of `left subArray`, then `target` must be in the `left subArray`.
				if(target < numsArray[midPointer] && target >= numsArray[leftPointer]){
					rightPointer = midPointer - 1;
				}
				// else in the right subArray
				else {
					leftPointer = midPointer + 1;
				}
			}

			// if	left subArray not sorted, then right subArray must be sorted. Check the sorted subArray because it'll be easy
			else {
				// if `target` > midPointer element AND ALSO `target` <= rightmost element of `right subArray`, then `target` must be in the `right subArray`.
				if(target > numsArray[midPointer] && target <= numsArray[rightPointer]) {
					leftPointer = midPointer + 1;
				}
				// else in the left subArray
				else {
					rightPointer = midPointer - 1;
				}
			}
		}

		//	not found, return -1
		return -1;
	}

	// --- Main Method for Demonstration ---

	public static void main(String[] args) {
		SearchInRotatedSortedArray solver = new SearchInRotatedSortedArray();

		// Example 1: Target found in the second (rotated) segment
		int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
		int target1 = 0;
		int result1 = solver.search(nums1, target1); // Expected: 4
		System.out.println("Input: " + Arrays.toString(nums1) + ", Target: " + target1 + ", Index: " + result1);

		System.out.println("-----------------");

		// Example 2: Target found in the first (sorted) segment
		int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
		int target2 = 6;
		int result2 = solver.search(nums2, target2); // Expected: 2
		System.out.println("Input: " + Arrays.toString(nums2) + ", Target: " + target2 + ", Index: " + result2);
	}
}