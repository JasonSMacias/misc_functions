package cracking.ch1;

import java.util.Arrays;

public class Question1_4 {
	
	// My first solution, O(n) time, using an array
//	public boolean isPermutationOfPalindrome(String str) {
//		boolean isPOP = true;
//		char[] sorted = str.toCharArray();
//		for (int i = 0; i < sorted.length; i++) {
//			if (Character.isUpperCase(sorted[i])) {
//				sorted[i] = Character.toLowerCase(sorted[i]);
//			}
//		}
//		Arrays.sort(sorted);
//		if(sorted.length < 1) {return false;}
//		int skipIndex = -1;
//		char unmatched = '\u0000';
//		Outer: for(int i = 0; i < sorted.length -1; i++) {
//			if (i==skipIndex || sorted[i] == ' ') {continue;}
//			if (sorted[i] == sorted[i + 1]) {
//				skipIndex = i+1;
//			}
//			else {
//				if (unmatched == '\u0000') {
//					unmatched = sorted[i];
//				}
//				else {
//					isPOP = false;
//					break Outer;
//				}
//			}
//		}
//		return isPOP;
//	}
	
	// First book solution, using hash table to count how many  times each character
	// appears, then iterate through it to make sure no more than one character has a odd 
	// count (i.e. able to be pairs) Takes O(n) (same time complexity, but less space 
	// complexity than mine)
//	public boolean isPermutationOfPalindrome(String str) {
//		int[] table = buildCharFrequencyTable(str);
//		return checkMaxOneOdd(table);
//	}
//	/* check that no more than one character has an odd count*/
//	boolean checkMaxOneOdd(int[] table) {
//		boolean foundOdd = false;
//		for (int count : table) {
//			if(count % 2 == 1) {
//				if(foundOdd) {
//					return false;
//				}
//				foundOdd = true;
//			}
//		}
//		return true;
//	}
//	
//	/* map each character to a number (a->0 b->1, etc), case insensitive, non-letter characters map to -1 */
	int getCharNumber(Character c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if (a <= val && val <=z) {
			return val -a;
		}
		return -1;
	}
//	
//	int[] buildCharFrequencyTable(String phrase) {
//		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') +1];
//		for (char c : phrase.toCharArray()) {
//			int x = getCharNumber(c);
//			if(x != -1) {
//				table[x]++;
//			}
//		}
//		return table;
//	}
	
	/*  Second book solution, like above, but checking for odd values along the way
	 * uses a function from previous solution 
	 * (same time complexity, but somewhat more efficient)*/
	public boolean isPermutationOfPalindrome(String str) {
		int countOdd = 0;
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for(char c : str.toCharArray()) {
			int x = getCharNumber(c);
			if(x != -1) {
				table[x]++;
				if(table[x] % 2 == 1) {
					countOdd++;
				}
				else {
					countOdd--;
				}
			}
		}
		return countOdd <= 1;
	}
	
	/* The third book solution is essentially the same, but uses bitwise operators,
	 * setting up a bit vector, toggling appropriate ones for each instance of a character,
	 * and checking to make sure not more than one is odd*/
	
	/* 
	 * boolean isPermutationOfPalindrome(String phrase) {
	 * 		int bitVector = createBitVector(phrase);
	 *  	return bitVector == 0 || checkExactlyOneBitSet(bitVector);
	 * }
	 * 
	 *  	// create a bit vector for the string.  For each letter with value i, toggle the
	 *  	// ith bit.
	 *  int createBitVector(String phrase) {
	 *  	int bitVector = 0;
	 *  	for (char c : phrase.toCharArray()) {
		 *  	int x = getCharNumber(c);
		 *  	bitVector = toggle(bitVector, x);
	 *  	}
	 *  }
	 *  
	 *  	// Toggle the ith bit in the integer.
	 *  int toggle(int bitVector, int index) {
	 *  	if (index < 0) return bitVector;
	 *  	
	 *  	int mask = 1 << index;
	 *  	if((bitVector & mask) == 0) {
	 *  		bitVector |= mask;
	 *  	}
	 *  	else {
	 *  		bitVector &= ~= mask;
	 *  	}
	 *  }
	 * */
}
