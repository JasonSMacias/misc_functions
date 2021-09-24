package adm.ch1.exercises;

import java.util.*;

// Problem: movie scheduling problem
// Input: A set of n intervals on a timeline (representing shooting times)
// Output: Largest subset of mutually non-overlapping intervals which can be selected from the set

public class Exercise2 {
	public List<int[]> scheduleMovies(List<int[]> availableMovies) {
		List<int[]> returnList = new ArrayList<>();
		while(!availableMovies.isEmpty()) {
			int indexOfLowest = -1;
			int lowestLastDate = Integer.MAX_VALUE;
			for (int i = 0; i < availableMovies.size(); i++) {
				if (availableMovies.get(i)[1] < lowestLastDate) {
					lowestLastDate = availableMovies.get(i)[1];
					indexOfLowest = i; 
				}
			}
			int[] addedArr = availableMovies.get(indexOfLowest);
			returnList.add(addedArr);
			availableMovies.remove(addedArr);
			for (int i = availableMovies.size() - 1; i > -1; i--) {
				int[] currentArr = availableMovies.get(i);
				if (addedArr[0] < currentArr[1] && addedArr[1] > currentArr[0]) {
					availableMovies.remove(i);
				}
			}
		}

		return returnList;
	}

	public void test() {
		List<int[]> list = new ArrayList<>();
		int[] arr1 = {2, 3};
		int[] arr2 = {5, 6};
		int[] arr3 = {1, 7};
		int[] arr4 = {8, 10};
		list.add(arr1);
		list.add(arr2);
		list.add(arr3);
		list.add (arr4);
		System.out.println("Original: ");
		for (int[] arr : list) {
			System.out.println(Arrays.toString(arr));
		}
		List<int[]> output = scheduleMovies(list);
		System.out.println("Output: ");
		for (int[] arr : output) {
			System.out.println(Arrays.toString(arr));
		}
	}
}
