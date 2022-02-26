package data_structures_and_standard_algorithms;

import java.util.Arrays;

public class Driver {
	static QuickSort qs = new QuickSort();
	static MergeSort ms = new MergeSort();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] testArr1 = {4, 18, 47, 2, 99, 98, 12, -2, 84};
		int[] testArr2 = {3, 2, 1};
		int[] testArr3 = {6};
		int[] testArr4 = new int[0];
		int[] testArr5 = null;
		System.out.println(Arrays.toString(testArr1));
//		qs.sort(testArr1);
		ms.sort(testArr1);
		System.out.println(Arrays.toString(testArr1));
		
		System.out.println(System.lineSeparator() + "------------" + System.lineSeparator());
		
		System.out.println(Arrays.toString(testArr2));
		ms.sort(testArr2);
		System.out.println(Arrays.toString(testArr2));
		
		System.out.println(System.lineSeparator() + "------------" + System.lineSeparator());
		
		System.out.println(Arrays.toString(testArr3));
		ms.sort(testArr3);
		System.out.println(Arrays.toString(testArr3));
		
		System.out.println(System.lineSeparator() + "------------" + System.lineSeparator());
		
		System.out.println(Arrays.toString(testArr4));
		ms.sort(testArr4);
		System.out.println(Arrays.toString(testArr4));
		
		System.out.println(System.lineSeparator() + "------------" + System.lineSeparator());
		
		System.out.println(Arrays.toString(testArr5));
		ms.sort(testArr5);
		System.out.println(Arrays.toString(testArr5));
	}

}
