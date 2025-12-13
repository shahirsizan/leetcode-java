import java.util.Arrays;

public class FindFirstAndLastPosition {

	public int[] searchRange(int[] numsArray, int target) {
		int[] resultArray = new int[] {-1, -1};

		// find `start` index.
		resultArray[0] = findBoundary(numsArray, target, "lookForStart");
		// Only search for `end` index if `start` was found (resultArray[0] != 0)
		if (resultArray[0] != -1) {
			resultArray[1] = findBoundary(numsArray, target, "lookForEnd");
		}

		return resultArray;
	}


	private int findBoundary(int[] numsArray, int target, String lookForWhat) {
		int index = -1;

		int leftPointer = 0;
		int rightPointer = numsArray.length - 1;

		while (leftPointer <= rightPointer) {
			int mid = leftPointer + (rightPointer - leftPointer) / 2;

			if (numsArray[mid] == target) {
				index = mid;
				// `target` found. In normal binary-search, we would have sent back the `index`.
				// But for this problem, we won't stop. Below `if-else` block extends the search functionality
				//	to again search for further left/right occurrences of the `target`
				if (lookForWhat.equals("lookForStart")) {
					// to further check for left occurrence, search the left half
					rightPointer = mid - 1;
				}
				if (lookForWhat.equals("lookForEnd")) {
					// to further check for right occurrence, search the right half
					leftPointer = mid + 1;
				}
			}
			else if (target > numsArray[mid]) {
				leftPointer = mid + 1;
			}
			else {
				rightPointer = mid - 1;
			}
		}
		return index;
	}

	// --- Main Method for Demonstration ---

	public static void main(String[] args) {
		FindFirstAndLastPosition solver = new FindFirstAndLastPosition();

		// Example 1: Target found multiple times
		int[] nums1 = {5, 7, 7, 8, 8, 10};
		int target1 = 8;
		int[] result1 = solver.searchRange(nums1, target1);
		System.out.println("--- Example 1 ---");
		System.out.println("Array: " + Arrays.toString(nums1) + ", Target: " + target1);
		System.out.println("Range: " + Arrays.toString(result1) + " (Expected: [3, 4])");

		System.out.println("-----------------");

		// Example 2: Target not found
		int[] nums2 = {5, 7, 7, 8, 8, 10};
		int target2 = 6;
		int[] result2 = solver.searchRange(nums2, target2);
		System.out.println("--- Example 2 ---");
		System.out.println("Array: " + Arrays.toString(nums2) + ", Target: " + target2);
		System.out.println("Range: " + Arrays.toString(result2) + " (Expected: [-1, -1])");
	}
}