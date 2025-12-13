import java.util.Arrays;

public class BinarySearchSolver {

	public int search(int[] numsArray, int target) {
		int leftPointer = 0;
		int rightPointer = numsArray.length - 1;

		while (leftPointer <= rightPointer) {
			int midPointer = leftPointer + (rightPointer - leftPointer) / 2;

			if (numsArray[midPointer] == target) {
				return midPointer;
			} else if (target > numsArray[midPointer]) {
				leftPointer = midPointer + 1;
			} else {
				rightPointer = midPointer - 1;
			}
		}

		return -1;
	}

	// --- Main ---

	public static void main(String[] args) {
		BinarySearchSolver solver = new BinarySearchSolver();

		// Example 1: Target found
		int[] nums1 = {-1, 0, 3, 5, 9, 12};
		int target1 = 9;
		int result1 = solver.search(nums1, target1);
		System.out.println("--- Example 1 ---");
		System.out.println("Array: " + Arrays.toString(nums1) + ", Target: " + target1);
		System.out.println("Index: " + result1 + " (Expected: 4)");

		System.out.println("-----------------");

		// Example 2: Target not found
		int[] nums2 = {-1, 0, 3, 5, 9, 12};
		int target2 = 2;
		int result2 = solver.search(nums2, target2);
		System.out.println("--- Example 2 ---");
		System.out.println("Array: " + Arrays.toString(nums2) + ", Target: " + target2);
		System.out.println("Index: " + result2 + " (Expected: -1)");
	}
}