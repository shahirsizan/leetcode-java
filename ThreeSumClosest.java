import java.util.Arrays;

public class ThreeSumClosest {
	
	public int threeSumClosest(int[] givenNumsList, int target) {
		Arrays.sort(givenNumsList);
		// initialize globalClosestSum
		int globalClosestSum = givenNumsList[0] + givenNumsList[1] + givenNumsList[2];
		
		for (int i = 0; i < givenNumsList.length - 2; i++) {
			// if for 1st position, current element is similar to previous one, skip it as it will contribute to duplicate triplet.
			if (i > 0 && givenNumsList[i] == givenNumsList[i - 1]) {
				continue;
			}
			int left = i + 1;
			int right = givenNumsList.length - 1;
			
			while (left < right) {
				int currentClosestSum = givenNumsList[i] + givenNumsList[left] + givenNumsList[right];
				
				if (currentClosestSum == target) {
					return currentClosestSum;
				}
				
				// update globalClosestSum if not exact match
				if (Math.abs(target - currentClosestSum) < Math.abs(target - globalClosestSum)) {
					globalClosestSum = currentClosestSum;
				}
				
				// move pointers
				if (currentClosestSum < target) {
					left++;
					// if for left pointer, current element is similar to its left one, skip it as it will contribute to duplicate triplet.
					while (left < right && givenNumsList[left] == givenNumsList[left - 1]) {
						left++;
					}
				} else {
					right--;
					// if for right pointer, current element is similar its right one, skip it as it will contribute to duplicate triplet.
					while (left < right && givenNumsList[right] == givenNumsList[right + 1]) {
						right--;
					}
				}
			}
		}
		
		return globalClosestSum;
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		ThreeSumClosest myObj = new ThreeSumClosest();
		int[] nums = {-1, 2, 1, -4};
		int target = 1;
		
		int result = myObj.threeSumClosest(nums, target);
		System.out.println("The closest sum to " + target + " is: " + result);
	}
}