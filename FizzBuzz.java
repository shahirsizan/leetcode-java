import java.util.ArrayList;
import java.util.List;
import java.util.ArrayDeque;

public class FizzBuzz {

	public ArrayList<String> fizzBuzz(int n) {
		ArrayList<String> result = new ArrayList<>();

		for (int i = 1; i <= n; i++) {

			if (i % 3 == 0 && i % 5 == 0) {
				result.add("FizzBuzz");
			}
			else if (i % 3 == 0) {
				result.add("Fizz");
			}
			else if (i % 5 == 0) {
				result.add("Buzz");
			}
			else {
				// int -> Integer -> string. This conversion is needed because `toString()` can only be applied to `Object` types, not `primitive` types.
				Integer I = i;
				result.add(I.toString());
			}
		}

		return result;
	}

	// --- Main Method for Demonstration ---

	public static void main(String[] args) {
		FizzBuzz solver = new FizzBuzz();

		// Example: n = 5
		int n1 = 5;
		List<String> result1 = solver.fizzBuzz(n1);
		// Expected: ["1", "2", "Fizz", "4", "Buzz"]
		System.out.println("--- Example 1 (n=5) ---");
		System.out.println("Result: " + result1);

		System.out.println("-----------------");

		// Example: n = 15
		int n2 = 15;
		List<String> result2 = solver.fizzBuzz(n2);
		// Expected: ["1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"]
		System.out.println("--- Example 2 (n=15) ---");
		System.out.println("Result: " + result2);
	}
}