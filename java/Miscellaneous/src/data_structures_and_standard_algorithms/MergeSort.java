package data_structures_and_standard_algorithms;

import java.util.Arrays;

public class MergeSort {
	public void sort(int[] arr) {
		if(arr == null || arr.length < 2) return;
		int mid = arr.length / 2;
		int[] left = Arrays.copyOf(arr, mid);
		int[] right = Arrays.copyOfRange(arr, mid, arr.length);
		sort(left);
		sort(right);
		merge(arr, left, right);
	}
	private void merge(int[] arr, int[] left, int[] right) {
		int arrPointer = 0;
		int lPointer = 0;
		int rPointer = 0;
		while (lPointer < left.length && rPointer < right.length) {
			int lVal = left[lPointer];
			int rVal = right[rPointer];
			if(lVal <= rVal) {
				arr[arrPointer] = lVal;
				lPointer++;
			} else {
				arr[arrPointer] = rVal;
				rPointer++;
			}
			arrPointer++;
		}
		if(lPointer < left.length) {
			System.arraycopy(left, lPointer, arr, arrPointer, left.length - lPointer);
		} else {
			System.arraycopy(right, rPointer, arr, arrPointer, right.length - rPointer);
		}
	}
}
