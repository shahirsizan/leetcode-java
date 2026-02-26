import java.util.Arrays;

public class QuickSort {
	
	public void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int partitionIdx = partition(arr, low, high);
			
			// recursively divide the array around the partition
			quickSort(arr, low, partitionIdx - 1);
			quickSort(arr, partitionIdx + 1, high);
		}
	}
	
	private int partition(int[] givenArr, int left, int right) {
		int pivotElement = givenArr[left];
		int i = left + 1;
		int j = right;
		
		while (i <= j) {
			
			while (i <= right && givenArr[i] <= pivotElement) {
				i++;
			}
			
			while (j > left && givenArr[j] > pivotElement) {
				j--;
			}
			
			if (i < j) {
				swap(givenArr, i, j);
			}
		}
		
		swap(givenArr, left, j);
		return j;
	}
	
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		QuickSort myObj = new QuickSort();
		int[] data = {19, 7, 15, 12, 16, 18, 4, 11, 13};
		
		System.out.println("Before sort: " + Arrays.toString(data));
		myObj.quickSort(data, 0, data.length - 1);
		System.out.println("After sort:   " + Arrays.toString(data));
	}
}