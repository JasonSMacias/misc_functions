package cracking.ch1;

import java.util.Arrays;

public class Question1_2 {
	
	// 1st solution - check length equality first, then break into char array, sort, join, and compare equality. O(n log n)?
	public boolean isPermutation(String s1, String s2) {
		boolean result = false;
		
		if(s1.length() != s2.length()) {
			return result;
		}
		
		else {
			char[] s1Arr = s1.toCharArray();
			char[] s2Arr = s2.toCharArray();
			Arrays.sort(s1Arr);
			Arrays.sort(s2Arr);
			if (String.join("", new String(s1Arr)).equals(String.join("", new String(s2Arr)))) {
				result = true;
			}
		}
		
		return result;
		// Alternate solution that uses more space to get result of O(n) using a hash-table-like 
		// that checks whether they both have identical character counts
		/* 
		 * 
		 * public boolean isPermutation(String s1, String s2) {
		 * 	if (s1.length() != s2.length()) {
		 * 		return false;
		 * 	}
		 * 	
		 * 	int[] letters = new int[256];
		 * 	
		 * 	for (int i = 0; i < s1.length(); i++) {
		 * 		letters[s.charAt(i)]++;
		 * 	}
		 * 
		 * 	for (int i = 0; i < s2.length; i++) {
		 * 		letters[s2.charAt(i)]--;
		 * 		if (letters[s2.charAt(i)] < 0] {
		 * 			return false;
		 * 		}
		 * 	}
		 * 
		 * return true;
		 * 
		 * }
		 * 
		 * */
		
	}
}
