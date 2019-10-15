package cracking.ch1;

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
			// TODO finish same length code
			return false;
		}
		
		// difference of one, one insert or remove must have occurred, only one more allowed
		else if(Math.abs(str1.length() - str2.length()) == 1) {
			String longer = str1.length() > str2.length() ? str1 : str2;
			String shorter = str1.length() < str2.length() ? str1 : str2;
			int diff = 0;
			int charChanges = 0;
			for (int i = 0; i < shorter.length(); i++) {
				// TODO finish code here for checking strings with a difference of 1
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
