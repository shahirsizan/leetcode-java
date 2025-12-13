// INCOMPLETE. CHECK LATER
// https://leetcode.com/problems/car-fleet/description/

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;

public class CarFleet {

	public int carFleet(int target, int[] position, int[] speed) {
		int N = position.length;
		if (N == 0) {
			return 0;
		}

		// 1. Create a combined array/class to hold (position, time) pairs.
		// We store (position, time_to_target)
		double[][] cars = new double[N][2];
		for (int i = 0; i < N; i++) {
			cars[i][0] = position[i];
			// Calculate time = (target - position) / speed
			cars[i][1] = (double) (target - position[i]) / speed[i];
		}

		// 2. Sort the cars based on position in DESCENDING order.
		// We process cars from closest to farthest from the target.
		Arrays.sort(cars, Comparator.comparingDouble((double[] a) -> a[0]).reversed());

		// 3. Use a stack to track the arrival time of the leader of each fleet.
		// We only need the arrival time, so we can use a single Deque<Double>.
		ArrayDeque<Double> stack = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			double currentTime = cars[i][1];

			// If the stack is empty, this car is the first leader of a new fleet.
			if (stack.isEmpty()) {
				stack.push(currentTime);
			} else {
				double leadingFleetTime = stack.peek();

				// If the current car is SLOWER (takes longer or equal time) than the leading car,
				// it will catch up and join the current fleet. We discard its time.
				// (currentTime >= leadingFleetTime)
				if (currentTime > leadingFleetTime) {
					// This car is slower, meaning it takes longer to reach the target,
					// so it forms a new, independent fleet that the previous leader cannot catch.
					stack.push(currentTime);
				}
				// If currentTime <= leadingFleetTime, the current car catches the leader.
				// It joins the existing fleet and does not become a new fleet leader.
			}
		}

		// The number of elements in the stack is the total number of distinct fleets.
		return stack.size();
	}

	// --- Main Method for Demonstration ---

	public static void main(String[] args) {
		CarFleet solver = new CarFleet();

		int target = 12;
		int[] position = {10, 8, 0, 5, 3};
		int[] speed = {2, 4, 1, 1, 3};

		int result = solver.carFleet(target, position, speed);

		// Expected fleets:
		// Car at 10 (Time: 1.0) -> Fleet 1 Leader
		// Car at 8 (Time: 1.0) -> Joins Fleet 1
		// Car at 5 (Time: 7.0) -> Forms Fleet 2 Leader
		// Car at 3 (Time: 3.0) -> Catches Fleet 2
		// Car at 0 (Time: 12.0) -> Forms Fleet 3 Leader
		// Expected Result: 3

		System.out.println("Target: " + target);
		System.out.println("Positions: " + Arrays.toString(position));
		System.out.println("Speeds: " + Arrays.toString(speed));
		System.out.println("Total Car Fleets: " + result);
	}
}