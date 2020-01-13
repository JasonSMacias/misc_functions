package coding_problems.g_s_prep;

public class OverlappingRectangles {
// https://practice.geeksforgeeks.org/problems/overlapping-rectangles/0
	/*
	Given two rectangles, find if the given two rectangles overlap or not. A rectangle is 
	denoted by providing the x and y co-ordinates of two points: the left top corner and 
	the right bottom corner of the rectangle. Two rectangles sharing a side are considered 
	overlapping.
	Note : It may be assumed that the rectangles are parallel to the coordinate axis.
	
	Each rectangle array consists of 4 integers: denoting the co-ordinates of the upper 
	left and lower right points
	 * */
	public static void main(String[] args) {
		int[] test1a = {0, 10, 10, 0};
		int[] test1b = {5, 5, 15, 0};
		int[] test2a = {0, 2, 1, 1};
		int[] test2b = {-2, -3, 0, 2};
		
		System.out.println(
				"Expect true: " + doTheyOverlap(test1a, test1b) +"\n" +
				"Expect false: " + doTheyOverlap(test2a, test2b)
				);
	}
	
	private static boolean doTheyOverlap(int[] rect1, int[] rect2) {
		int r1Lx = rect1[0]; //0
		int r1Ly = rect1[1]; //10
		int r1Rx = rect1[2]; //10
		int r1Ry = rect1[3]; //0
		int r2Lx = rect2[0]; //5
		int r2Ly = rect2[1]; //5
		int r2Rx = rect2[2]; //15
		int r2Ry = rect2[3]; //0
		
		boolean overlap = false;
		if ((r1Lx < r2Lx && r2Lx < r1Rx) 
				&& (r1Ly > r2Ly && r2Ly > r1Ry)) {
			overlap = true;
		}
		if ((r1Lx < r2Rx && r2Rx < r1Rx) 
				&& (r1Ly > r2Ry && r2Ry > r1Ry)) {
			overlap = true;
		}
		if ((r1Lx < r2Lx && r2Lx < r1Rx) 
				&& (r1Ly > r2Ry && r2Ry > r1Ry)) {
			overlap = true;
		}
		if ((r1Lx < r2Rx && r2Rx < r1Rx) 
				&& (r1Ly > r2Ly && r2Ly > r1Ry)) {
			overlap = true;
		}
		return overlap;
	}
}
