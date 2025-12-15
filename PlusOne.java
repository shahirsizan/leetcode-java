public class PlusOne {
	
	public int[] plusOne(int[] digits) {
		int len = digits.length;
		
		// iterate `left <- right`
		for (int i = len - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				// done. return.
				return digits;
			}
			// digit is `9`, make it `0`, carry goes next iteration
			digits[i] = 0;
		}
		
		// up until this point, all the digits are `9`. So append a `1` to MSB
		int[] newDigits = new int[len + 1];
		newDigits[0] = 1;
		return newDigits;
	}
	
	// ✅helper✅
	private static void printArray(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
		}
		System.out.println("]");
	}
	
	// ✅main✅
	public static void main(String[] args) {
		PlusOne solver = new PlusOne();
		
		// Example 1
		int[] digits1 = {1, 2, 3};
		int[] result1 = solver.plusOne(digits1);
		System.out.print("Result for [1, 2, 3]: ");
		printArray(result1); // Expected: [1, 2, 4]
		
		// Example 2
		int[] digits2 = {4, 3, 2, 9};
		int[] result2 = solver.plusOne(digits2);
		System.out.print("Result for [4, 3, 2, 9]: ");
		printArray(result2); // Expected: [4, 3, 3, 0]
		
		// Example 3
		int[] digits3 = {9, 9, 9};
		int[] result3 = solver.plusOne(digits3);
		System.out.print("Result for [9, 9, 9]: ");
		printArray(result3); // Expected: [1, 0, 0, 0]
	}
	
	
}