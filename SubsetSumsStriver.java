import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSumsStriver {
	
	public List<Integer> subsetSums(int[] givenArray) {
		List<Integer> resultList = new ArrayList<>();
		subsetSumsHelper(givenArray, 0, 0, resultList);
		// sort resultList
		Collections.sort(resultList);
		return resultList;
	}
	
	public void subsetSumsHelper(int[] givenArray, int i, int currentSum, List<Integer> resultList) {
		// base case
		if (i == givenArray.length) {
			resultList.add(currentSum);
			return;
		}
		
		// pick current, so add it to currentSum
		subsetSumsHelper(givenArray, i + 1, currentSum + givenArray[i], resultList);
		
		// not-pick current, so currentSum stays as it is
		subsetSumsHelper(givenArray, i + 1, currentSum, resultList);
	}
	
	
	// ✅ main() ✅
	public static void main(String[] args) {
		SubsetSumsStriver myObj = new SubsetSumsStriver();
		int[] arr = {5, 2, 1};
		List<Integer> result = myObj.subsetSums(arr);
		System.out.println("Subset Sums in increasing order: " + result);
	}
}