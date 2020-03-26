package cracking.ch2;

import java.util.HashSet;
import java.util.Set;

public class MyDoublyLinkedList {
	Node head;
	Node tail;
	private class Node {
		Node next;
		Node prev;
		int data;
		
		private Node(int data) {
			this.data = data;
		}
	}
	public MyDoublyLinkedList(int data) {
		this.head = new Node(data);
		this.tail = head;
	}
	public void addBegin(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head.prev = newNode;
		head = newNode;
	}
	public void addEnd(int data) {
		Node newNode = new Node(data);
		newNode.prev = tail;
		tail.next = newNode;
		tail = newNode;
	}
	public void removeDups() {
		Set<Integer> valSet = new HashSet<>();
		Node curr = head;
		while(curr.next != null) {
			if(!valSet.add(curr.data)) {
				curr.prev.next = curr.next;
				curr.next.prev = curr.prev;
			}
			curr = curr.next;
		}
	}
	public void removeDupsSaveSpace() {
		Node pointer1 = head;
		Node pointer2;
		while(pointer1.next != null) {
			pointer2 = pointer1.next;
			while (pointer2.next != null) {
				if(pointer1.data == pointer2.data) {
					pointer2.prev.next = pointer2.next;
				}
				pointer2 = pointer2.next;
			}
			if(pointer1.data == pointer2.data) {
				pointer2.prev.next = pointer2.next;
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
