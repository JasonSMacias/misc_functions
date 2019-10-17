package cracking.ch1;

public class Question1_6 {
	// My initial solution
	public String compressString(String s) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while(i < s.length()) {
			char c = s.charAt(i);
			int numRepChar = 1;
			for (int j = i + 1; j < s.length(); j++) {
				if (j >= s.length() || c != s.charAt(j)) {
					break;
				}
				else {
					numRepChar++;
				}
			}
			i += numRepChar;
			sb.append("" + c + (numRepChar > 1 ? numRepChar : ""));
		}
		String retStr = sb.toString();
		// returning original string in case where new string is no shorter than input
		
		return retStr.length() < s.length() ? retStr : s;
	}
	
	public String compressStringBookSolution(String str) {
		/*This is the book's solution, basically the same as mine, but implemented
		 * slightly differntly*/
		StringBuilder compressed = new StringBuilder();
		int countConsecutive = 0;
		for (int i = 0; i < str.length(); i++) {
			countConsecutive++;
			// if next char is different than current, append this char to result
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressed.append(str.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressed.length() < str.length() ? compressed.toString() : str;
	}
}
