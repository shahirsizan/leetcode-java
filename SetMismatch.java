// https://leetcode.com/problems/set-mismatch/?q=645

public class SetMismatch {
	
	public int[] findErrorNums(int[] givenNums) {
		int[] freqArray = new int[givenNums.length + 1];
		int duplicate = -1;
		int missing = -1;
		
		// fill up freqArray
		for (int x : givenNums) {
			freqArray[x]++;
		}
		
		// scan freqArray
		for (int i = 1; i <= givenNums.length; i++) {
			if (freqArray[i] == 2) {
				duplicate = i;
			} else if (freqArray[i] == 0) {
				missing = i;
			}
		}
		
		return new int[]{duplicate, missing};
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		SetMismatch myObj = new SetMismatch();
		int[] input = {2, 2, 3, 4}; // duplicate = 2, Missing = 1; [2,1]
		int[] result = myObj.findErrorNums(input);
		System.out.println("Duplicate: " + result[0] + ", Missing: " + result[1]);
	}
}