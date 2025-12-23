import java.util.Arrays;

public class MergeSortPractice {
	
	public void sort(int[] arr, int left, int right) {
		if (left < right) {
			// Find the middle point
			int mid = left + (right - left) / 2;
			
			// Sort first and second halves
			sort(arr, left, mid);
			sort(arr, mid + 1, right);
			
			// Merge the sorted halves
			merge(arr, left, mid, right);
		}
	}
	
	private void merge(int[] arr, int left, int mid, int right) {
		// Find sizes of two subarrays to be merged
		int leftArraySize = mid - left + 1;
		int rightArraySize = right - mid;
		
		// Create temporary arrays
		int[] leftArray = new int[leftArraySize];
		int[] rightArray = new int[rightArraySize];
		
		// Copy data to temp arrays
		for (int i = 0; i < leftArraySize; ++i) {
			leftArray[i] = arr[left + i];
		}
		for (int j = 0; j < rightArraySize; ++j) {
			rightArray[j] = arr[mid + 1 + j];
		}
		
		// Merge the temp arrays
		int i = 0, j = 0;
		int k = left; // Initial index of merged subarray
		
		while (i < leftArraySize && j < rightArraySize) {
			if (leftArray[i] <= rightArray[j]) {
				arr[k] = leftArray[i];
				i++;
			} else {
				arr[k] = rightArray[j];
				j++;
			}
			k++;
		}
		
		// Copy remaining elements of L[] if any
		while (i < leftArraySize) {
			arr[k] = leftArray[i];
			i++;
			k++;
		}
		
		// Copy remaining elements of R[] if any
		while (j < rightArraySize) {
			arr[k] = rightArray[j];
			j++;
			k++;
		}
	}
	
	// ✅ Main Method ✅
	public static void main(String args[]) {
		MergeSortPractice myObj = new MergeSortPractice();
		int[] arr = {12, 11, 13, 5, 6, 7};
		
		System.out.println("Original Array: " + Arrays.toString(arr));
		myObj.sort(arr, 0, arr.length - 1);
		System.out.println("Sorted Array:   " + Arrays.toString(arr));
		
		int[] arr2 = {3, -1, 5, 3, 0};
		myObj.sort(arr2, 0, arr2.length - 1);
		System.out.println("Sorted Array 2: " + Arrays.toString(arr2));
	}
}