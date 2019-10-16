package cracking.ch1;

import java.util.Arrays;

public class Question1_5 {
	// My first solution -- note, I thought that the instructions were to check whether
	// the strings were one OR two edits away from one another, but in fact, it should have
	// been just ONE edit away.  It would have been much easier to do that.
	public boolean oneOrTwoAway(String str1, String str2) {
		// strings are the same, 0 changes needed
		if(str1.equals(str2)) {
			return true;
		}
		// strings are over two characters different in 
		if (Math.abs(str1.length() - str2.length()) > 2) {
			return false;
		}
		
		// strings are the same length
		else if(Math.abs(str1.length() - str2.length()) == 0) {
			// check to see if the second string contains all but 2 of the characters in first
			int changes = 0;
			int offset = 0;
			char[] ch1 = str1.toCharArray();
			char[] ch2 = str2.toCharArray();
			Arrays.sort(ch1);
			Arrays.sort(ch2);
			for (int i = 0; i < ch1.length; i++) {
				if (str1.charAt(i) == str2.charAt(i + offset)) {
					continue;
				}
				else {
					if (i + 1 < str2.length() && str1.charAt(i) == str2.charAt(i + 1) ) {
						offset++;
						if (++changes > 2) {
							return false;
						}
					}
					else if (i + 2 < str2.length() && str1.charAt(i) == str2.charAt(i + 2)) {
						offset +=2;
						changes += 2;
						if (changes > 2) {
							return false;
						}
					}
					else {
						if (++changes > 2) {
							return false;
						}
						if (i + 1 < str1.length() && str1.charAt(i + 1) == str2.charAt(i)) {
							offset--;
						}
					}
				}
			}
			// TODO finish same length code
			return true;
		}
		
		// difference of one, one insert or remove must have occurred, only one more allowed
		else if(Math.abs(str1.length() - str2.length()) == 1) {
			String longer = str1.length() > str2.length() ? str1 : str2;
			String shorter = str1.length() < str2.length() ? str1 : str2;
			int diff = 0;
			int charChanges = 0;
			for (int i = 0; i < shorter.length(); i++) {
				if(shorter.charAt(i) == longer.charAt(i + diff)) {
					continue;
				}
				else {
					if(shorter.charAt(i) == longer.charAt(i + diff + 1)) {
						if (++diff > 2) {
							return false;
						}
						continue;
					}
					else if(shorter.charAt(i) == longer.charAt(i + diff + 2)) {
						diff += 2;
						if (diff > 2) {
							return false;
						}
						continue;
					}
					else {
						if (++charChanges > 1) {
							return false;
						}
						continue;
					}
				}
			}
			return true;
		}
		// two inserts or removes, no further changes allowed
		else {
			String longer = str1.length() > str2.length() ? str1 : str2;
			String shorter = str1.length() < str2.length() ? str1 : str2;
			int diff = 0;
			for(int i = 0; i < shorter.length(); i++) {
				if(shorter.charAt(i) == longer.charAt(i + diff)) {
					continue;
				}
				else {
					if(++diff > 2) {
						return false;
					}
					if (shorter.charAt(i) == longer.charAt(i + diff)) {
						continue;
					}
					else {
						if(++diff > 2) {
							
							return false;
						}
						if (shorter.charAt(i) != longer.charAt(i + diff)) {
							return false;
						}
						continue;
					}
				}
			}
			return true;
		}
	}
	
	public boolean oneEditAway(String first, String second) {
		/* This is the book's implementation of the solution
		 * Note: my solution above is for a harder problem (I misread the instructions)
		 * This solution just checks to see if strings are within one edit (not two) 
		 * No test cases written*/
		
		if(first.length() == second.length()) {
			return oneEditReplace(first, second);
		}
		else if (first.length() + 1 == second.length()) {
			return oneEditInsert(first, second);
		}
		else if (first.length() -1 == second.length()) {
			return oneEditInsert(second, first);
		}
		
		return false;
	}
	
//	checks for more than one replacement
	boolean oneEditReplace(String s1, String s2) {
		boolean foundDifference = false;
		for(int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (foundDifference) {
					return false;
				}
				foundDifference = true;
			}
		}
		return true;
	}
	
//	checks to see if you can insert a character into s1 to make s2
	boolean oneEditInsert(String s1, String s2) {
		int index1 = 0;
		int index2 = 0;
		while (index2 < s2.length() && index1 < s1.length()) {
			if (s1.charAt(index1) != s2.charAt(index2)) {
				if (index1 != index2) {
					return false;
				}
				index2++;
			}
			else {
				index1++;
				index2++;
			}
		}
		
		return true;
	}
	
	/* -------Second book solution, combining oneEditInstert and oneEdit replace into
	 * following method (like my own implementation, but for 1)
	 * This solution variation is not necessarily better, just more compact, but possibly 
	 * less readable */
//	boolean oneEditAway(String first, String second) {
////		length checks
//		if (Math.abs(first.length() - second.length()) > 1) {
//			return false;
//		}
////		get shorter and longer string
//		String s1 = first.length() < second.length() ? first : second;
//		String s2 = first.length() < second.length() ? second : first;
//		int index1 = 0;
//		int index2 = 0;
//		boolean foundDifference = false;
//		while (index2 < s2.length() && index1 < s1.length()) {
//			if (s1.charAt(index1) != s2.charAt(index2)) {
////				Ensure that this is the first difference found
//				if(foundDifference) {
//					return false;
//				}
//				foundDifference = true;
//				if(s1.length() == s2.length() ) { // on replace move shorter pointer
//					index1++;
//				}
//			}
//			else {
//				index1++;
//			}
//			index2++; // always move pointer for longer string
//		}
//		return true;
//	}
}
