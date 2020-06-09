package cracking.ch2;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Stack;

// write an algorithm to find the kth from last element of a singly linked list

//see MyLinkedList method by this name for homemade LinkedList implementation
public class Question2_2 {
	
	// treating java LL as if a simple xsingly linked list, O(n, k)
	public int findKthLast(List<Integer> list, int k) { 
		Stack<Integer> listStack = new Stack<>();
		ListIterator<Integer> itr = list.listIterator();
		while(itr.hasNext()) listStack.push(itr.next());
		if(k > listStack.size()) throw new IllegalArgumentException("requested index not within range");
		for(int i = 1; i < k; i++) listStack.pop();
		return listStack.pop();
	}
	
	// using a map instead of a stack to make it O(n), again treating as if a basic singly linked list
	public int findKthLastEff(List<Integer> list, int k) {
		Map<Integer, Integer> listMap = new HashMap<Integer, Integer>();
		ListIterator<Integer> itr = list.listIterator();
		int index = 0;
		while(itr.hasNext()) {
			listMap.put(++index, itr.next());
		}
		if(k > listMap.size()) throw new IllegalArgumentException("requested index not within range");
		return listMap.get(index + 1 - k);
	}
}
