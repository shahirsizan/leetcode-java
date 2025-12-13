import java.util.Arrays;

public class MergeSortedArray {

	public void merge(int[] nums1Array, int nums1Length, int[] nums2Array, int nums2Length) {
		int nums1LastPointer = nums1Length - 1;
		int nums2LastPointer = nums2Length - 1;
		int nums1EntireLastPointer = nums1Length + nums2Length - 1;

		while (nums2LastPointer >= 0) {
			// nums1Array current element larger
			if (nums1LastPointer >= 0 && nums1Array[nums1LastPointer] >= nums2Array[nums2LastPointer]) {
				nums1Array[nums1EntireLastPointer] = nums1Array[nums1LastPointer];
				nums1LastPointer--;
				nums1EntireLastPointer--;
			}
			// nums1Array finished `OR` nums2Array current element larger
			else {
				nums1Array[nums1EntireLastPointer] = nums2Array[nums2LastPointer];
				nums2LastPointer--;
				nums1EntireLastPointer--;
			}
		}
	}

	// --- Main Method for Demonstration ---

	public static void main(String[] args) {
		MergeSortedArray solver = new MergeSortedArray();

		// Example 1: Standard merge
		int m1 = 3;
		int n1 = 3;
		int[] nums1_1 = {1, 2, 3, 0, 0, 0}; // m=3, n=3
		int[] nums2_1 = {2, 5, 6};
		solver.merge(nums1_1, m1, nums2_1, n1);
		// Expected: [1, 2, 2, 3, 5, 6]
		System.out.println("--- Example 1 ---");
		System.out.println("Result: " + Arrays.toString(nums1_1));

		System.out.println("-----------------");

		// Example 2: nums2 contains all smaller elements
		int m2 = 1;
		int n2 = 2;
		int[] nums1_2 = {4, 0, 0}; // m=1, n=2
		int[] nums2_2 = {1, 2};
		solver.merge(nums1_2, m2, nums2_2, n2);
		// Expected: [1, 2, 4]
		System.out.println("--- Example 2 ---");
		System.out.println("Result: " + Arrays.toString(nums1_2));
	}
}