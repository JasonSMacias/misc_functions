package data_structures_and_standard_algorithms;

import java.util.Arrays;

public class Driver {
	static QuickSort qs = new QuickSort();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] testArr1 = {4, 18, 47, 2, 99, 98, 12, -2, 84};
		System.out.println(Arrays.toString(testArr1));
		qs.sort(testArr1);
		System.out.println(Arrays.toString(testArr1));
	}

}
