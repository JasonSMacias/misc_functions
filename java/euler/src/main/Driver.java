package main;

import problems.*;

public class Driver {
	private static Problem2 p2 = new Problem2();
	public static void main(String[] args) {
		System.out.println("\n - " + p2.fibEvensSum(4_000_000));
		System.out.println("\n - " + p2.fibEvensSum(60));
		
	}

}
