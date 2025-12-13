import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {

	public int[] dailyTemperatures(int[] temperaturesArray) {
		int n = temperaturesArray.length;
		// default values for emtpy array of types byte, short, int, long: 0
		int[] answerArray = new int[n];
			/* two main types of monotonic stacks: `monotonic increasing` and `monotonic decreasing`.
			An `increasing stack` has elements in `ascending order` from `bottom->top`.
			A `decreasing stack` has elements in `descending order` from `bottom->top`.
			They are used to solve problems involving finding next or previous greater/smaller element */
		ArrayDeque<Integer> stack = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			int currentTemp = temperaturesArray[i];

			while (!stack.isEmpty() && temperaturesArray[stack.peek()] < currentTemp) {
				int prevIndex = stack.pop();
				// calculate wait days
				answerArray[prevIndex] = i - prevIndex;
			}

			stack.push(i);
		}

		// indexes remaining in the stack have no warmer day in future, so their answer remains 0 (default in array).
		return answerArray;
	}

	/*
	 🧩🧩🧩 Main 🧩🧩🧩
	 Input: [73, 74, 75, 71, 69, 72, 76, 73]
	 Expected: [1, 1, 4, 2, 1, 1, 0, 0]
	*/

	public static void main(String[] args) {
		DailyTemperatures solver = new DailyTemperatures();

		int[] temps = {73, 74, 75, 71, 69, 72, 76, 73};
		int[] result = solver.dailyTemperatures(temps);

		System.out.print("Temperatures: ");
		printArray(temps);
		System.out.print("Wait Days: ");
		printArray(result);
	}

	private static void printArray(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
		}
		System.out.println("]");
	}
}