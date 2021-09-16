package adm.ch1.exercises;

import java.util.List;

// Insertion Sort
public class Exercise1 {
	public void insertionSort(List<Integer> listToSort) {
		System.out.println("Insertion Sort:");
		int i, j;
		for (i = 0; i < listToSort.size(); i++) {
			j = i;
			while (j > 0 && listToSort.get(j) < listToSort.get(j - 1)) {
				int jVal = listToSort.get(j);
				int prevVal = listToSort.get(j - 1);
				listToSort.set(j - 1, jVal);
				listToSort.set(j, prevVal);

				j--;
			}
		}
	}
}
