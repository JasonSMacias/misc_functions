package cracking.ch2;

import java.util.*;

// write code to remove duplicates from an unsorted linked list.
// Follow up: how would you solve this problem if a temporary buffer is not allowed

// see MyLinkedList and MyDoublyLinkedList methods by these names for homemade LinkedList implementation
public class Question2_1 {
	// using a hashset and LinkedList
	public void removeDups(LinkedList<Integer> lst) {
		Set<Integer> valSet = new HashSet<>();
		ListIterator<Integer> itr = lst.listIterator();
		while(itr.hasNext()) {
			int val = itr.next();
			if(!valSet.add(val)) itr.remove();
		}
	}
	// Follow up: doing it without a buffer, has to be O(n^2) time to save the space
	public void removeDupsSaveSpace(LinkedList<Integer> lst) {
		for (int i = 0; i < lst.size() - 1; i++) {
			for(int j = lst.size() - 1; j > i ; j--) {
				if(lst.get(i) == lst.get(j)) lst.remove(j);
				j--;
			}
		}
	}
	
	
}
