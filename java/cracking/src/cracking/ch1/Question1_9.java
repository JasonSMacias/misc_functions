package cracking.ch1;

// assume that you have a method called 'isSubstring' that checks to see whether a string
// is a subString of another.
// Given two strings s1 and s2, write code that checks to see if s2 is a rotation of s1
// using only one call to isSubstring.  i.e. "waterbottle" is a rotation of erbottlewat"
public class Question1_9 {
	// first attempt, see if beginning of s1 is at end of s2, if so checking rest of s1 to see if it is
	// a substring of s2.  O(n)
	public boolean isRotation(String s1, String s2) {
		if (s1.length() != s2.length()) return false;
		if(s1.equals(s2)) return true; 
		int s1Index = 0;
		int s2Index = 0;
		int rotationPoint = -1;
		String remainingString = "";
		OUTER: while(rotationPoint < 0 && s2Index < s2.length()) {
			if (s1.charAt(s1Index) != s2.charAt(s2Index)) s2Index++;
			else {
				for (int i = s2Index; i < s2.length(); i++, s1Index++) {
					if(s1.charAt(s1Index) != s2.charAt(i)) {
						s2Index = i;
						s1Index = 0;
						continue OUTER;
					}
				}
				rotationPoint = s2Index;
			}
		}
		if(rotationPoint < 0) return false;
		System.out.println(remainingString);
		remainingString = s1.substring(s1Index + 1);
		return isSubstring(remainingString, s2);
	}
	
	// another implementation after reading hints, concatenating s2 with 
	// itself (aterbottlewaterbottlewat) and checking if it contains s1 as a substring
	// This is still O(n) because of isSubstring, but much more concise
	public boolean isRotationAlgo(String s1, String s2) {
		if(s1.length() != s2.length() || s1.length() < 2) return false;
		if (s1.equals(s2)) return true;
		String doubleS2 = s2 + s2;
		return isSubstring(s1, doubleS2);
	}
	
	private boolean isSubstring(String substr, String str) {
		if (substr.length() < 1) return false;
		return str.contains(substr);
	}
}
