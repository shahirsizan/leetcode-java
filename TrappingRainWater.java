import java.util.Arrays;

public class TrappingRainWater {
	
	public int trap(int[] givenHeightArray) {
		if (givenHeightArray == null || givenHeightArray.length < 3) {
			return 0;
		}
		
		int givenArrayLength = givenHeightArray.length;
		int[] leftMaxArray = new int[givenArrayLength];
		int[] rightMaxArray = new int[givenArrayLength];
		
		// populate leftMaxArray
		leftMaxArray[0] = givenHeightArray[0];
		for (int i = 1; i < givenArrayLength; i++) {
			leftMaxArray[i] = Math.max(leftMaxArray[i - 1], givenHeightArray[i]);
		}
		
		// populate rightMaxArray
		rightMaxArray[givenArrayLength - 1] = givenHeightArray[givenArrayLength - 1];
		for (int i = givenArrayLength - 2; i >= 0; i--) {
			rightMaxArray[i] = Math.max(rightMaxArray[i + 1], givenHeightArray[i]);
		}
		
		int totalTrappedWater = 0;
		for (int i = 0; i < givenArrayLength; i++) {
			int currentTrappedWater = (Math.min(leftMaxArray[i], rightMaxArray[i]) - givenHeightArray[i]);
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