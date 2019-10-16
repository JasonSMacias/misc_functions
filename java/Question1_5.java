package cracking.ch1;

import java.util.Arrays;

public class Question1_5 {
	// My first solution
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
}
