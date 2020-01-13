package coding_problems.g_s_prep;

import java.util.Stack;

public class ReverseStringNotWords {
	
	// https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string/0
	/* 
	 * Given a String of length S, reverse the whole string without reversing the 
	 * individual words in it. Words are separated by dots.
	 * */
	// Trickier than expected because "." is a special regex character that needs
	// to be escaped

	public static void main(String[] args) {
		String s1 = "Hello.how.are.you?.I'm.well.thank.you";
		String s2 = "Testing with.spaces, punctuation.etc.etc";
		System.out.println(
				reverseWords(s1) + "\n" + reverseWords(s2)
				);
		
	}
	
	private static String reverseWords(String s) {
		String[] cArr = s.split("\\.");
		Stack<String> stk = new Stack<>();
		for (String word : cArr) {
			stk.push(word);
		}
		StringBuilder sb = new StringBuilder(stk.pop() + ".");
		while (!stk.empty()) {
			sb.append(stk.pop() + ".");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
	
}
