package cracking.ch1;

import java.util.*;


/* 
 * 1.8 - Zero Matrix
 * Write an algorithm such that if an element in an MxN is 0, it's
 * entire row an column are set to 0
 * */
public class Question1_8 {
	public int[][] zeroMatrix(int[][] matrix) {
		Set<Integer> rows = new HashSet<>();
		Set<Integer> cols = new HashSet<>();
		// noting row and column indexes for zero entries
		for (int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}
		// zeroing out rows with a zero index
		for (Integer i : rows) {
			Arrays.fill(matrix[i], 0);
		}
		// zeroing out columns with a zero index
		for (int[] arr : matrix) {
			for (Integer i : cols) {
				arr[i] = 0;
			}
		}
		
		return matrix;
	}
	
	public void printMatrix(int[][] m) {
		for (int[] row : m) {
			for (int i = 0; i < row.length; i++) {
				System.out.print(row[i] + "\t");
			}
			System.out.println();
		}
		System.out.println("------------------");
	}
	
	public int[][] createRandomMatrix(int size) {
		int[][] m = new int[size][size];
		for (int[] row : m) {
			for (int i = 0; i < row.length; i++) {
				row[i] = (int) (Math.random() * 10);
			}
		}
		return m;
	}
	
	public int[][] createTestMatrix() {
		int[][] m = new int[6][6];
		for (int[] row : m) {
			Arrays.fill(row, 1);
		}
		m[0][3] = 0;
		m[4][0] = 0;
		return m;
	}
}
