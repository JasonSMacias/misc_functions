package coding_problems.g_s_prep;

import java.math.BigInteger;
import java.util.Stack;

public class NewParseInt {
	//  Problem: implement your own version of parseInt()
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Should be 112 " + newParseInt("112"));
		System.out.println("Should be 165412 + 1 : " + (newParseInt("165412") + 1));
	}
	
	private static int newParseInt(String s) {
		
		char[] cArr = s.toCharArray();
		for (int i= 0; i < s.length(); i++) {
			cArr[i] -= '0';
			if (cArr[i] > 9) {
				throw new NumberFormatException();
			}
		}
		
		Stack<Character> cStack = new Stack<>();
		for (char c : cArr) {
			cStack.push(c);
		}
		
		BigInteger num = BigInteger.valueOf(cStack.pop());
		long power = 10;
		for (int i = 0; i > -1; i++) {
			if(cStack.empty()) break;
			num = num.add(BigInteger.valueOf(cStack.pop() * power));
			power *= 10;
		}
		int retVal = 0;
		
		try {
			retVal = num.intValueExact();
		}
		catch (ArithmeticException e) {
			throw new NumberFormatException();
		}
		
		return retVal;
	}
	
}
