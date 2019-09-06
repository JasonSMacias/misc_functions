package cracking.ch1;

import java.util.Hashtable;

public class Question1_1 {
//	First attempt, O(n squared)
//	public boolean isUnique(String s) {
//		boolean unique = true;
//		for (int i = 0; i < s.length(); i++) {
//			char a = s.charAt(i);
//			for (int j = i + 1 ; j < s.length(); j++) {
//				char b = s.charAt(j);
//				if (a == b) {
//					unique = false;
//					break;
//				}
//			}
//		}
//		return unique;
//	}

//	Second attempt with hash table, worst case O(n)
	public boolean isUnique(String s) {
		boolean unique = true;
		Hashtable<Character, String> htable = new Hashtable<>();
		
		for (int i = 0; i < s.length(); i++) {
			Character charI = s.charAt(i);
			if (htable.isEmpty() || !htable.containsKey(charI)) {
				htable.put(charI, charI.toString());
			}
			else {
				unique = false;
				break;
			}
		}
		
		return unique;
	}
	
	/* 
	 * solution 1 from book 0(n)
	 * boolean isUniqueChars(String str) {
	 * if(str.length() > 128) return false;
	 * 
	 * boolean[] char_set = new boolean[128];
	 * 
	 * for (int i = 0; i < str.length(); i++) {
		 * int val = str.charAt(i);
		 * if (char_set[val]) { // this will be true if already found
		 * 		return false;
		 * }
		 * charset[val] = true;
		 * }
		 * return true;
		 * 
	 * }
	 * 
	 * */
	
	/* 
	 * second solution from book O(logn)
	 * 
	 * char[] charArr = s.toCharArray();
	 * Arrays.sort(charArr);
	 * String sorted = new String(charArr);
	 * 
	 * for (int i = 0; i < sorted.length; i++) {
	 * 	if (sorted.charAt(i).equals(sorted.charAt(i+1)) {
	 * 		return false;
	 * 	}
	 * }
	 * return true;
	 * */
	
}
