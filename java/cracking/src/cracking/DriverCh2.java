package cracking;

import java.util.*;

import cracking.ch2.*;

public class DriverCh2 {
	private static Question2_1  q2_1 = new Question2_1();
	public static void main(String[] args) {
		// Question 2.1
		LinkedList<Integer> ll1 = new LinkedList<>(Arrays.asList(1, 4, 6, 9, 2, 1, 12, 4, 0, -1));
		LinkedList<Integer> ll2 = (LinkedList<Integer>)ll1.clone();
		MyLinkedList mll1 = new MyLinkedList(ll1.get(0));
		MyLinkedList mll2 = new MyLinkedList(ll1.get(0));
		MyDoublyLinkedList mdll1 = new MyDoublyLinkedList(ll1.get(0));
		MyDoublyLinkedList mdll2 = new MyDoublyLinkedList(ll1.get(0));
		for (int i = 1; i < ll1.size(); i++) {
			mll1.addEnd(ll1.get(i));
			mll2.addEnd(ll1.get(i));
			mdll1.addEnd(ll1.get(i));
			mdll2.addEnd(ll1.get(i));
		}
		System.out.println("Original List:\n" + ll1);
		
		q2_1.removeDups(ll1);
		q2_1.removeDupsSaveSpace(ll2);
		mll1.removeDups();
		mll2.removeDupsSaveSpace();
		mdll1.removeDups();
		mdll2.removeDupsSaveSpace();
		System.out.println("Removing duplicates from Java Linked list:\n" + ll1);
		System.out.println("Removing duplicates from Java linked list without buffer:\n" + ll2);
		System.out.println("Removing duplicates from my linked list:\n" + mll1);
		System.out.println("Removing duplicates from my linked list without buffer:\n" + mll2);
		System.out.println("Removing duplicates from my doubly linked list:\n" + mdll1);
		System.out.println("Removing duplicates from my doubly linked list without buffer:\n" + mdll2);
	}

}
