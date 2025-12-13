// https://leetcode.com/problems/moving-average-from-data-stream/


import java.util.ArrayDeque;

public class MovingAverage {
	
	private int size;
	private ArrayDeque<Integer> ourDeque;
	private double windowSum;
	
	public MovingAverage(int size) {
		this.size = size;
		this.ourDeque = new ArrayDeque<>();
		this.windowSum = 0.0;
	}
	
	
	// add new value from the stream to `ourDeque` and return the average of the current `window`.
	public double next(int val) {
		if (ourDeque.size() == size) {
			// remove the oldest element and subtract from windowSum
			windowSum -= ourDeque.peek().intValue();
			ourDeque.remove();
		}
		
		// add new value (last-in) and update the sum.
		ourDeque.addLast(val);
		windowSum += val;
		
		
		// calculate and return the average.
		return windowSum / ourDeque.size();
	}
	
	
	public static void main(String[] args) {
		MovingAverage obj = new MovingAverage(3);
		
		// Step 1: next(1) -> Sum=1, Count=1. Avg = 1/1 = 1.0
		System.out.println("next(1): " + obj.next(1));
		
		// Step 2: next(10) -> Sum=11, Count=2. Avg = 11/2 = 5.5
		System.out.println("next(10): " + obj.next(10));
		
		// Step 3: next(3) -> Sum=14, Count=3. Avg = 14/3 ≈ 4.67
		System.out.println("next(3): " + obj.next(3));
		
		// Step 4: next(5) -> Removes 1, Sum=14-1+5=18, Count=3. Avg = 18/3 = 6.0
		System.out.println("next(5): " + obj.next(5));
	}
}