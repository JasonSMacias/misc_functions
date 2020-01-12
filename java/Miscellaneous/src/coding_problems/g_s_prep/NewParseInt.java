package coding_problems.g_s_prep;

import java.math.BigInteger;
import java.util.Stack;

public class NewParseInt {
	//  Problem: implement your own version of parseInt()
	
	public static void main(String[] args) {
		System.out.println("Should be 112 " + newParseInt("112"));
		System.out.println("Should be 165412 + 1 : " + (newParseInt("165412") + 1));
		System.out.println("Should be -25:  " + newParseInt("-25"));
		/* System.out.println("Should throw exception with not an integer message" 
				+ newParseInt("114k")); */
		/* System.out.println("Should throw exception with number too large exception" 
				+ newParseInt("10000000000")); */
		System.out.println("Should be 125000:  " + newParseInt("125,000"));
		System.out.println("Should be 15000:  " + newParseInt("15_000"));
	}
	
	private static int newParseInt(String s) {
		
		// if first char is '-' flags number as negative
		boolean isNegative = false;
		if (s.charAt(0) == '-') {
			isNegative = true;
		}
		
		char[] cArr = s.toCharArray();
		//if is negative, ignores first character '-'
		int startIndex = isNegative ? 1 : 0;
		for (int i = startIndex; i < s.length(); i++) {
			// for non separator characters, changing char value to int equivalent of digit
			if (cArr[i] != '_' && cArr[i] != ',') cArr[i] -= '0';
			if (cArr[i] > 9 || cArr[i] < 0) {
				// exception for values outside of 1-9, ignoring ',' and '_'
				if (cArr[i] != '_' && cArr[i] != ',') {
					throw new NumberFormatException("String entered not an integer");
				}
			}
		}
		
		// number digits into stack for easy reverse read
		Stack<Character> cStack = new Stack<>();
		for (char c : cArr) {
			if (c != '-' && c != '_' && c != ',') cStack.push(c);
		}
		
		// one's place
		BigInteger num = BigInteger.valueOf(cStack.pop());
		// adding values for incrementing places
		long power = 10;
		for (int i = 0; i > -1; i++) {
			if(cStack.empty()) break;
			num = num.add(BigInteger.valueOf(cStack.pop() * power));
			power *= 10;
		}
		
		// back from bigint to check if number is too large
		// and flipping to negative if flagged
		int retVal = 0;
		try {
			retVal = num.intValueExact();
			if (isNegative) retVal *= -1;
		}
		catch (ArithmeticException e) {
			throw new NumberFormatException("Entered integer too large");
		}
		
		return retVal;
	}
	
}
