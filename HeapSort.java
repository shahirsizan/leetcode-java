// done
/**
 * performance analysis
 * time complexity (phase 1, build heap):
 * O(nlogn) (since each of the `n` insertions can take at most `logn` swaps).
 * time complexity (phase 2, fix heap after extracting head):
 * O(nlogn) (each of the `n` head extractions takes `logn` to fix).
 * Overall: O(NlogN).
 * Space Complexity: O(1) (In-place).
 */

import java.util.Arrays;

public class HeapSort {
	
	public void sort(int[] givenArr) {
		int arrayLen = givenArr.length;
		
		// phase 1: build the Max-Heap (Sift-Up approach)
		for (int currIdx = 0; currIdx < arrayLen; currIdx++) {
			buildHeap(givenArr, currIdx);
		}
		
		// phase 2: extract head element from the max-heap one by one and put it at the
		// end of the list. After final swap, we'll get the sorted array.
		for (int i = arrayLen - 1; i > 0; i--) {
			// swap current root (largest) with the current last, `i`th element
			int temp = givenArr[0];
			givenArr[0] = givenArr[i];
			givenArr[i] = temp;
			
			// heap property is violated. Need to fix root again.
			reBuildHeap(givenArr, i, 0);
		}
	}
	
	// insert new element.
	private void buildHeap(int[] givenArr, int currIdx) {
		// compare with `current parent` and swap if parent is smaller.
		while (currIdx > 0) {
			int parentIndex = (currIdx - 1) / 2;
			
			if (givenArr[currIdx] > givenArr[parentIndex]) {
				// swap
				int temp = givenArr[currIdx];
				givenArr[currIdx] = givenArr[parentIndex];
				givenArr[parentIndex] = temp;
				
				currIdx = parentIndex;
			} else {
				break;
			}
		}
	}
	
	// rebuild heap after root is taken out
	private void reBuildHeap(int[] givenArr, int currHeapLastIdx, int currRootIdx) {
		while (true) {
			int largest = currRootIdx;
			int left = 2 * currRootIdx + 1;
			int right = 2 * currRootIdx + 2;
			
			if (left < currHeapLastIdx && givenArr[left] > givenArr[largest]) {
				largest = left;
			}
			if (right < currHeapLastIdx && givenArr[right] > givenArr[largest]) {
				largest = right;
			}
			
			if (largest != currRootIdx) {
				// swap
				int temp = givenArr[currRootIdx];
				givenArr[currRootIdx] = givenArr[largest];
				givenArr[largest] = temp;
				
				currRootIdx = largest;
			} else {
				break;
			}
		}
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		HeapSort myObj = new HeapSort();
		int[] data = {12, 36, 24, 48, 5, 10};
		
		System.out.println("Before heap sort: " + Arrays.toString(data));
		myObj.sort(data);
		System.out.println("After heap sort:   " + Arrays.toString(data));
	}
}



