package cracking.ch1;

public class Question1_6 {
	// My initial solution
	public String compressString(String s) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while(i < s.length()) {
			char c = s.charAt(i);
			int numRepChar = 1;
			INNER: for (int j = i + 1; j < s.length(); j++) {
				if (j >= s.length() || c != s.charAt(j)) {
					break INNER;
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
		if (retStr.length() == s.length()) {
			return s;
		}
		return retStr;
	}
}
