import java.util.Arrays;

public class RemoveDuplicates {

	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return 1;
		}

		int slowPointer = 0;
		for (int fastPointer = 1; fastPointer < nums.length; fastPointer++) {

			if (nums[fastPointer] != nums[slowPointer]) {
//				New unique element found. Copy it into index position `slowPointer + 1`.
				slowPointer++;
				nums[slowPointer] = nums[fastPointer];
			}
			else{
//				Duplicate element. skip.
				continue;
			}
		}

		// Outside for loop. Return number of unique elements.
		return slowPointer + 1;
	}

	// --- Main Method for Demonstration ---

	public static void main(String[] args) {
		RemoveDuplicates solver = new RemoveDuplicates();

		// Example 1:
		int[] nums1 = {1, 1, 2};
		int newLength1 = solver.removeDuplicates(nums1);
		System.out.println("--- Example 1 ---");
		System.out.println("Original Array: {1, 1, 2}");
		System.out.println("New Length: " + newLength1 + " (Expected: 2)");
		// Print the modified portion of the array (first 'newLength1' elements)
		System.out.print("Modified Array (first " + newLength1 + " elements): ");
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums1, 0, newLength1)));
		// Expected: [1, 2]

		System.out.println("-----------------");

		// Example 2:
		int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
		int newLength2 = solver.removeDuplicates(nums2);
		System.out.println("--- Example 2 ---");
		System.out.println("Original Array: {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}");
		System.out.println("New Length: " + newLength2 + " (Expected: 5)");
		System.out.print("Modified Array (first " + newLength2 + " elements): ");
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums2, 0, newLength2)));
		// Expected: [0, 1, 2, 3, 4]
	}
}