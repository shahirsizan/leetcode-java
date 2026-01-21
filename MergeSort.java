public class MergeSort {
	
	public static void mergeSort(int[] arr, int left, int right) {
		// base case: If left >= right, the sub-array has 0 or 1 element, return.
		if (left >= right) {
			return;
		}
		// if more than one element, divide them
		else {
			int mid = left + (right - left) / 2;
			
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			
			// merge them by sending all related info: array itself, (left, mid, right) pointers etc
			merge(arr, left, mid, right);
		}
	}
	
	
	private static void merge(int[] arr, int left, int mid, int right) {
		// Determine the sizes of the two sub-arrays
		int size1 = mid - left + 1;
		int size2 = right - mid;
		
		// Create temporary arrays
		int[] L = new int[size1];
		int[] R = new int[size2];
		
		// Copy data to temp arrays L[] and R[]
		for (int i = 0; i < size1; ++i) {
			L[i] = arr[left + i];
		}
		for (int j = 0; j < size2; ++j) {
			R[j] = arr[mid + 1 + j];
		}
		
		// Merge the temp arrays back into arr[left...right]
		int i = 0, j = 0; // Initial index of first and second sub-arrays
		int k = left;     // Initial index of merged sub-array
		
		// Compare elements from L and R and place the smaller one into arr
		while (i < size1 && j < size2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		
		// Copy remaining elements of L[] if any
		while (i < size1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		
		// Copy remaining elements of R[] if any
		while (j < size2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
	
	// main
	public static void main(String[] args) {
		int[] data = {12, 11, 13, 5, 6, 7};
		System.out.println("Original Array:");
		printArray(data);
		
		mergeSort(data, 0, data.length - 1);
		
		System.out.println("\nSorted Array:");
		printArray(data);
	}
	
	private static void printArray(int[] arr) {
		for (int element : arr) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
	
	
}