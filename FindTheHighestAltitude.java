// https://leetcode.com/problems/find-the-highest-altitude/description/
// https://medium.com/@maityamit/prefix-sum-summary-with-practice-questions-sheet-1d-2d-on-leetcode-83c8deb4f713

public class FindTheHighestAltitude {
	
	public int largestAltitude(int[] gain) {
		int currentAltitude = 0;
		int maxAltitude = 0;
		
		for (int g : gain) {
			currentAltitude += g;
			if (currentAltitude > maxAltitude) {
				maxAltitude = currentAltitude;
			}
		}
		
		return maxAltitude;
	}
	
	public static void main(String[] args) {
		FindTheHighestAltitude solver = new FindTheHighestAltitude();
		
		// Example 1: gain = [-5, 1, 5, 0, -7]
		// Altitudes: 0 -> -5 -> -4 -> 1 -> 1 -> -6
		int[] gain1 = {-5, 1, 5, 0, -7};
		System.out.println("Max altitude: " + solver.largestAltitude(gain1)); // Output: 1
		
		// Example 2: gain = [-4, -3, -2, -1, 4, 3, 2]
		// Altitudes: 0 -> -4 -> -7 -> -9 -> -10 -> -6 -> -3 -> -1
		int[] gain2 = {-4, -3, -2, -1, 4, 3, 2};
		System.out.println("Max altitude: " + solver.largestAltitude(gain2)); // Output: 0
	}
}