package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import cracking.ch1.*;




class TestCh1 {
	Question1_1 q1_1 = new Question1_1();
	Question1_2 q1_2 = new Question1_2();
	Question1_3 q1_3 = new Question1_3();
	Question1_4 q1_4 = new Question1_4();
	Question1_5 q1_5 = new Question1_5();
	Question1_6 q1_6 = new Question1_6();
	Question1_7 q1_7 = new Question1_7();
	Question1_8 q1_8 = new Question1_8();
	Question1_9 q1_9 = new Question1_9();
	
	@Test
	void test1_1() {
		String testString = "testt";
		String testString2 = "abcdefghijk";
		String testString3 = "teamst";
		assertFalse(q1_1.isUnique(testString));
		assertTrue(q1_1.isUnique(testString2));
		assertFalse(q1_1.isUnique(testString3));
	}
	
	@Test
	void test1_2() {
		assertFalse(q1_2.isPermutation("oneString", "AVeryDifferentString"));
		String s1 = "abc";
		String s2 = "bca";
		assertTrue(q1_2.isPermutation(s1, s2));
		String str1 = "hello";
		String str2 = "ohelo";
		assertFalse(q1_2.isPermutation(str1, str2));
		String str3 = "maciassjason";
		String str4 = "jasonsmacias";
		assertTrue(q1_2.isPermutation(str3, str4));
	}
	
	@Test
	void test1_3() {
		String str5 = "Testing testing testing         ";
		String str6 = "Testingtestingtesting";
		String str7 = "This is a longer string with a bunch of spaces                           ";
		String str8 = "This is a string with more spaces than needed appended to the end                                          ";
		assertEquals(q1_3.urlify(str5, str5.length()), "Testing%20testing%20testing");
		assertEquals(q1_3.urlify(str6, str6.length()), "Testingtestingtesting");
		assertEquals(q1_3.urlify(str7, str7.length()), "This%20is%20a%20longer%20string%20with%20a%20bunch%20of%20spaces");
		assertEquals(q1_3.urlify(str8, str8.length()), "This%20is%20a%20string%20with%20more%20spaces%20than%20needed%20appended%20to%20the%20end");

	}
	
	// add 1.4-1.8 here
	
	@Test
	void test1_9() {
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		String s3 = "erbottlewta";
		assertTrue(q1_9.isRotation(s1, s2));
		assertFalse(q1_9.isRotation(s1, s3));
		assertTrue(q1_9.isRotationAlgo(s1, s2));
		assertFalse(q1_9.isRotationAlgo(s1, s3));
	}

}
