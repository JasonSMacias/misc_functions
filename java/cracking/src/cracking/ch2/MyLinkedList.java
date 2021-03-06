package cracking.ch2;

import java.util.*;

public class MyLinkedList {
	Node head;
	//needs to be public for sending nodes to driver
	public class Node {
		Node next;
		int data;
		
		private Node(int data) {
			this.data = data;
		}
	}
	public MyLinkedList(int data) {
		this.head = new Node(data);
	}
	public void addBegin(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
	public void addEnd(int data) {
		Node newNode = new Node(data);
		Node curr = head;
		while(curr.next != null) curr = curr.next;
		curr.next = newNode;
	}
	public void removeDups() {
		Set<Integer> valSet = new HashSet<>();
		Node curr = head;
		Node last = null;
		while(curr.next != null) {
			if(!valSet.add(curr.data)) {
				last.next = curr.next;
			}
			last = curr;
			curr = curr.next;
		}
	}
	public void removeDupsSaveSpace() {
		Node pointer1 = head;
		Node pointer2;
		Node pointer2prev;
		while(pointer1.next != null) {
			pointer2 = pointer1.next;
			pointer2prev = pointer1;
			while (pointer2.next != null) {
				if(pointer1.data == pointer2.data) {
					pointer2prev.next = pointer2.next;
				}
				pointer2prev = pointer2;
				pointer2 = pointer2.next;
			}
			if(pointer1.data == pointer2.data) {
				pointer2prev.next = pointer2.next;
			}
			pointer1 = pointer1.next;
		}
	}

	public int findKthLast(int k) { 
		Stack<Integer> listStack = new Stack<>();
		Node curr = head;
		listStack.push(curr.data);
		while(curr.next != null) {
			curr = curr.next;
			listStack.push(curr.data);
		}
		if(k > listStack.size()) throw new IllegalArgumentException("requested index not within range");
		for(int i = 1; i < k; i++) listStack.pop();
		return listStack.pop();
	}
	
	public int findKthLastEff(int k) {
		Map<Integer, Integer> listMap = new HashMap<Integer, Integer>();
		Node curr = head;
		int index = 0;
		listMap.put(++index, curr.data);
		while(curr.next != null) {
			curr = curr.next;
			listMap.put(++index, curr.data);
		}
		if(k > listMap.size()) throw new IllegalArgumentException("requested index not within range");
		return listMap.get(index + 1 - k);
	}
	
	public int findKthLastRecursive(int k) {
		return findKthLastRecurHelper(head, k)[0];
	}
	private Integer[] findKthLastRecurHelper(Node curr, int k) {
		if (curr == null) {
			return new Integer[] {null, 0};
		}
		int tempVal = curr.data;
		Integer[] valIndex = findKthLastRecurHelper(curr.next, k);
		if(valIndex[0] != null) return valIndex;
		valIndex[1]++;
		if(k == valIndex[1]) valIndex[0] = tempVal;
		return valIndex;
	}
	
	public void partitionList(int divider) {
		// Node that will mark the second partition of the list
		if (head.data >= divider) {
			Node tempRunner = head;
			Node runnerPrevious = null;
			while (tempRunner.data >= divider) {
				if (tempRunner.next == null) return;
				runnerPrevious = tempRunner;
				tempRunner = tempRunner.next;
			}
			runnerPrevious.next = tempRunner.next;
			tempRunner.next = head;
			head = tempRunner;
		}
		Node lastLower = head;
		Node runner = lastLower;
		while (runner.data < divider) {
			System.out.println("Made it out ");
			lastLower = runner;
			runner = runner.next;
			if (runner == null) return;
		}
		OUTER: while (runner.next != null) {
			while (runner.next.data >= divider) {
				runner = runner.next;
				if (runner.next == null) break OUTER;
			}
			Node toMove = runner.next;
			runner.next = toMove.next;
			toMove.next = lastLower.next;
			lastLower.next = toMove;
		}
		
	}
	
	public Node getNode(int k) {
		Node cur = head;
		while(cur.next != null) {
			if (cur.data == k) {
				return cur;
			}
			cur = cur.next;
		}
		if (cur.data == k) return cur;
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node start = head;
		while(start.next != null) {
			sb.append(start.data + ", ");
			start = start.next;
		}
		sb.append(start.data + "]");
		return sb.toString();
	}
	
}
