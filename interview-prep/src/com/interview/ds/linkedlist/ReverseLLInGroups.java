package com.interview.ds.linkedlist;

public class ReverseLLInGroups {

	public static Node reverseInGroups(Node head, int k) {
		Node dummy = head;
		Node prev = null;
		int count = 0;
		Node next = null;
		while (head != null && count++ < k) {
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		if (next != null) {
			dummy.next = reverseInGroups(next, k);

		}
		return prev;
	}

	public static void main(String[] args) {
		LinkedList l1 = new LinkedList();
		l1.insert(5);
		l1.insert(2);
		l1.insert(3);
		l1.insert(-3);
		l1.insert(6);
		l1.insert(7);
		l1.insert(-1);
		l1.insert(9);
		l1.insert(4);
		l1.insert(19);
		l1.insert(0);
		l1.insert(11);
		LinkedList.iterateLL(reverseInGroups(l1.head, 3));
	}

}
