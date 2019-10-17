package cracking;
import cracking.ch1.*;

public class Driver {
	
	private static Question1_1 q1_1 = new Question1_1();
	private static Question1_2 q1_2 = new Question1_2();
	private static Question1_3 q1_3 = new Question1_3();
	private static Question1_4 q1_4 = new Question1_4();
	private static Question1_5 q1_5 = new Question1_5();
	private static Question1_6 q1_6 = new Question1_6();
	
	public static void main(String[] args) {
		// Question 1.1
		System.out.println("-------- Q1.1 -----------");
		String testString = "testt";
		String testString2 = "abcdefghijk";
		String testString3 = "teamst";
		System.out.println(q1_1.isUnique(testString));
		System.out.println(q1_1.isUnique(testString2));
		System.out.println(q1_1.isUnique(testString3));
		
		//Question 1.2
		System.out.println("-------- Q1.2 -----------");
		System.out.println("Testing two totally different strings  " + q1_2.isPermutation(testString, testString2));
		String testString4 = "abc";
		String testString5 = "bca";
		System.out.println("testing short permutations  " + q1_2.isPermutation(testString4, testString5));
		String str1 = "hello";
		String str2 = "ohelo";
		System.out.println("testing same length, non-permutation (but close) " + q1_2.isPermutation(str1, str2));
		String str3 = "maciassjason";
		String str4 = "jasonsmacias";
		System.out.println("testing longer permutation " + q1_2.isPermutation(str3, str4));
		
		// Question 1.3
		System.out.println("-------- Q1.3 ----------");
		String str5 = "Testing testing testing         ";
		String str6 = "Testingtestingtesting";
		String str7 = "This is a longer string with a bunch of spaces                           ";
		String str8 = "This is a string with more spaces than needed appended to the end                                          ";
		System.out.println(q1_3.urlify(str5, str5.length()));
		System.out.println(q1_3.urlify(str6, str6.length()));
		System.out.println(q1_3.urlify(str7, str7.length()));
		System.out.println(q1_3.urlify(str8, str8.length()));
		
		// Question 1.4
		System.out.println("-------- Q1.4 ----------");
		String str9 = "taco cat";
		String str10 = "at cocat";
		String str11 = "not a palindrome";
		String str12 = "Racecar";
		System.out.println("Testing a palindrome: "+q1_4.isPermutationOfPalindrome(str9));
		System.out.println("Testing a permutation of a palindrome: "+q1_4.isPermutationOfPalindrome(str10));
		System.out.println("Testing a non-palindrome: "+q1_4.isPermutationOfPalindrome(str11));
		System.out.println("Testing a palindrome with capital letter: "+q1_4.isPermutationOfPalindrome(str12));
		
		// Question 1.5
		System.out.println("-------- Q1.5 ----------");
		System.out.println();
		String[] arr1 = {"", "j", "jason", "ignatius", "heo", "hex", "heo", 
				"check","check", "chek", "check", "check", "howareyou?", "test", "sparta",
				"jason", "whatsup", "bluejay", "harrow", "sparrow"};
		String[] arr2 = {"", "jjjj", "jxasxon", "inatus", "hello", "hello", "hella", 
				"chek", "clek", "check", "diek", "dhek", "howersyou!", "test", "spanti",
				"jasom", "phamsum", "blejayn", "hrrwxv", "sarojnx"};
		boolean[] expected = {true, false, true, true, true, false, false, 
				true, true, true, false, true, false, true, true,
				true, false, true, false, false, false};
		for (int i = 0; i < arr1.length; i++) {
			System.out.print("Testing strings " + i + ", expecting " + expected[i]);
			System.out.print(":  " + q1_5.oneOrTwoAway(arr1[i], arr2[i]) + "\n");
			System.out.println(arr1[i] + " - " + arr2[i]);
		}
		
		// Question 1.6
		System.out.println("-------- Q1.6 ----------");
		System.out.println();
		String[] inputs = {"s", "ssss", "sssyyy", "syyyzzz", "pppppppppppppppppppp",
				"ppxxzzaa", "ppxxxzzaa"};
		String[] expected2 = {"s", "s4", "s3y3", "sy3z3", "p20",
				"ppxzzaa", "p2x3z2a2"};
		for (int i = 0; i < inputs.length; i++) {
			System.out.println("Testing string #" + (i + 1) + ", " + inputs[i] + " expecting " + expected2[i]);
			System.out.println("\t"+ q1_6.compressString(inputs[i]));
		}
	}

}
