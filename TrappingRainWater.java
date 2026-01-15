import java.util.Arrays;

public class TrappingRainWater {
	
	public int trap(int[] givenHeightArray) {
		if (givenHeightArray.length < 3) {
			return 0;
		}
		
		int givenArrayLength = givenHeightArray.length;
		int[] leftTallestArray = new int[givenArrayLength];
		int[] rightTallestArray = new int[givenArrayLength];
		
		// populate leftTallestArray
		// leftTallest for left most place is 0
		leftTallestArray[0] = 0;
		for (int i = 1; i < givenArrayLength; i++) {
			leftTallestArray[i] = Math.max(leftTallestArray[i - 1], givenHeightArray[i - 1]);
		}
		
		// populate rightTallestArray
		// rightTallest for right most place is 0
		rightTallestArray[givenArrayLength - 1] = 0;
		for (int i = givenArrayLength - 2; i >= 0; i--) {
			rightTallestArray[i] = Math.max(rightTallestArray[i + 1], givenHeightArray[i + 1]);
		}
		
		int totalTrappedWater = 0;
		for (int i = 0; i < givenArrayLength; i++) {
			int currentWater = (Math.min(leftTallestArray[i], rightTallestArray[i]) - givenHeightArray[i]);
			// for places where left and right tallest are 0, it will render (-)ve `currentWater` value
			int currentTrappedWater = (currentWater < 0) ? 0 : currentWater;
			totalTrappedWater = totalTrappedWater + currentTrappedWater;
		}
		
		return totalTrappedWater;
	}
	
	// --- Main ---
	
	public static void main(String[] args) {
		TrappingRainWater solver = new TrappingRainWater();
		
		// Example 1:
		int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		int result1 = solver.trap(height1);
		// Expected: 6 units
		System.out.println("--- Example 1 ---");
		System.out.println("Height: " + Arrays.toString(height1));
		System.out.println("Trapped Water: " + result1);
		
		System.out.println("-----------------");
	}
}