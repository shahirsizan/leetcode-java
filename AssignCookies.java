import java.util.Arrays;

public class AssignCookies {
	
	public int findContentChildren(int[] greedFactorList, int[] sizeList) {
		int result = 0;
		// sort both arrays because order doesn't matter
		Arrays.sort(greedFactorList);
		Arrays.sort(sizeList);
		
		int childPointer = 0;
		int cookiePointer = 0;
		
		// iterate as long as there is cookie AND child available
		while (childPointer < greedFactorList.length && cookiePointer < sizeList.length) {
			if (sizeList[cookiePointer] >= greedFactorList[childPointer]) {
				result++;
				childPointer++;
			}
			cookiePointer++;
		}
		// number of children satisfied
		return result;
	}
	
	// ✅main✅
	public static void main(String[] args) {
		AssignCookies ourObj = new AssignCookies();
		
		int[] g1 = {1, 2, 3};
		int[] s1 = {1, 1};
		System.out.println("Output 1: " + ourObj.findContentChildren(g1, s1));
		
		int[] g2 = {1, 2};
		int[] s2 = {1, 2, 3};
		System.out.println("Output 2: " + ourObj.findContentChildren(g2, s2));
		
		int[] g3 = {10, 9, 8, 7};
		int[] s3 = {5, 6, 7, 8};
		System.out.println("Output 3: " + ourObj.findContentChildren(g3, s3));
	}
}