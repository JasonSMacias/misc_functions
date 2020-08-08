package cracking;

import java.util.*;

import cracking.ch2.*;

public class DriverCh2 {
	private static Question2_1  q2_1 = new Question2_1();
	private static Question2_2 q2_2 = new Question2_2();
	private static Question2_3 q2_3 = new Question2_3();
	
	private static LinkedList<Integer> ll1;
	private static LinkedList<Integer> ll2;
	private static MyLinkedList mll1;
	private static MyLinkedList mll2;
	private static MyDoublyLinkedList mdll1;
	private static MyDoublyLinkedList mdll2;
	
	public static void main(String[] args) {
		// Question 2.1
		System.out.println(" ======== Q2.1 ========");
		refreshLists();
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
		
		// Question 2.2
		System.out.println("\n ======== Q2.2 ========");
		refreshLists();
		System.out.println("Original List:\n" + ll1);

		System.out.println("finding 4th from end of Java LL (should be 12):\n" 
							+ q2_2.findKthLast(ll1, 4));
		System.out.println("finding 5th from end of Java LL O(n) (should be 1):\n" 
							+ q2_2.findKthLastEff(ll1, 5));
		System.out.println("finding 6th from end of Java LL Recursive (should be 2):\n" 
							+ q2_2.findKthLastRecursive(ll1.listIterator(), 6)[0] + "\n");
		
		System.out.println("finding 4th from end of my LL (should be 12):\n" 
							+ mll1.findKthLast(4));
		System.out.println("finding 5th from end of my LL O(n) (should be 1):\n" 
							+ mll1.findKthLastEff(5));
		System.out.println("finding 6th from end of my LL Recursive (should be 2):\n" 
							+ mll1.findKthLastRecursive(6) + "\n");
		
		// Question 2.3
		System.out.println("\n ======== Q2.3 ========");
		refreshLists();
		System.out.println("Original List:\n" + ll1);
		MyLinkedList.Node node6 = mll1.getNode(6);
		q2_3.deleteFromMiddle(node6);
		System.out.println("Removing element 6 from my LL " + mll1);
	}
	
	private static void refreshLists() {
		ll1 = new LinkedList<>(Arrays.asList(1, 4, 6, 9, 2, 1, 12, 4, 0, -1));
		ll2 = (LinkedList<Integer>)ll1.clone();
		mll1 = new MyLinkedList(ll1.get(0));
		mll2 = new MyLinkedList(ll1.get(0));
		mdll1 = new MyDoublyLinkedList(ll1.get(0));
		mdll2 = new MyDoublyLinkedList(ll1.get(0));
		for (int i = 1; i < ll1.size(); i++) {
			mll1.addEnd(ll1.get(i));
			mll2.addEnd(ll1.get(i));
			mdll1.addEnd(ll1.get(i));
			mdll2.addEnd(ll1.get(i));
		}
	}

}
