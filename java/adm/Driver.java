package adm;

import adm.ch1.exercises.*;
import java.util.*;

public class Driver {
	private static Exercise1 e1 = new Exercise1();
	public static void main(String[] args) {
		Integer[] arr = new Integer[] {5, 3, 1, 99, 16, 12, 1};
		List<Integer> list = new ArrayList<>(Arrays.asList(arr));
		e1.insertionSort(list);
		System.out.println(list.toString());
	}
}
