package data_structures_and_standard_algorithms;

public class QuickSort {
	public void sort(int[] arr) {
		sortHelper(arr, 0, arr.length - 1);
	}
	private void sortHelper(int[] arr, int startIndex, int endIndex) {
		if(!(startIndex < endIndex)) return;
		int partitionIndex = partitionArr(arr, startIndex, endIndex);
		sortHelper(arr, startIndex, partitionIndex - 1);
		sortHelper(arr, partitionIndex + 1, endIndex);
	}
	private int partitionArr(int[] arr, int startIndex, int endIndex) {
		int pivotVal = arr[endIndex];
		int pivotIndex = startIndex - 1;
		// partition arr and index location of pivot val
		for(int i = startIndex; i <= endIndex - 1; i++) {
			if(arr[i] < pivotVal) {
				pivotIndex++;
				int tmp = arr[i];
				arr[i] = arr[pivotIndex];
				arr[pivotIndex] = tmp;
			}
		}
		int tmp = arr[pivotIndex + 1];
		arr[pivotIndex + 1] = arr[endIndex];
		arr[endIndex] = tmp;
		
		return pivotIndex + 1;
	}
}
