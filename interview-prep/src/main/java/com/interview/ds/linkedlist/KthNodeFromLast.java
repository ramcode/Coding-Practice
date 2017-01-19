package com.interview.ds.linkedlist;

public class KthNodeFromLast {

	public Node head = null;

	public class Node {
		public Node next;
		public int val;

		public Node(int val) {
			this.val = val;
		}
	}

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

	public Node kthNodeFromLast(Node head, int k) {
		Node p1 = head;
		Node p2 = head;
		int count = 1;
		while (p2 != null) {
			p2 = p2.next;
			count++;
			if (count == k) {
				break;
			}
		}
		if (p2 == null) {
			return null;
		}
		while (p2 != null) {
			p2 = p2.next;
			p1 = p1.next;
		}
		return p1;
	}

	public static void main(String[] args) {
		KthNodeFromLast l1 = new KthNodeFromLast();
		l1.insert(5);
		l1.insert(2);
		l1.insert(3);
		l1.insert(-3);
		l1.insert(6);
		l1.insert(7);
		l1.insert(56);
		l1.insert(9);
		l1.insert(11);

		System.out.println(l1.kthNodeFromLast(l1.head, 1));
	}

}
