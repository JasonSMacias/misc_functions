package cracking.ch2;

import java.util.*;

public class MyLinkedList {
	Node head;
	private class Node {
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
