package cracking.ch1;

public class Question1_7 {
	// Matrix creation method
	public byte[][] createMatrix(int n) {
		byte[][] m = new byte[n][n];
		int counter = 0;
		for (byte[] row : m) {
			for (int i = 0; i < row.length; i++) {
				row[i] = (byte) counter;
//				System.out.print(counter + "\t");
				counter++;
			}
//			System.out.println();
		}
//		System.out.println("------------------");
		return m;
	}
	public void printMatrix(byte[][] m) {
		for (byte[] row : m) {
			for (int i = 0; i < row.length; i++) {
				System.out.print(row[i] + "\t");
			}
			System.out.println();
		}
		System.out.println("------------------");
	}
	// Initial solution, maybe not what the book will use
	public byte[][] rotateMatrix(byte[][] m) {
		byte[][] rotated = new byte[m.length][m.length];
		int line = m.length -1;
		for (byte[] row : m) {
			for(int i = 0; i < m.length; i++) {
				rotated[i][line] = row[i];
			}
			line--;
		}
		return rotated;
	}
	
	//  Book solution, working from the outside, in.  In this version, it is done index
	//  by index, so that no extra array is used to store temporary value (in place)
	public boolean rotateMatrixBook(byte[][] matrix) {
		if (matrix.length == 0 || matrix.length != matrix[0].length) return false;
		int n = matrix.length;
		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; i++) {
				int offset = i - first;
				int top = matrix[first][i]; // Save top
				// left -> top
				matrix[first][i] = matrix[last-offset][first];
				// bottom -> left
				matrix[last-offset][first] = matrix[last][last-offset];
				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];
				// top -> right
				matrix[i][last] = (byte)top; // right <- saved top
			}
		}
		return true;
	}
}
