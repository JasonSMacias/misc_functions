package cracking.ch2;

// implement an algorithm to delete a node in the middle (i.e. any node but the first and last node, 
// not necessarily the exact middle) of a singly linked list, given access only to that node.


public class Question2_3 {
	// Not really worth while to do this with a Java linked list, just using my linked list
	public void deleteFromMiddle(MyLinkedList.Node node) {
		node.data = node.next.data;
		node.next = node.next.next;	
	};
}
