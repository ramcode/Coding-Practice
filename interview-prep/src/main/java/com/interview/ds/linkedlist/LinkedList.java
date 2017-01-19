package com.interview.ds.linkedlist;

public class LinkedList {
	public Node head = null;

	public Node insert(int data) {
		if (this.head == null) {
			this.head = new Node(data);
			return head;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node(data);
			return head;
		}
	}
	
	public Node insertNode(int data) {
		if (this.head == null) {
			this.head = new Node(data);
			return head;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			Node newNode  = new Node(data);
			temp.next = newNode;
			return newNode;
		}
	}

	public static LinkedList createLL(int[] input) {
		LinkedList list = new LinkedList();
		for (int a : input) {
			list.insert(a);
		}
		return list;
	}

	public static void iterateLL(Node head) {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

	public Node weaveLL(Node head2) {
		Node head1 = this.head;
		while (head1 != null && head2 != null) {
			Node temp1 = head1.next;
			Node temp2 = head2.next;
			head1.next = head2;
			head2.next = temp1;
			head1 = temp1;
			head2 = temp2;
		}
		return head;
	}

	public static void main(String[] args) {
		LinkedList l1 = new LinkedList();
		l1.insert(5);
		l1.insert(2);
		l1.insert(3);
		l1.insert(-3);
		l1.insert(6);
		// l1.insert(7);
		LinkedList l2 = new LinkedList();
		l2.insert(-1);
		l2.insert(9);
		l2.insert(4);
		l2.insert(19);
		l2.insert(0);
		l2.insert(11);
		l1.weaveLL(l2.head);
		l1.iterateLL(l1.head);

	}

}
