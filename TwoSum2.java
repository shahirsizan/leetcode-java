import java.util.Arrays;

public class TwoSum2 {
	public int[] twoSum(int[] numbers, int target) {
		int leftPointer = 0;
		int rightPointer = numbers.length - 1;

		while (leftPointer < rightPointer) {
			int currentSum = numbers[leftPointer] + numbers[rightPointer];

			if (currentSum == target) {
				return new int[] {leftPointer+1, rightPointer+1};
			} else if (currentSum > target) {
				rightPointer--;
			} else {
				leftPointer++;
			}
		}

		throw new IllegalArgumentException("Two sum cannot be found!");
	}

	// --- Main Method for Demonstration ---

	public static void main(String[] args) {
		TwoSum2 solver = new TwoSum2();

		// Example 1:
		int[] numbers1 = {2, 7, 11, 15};
		int target1 = 9;
		int[] result1 = solver.twoSum(numbers1, target1);
		// Expected: 2 (index 1) + 7 (index 2) = 9. Output: [1, 2]
		System.out.println("--- Example 1 ---");
		System.out.println("Input: " + Arrays.toString(numbers1) + ", Target: " + target1);
		System.out.println("Result (1-based indices): " + Arrays.toString(result1));

		System.out.println("-----------------");

		// Example 2:
		int[] numbers2 = {2, 3, 4};
		int target2 = 6;
		int[] result2 = solver.twoSum(numbers2, target2);
		// Expected: 2 (index 1) + 4 (index 3) = 6. Output: [1, 3]
		System.out.println("--- Example 2 ---");
		System.out.println("Input: " + Arrays.toString(numbers2) + ", Target: " + target2);
		System.out.println("Result (1-based indices): " + Arrays.toString(result2));
	}
}