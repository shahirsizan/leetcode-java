
import java.util.Arrays;

public class RotateArray {
	
	public void rotate(int[] givenNums, int k) {
		// constraint edge cases
		if (givenNums.length == 1 || k == 0) {
			return;
		}
		
		// normalize k
		int n = givenNums.length;
		k = k % n;
		
		/**
		 * {1, 2, 3, 4, 5, 6, 7}, k = 3
		 * 👉 Reverse the whole array
		 * {7, 6, 5, 4, 3, 2, 1}
		 * 👉 Reverse the first `k` elements
		 * {5, 6, 7,    4, 3, 2, 1}
		 * 👉 The reverse the rest `n-k` elements separately
		 * {5, 6, 7,    1, 2, 3, 4}
		 */
		
		reverse(givenNums, 0, n - 1);
		
		reverse(givenNums, 0, k - 1);
		
		reverse(givenNums, k, n - 1);
	}
	
	private void reverse(int[] givenNums, int start, int end) {
		while (start < end) {
			int temp = givenNums[start];
			givenNums[start] = givenNums[end];
			givenNums[end] = temp;
			start++;
			end--;
		}
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		RotateArray myObj = new RotateArray();
		int[] data = {1, 2, 3, 4, 5, 6, 7};
		int k = 3;
		
		System.out.println("Before: " + Arrays.toString(data));
		myObj.rotate(data, k);
		System.out.println("After:  " + Arrays.toString(data) + " ((Expected = [5, 6, 7, 1, 2, 3, 4]))");
	}
}