package com.interview.ds.linkedlist;

public class PlusOneRecursive {

	public Node plusOne(Node head) {
		if (head == null)
			return head;
		int carry = getCarry(head);
		if (carry > 0) {
			Node node = new Node(carry);
			node.next = head;
			return node;
		} else
			return head;
	}

	public int getCarry(Node head) {
		if (head == null)
			return 1;
		int carry = getCarry(head.next);
		int sum = head.val + carry;
		head.val = (sum) % 10;
		return sum / 10;
	}

	public Node plusOneRecursive(Node head) {
		if (head == null)
			return head;
		Node dummy1 = new Node(0);
		Node dummy2 = dummy1;
		dummy1.next = head;
		Node node = head;
		while (node!= null) {
			if (node.val != 9) {
				dummy1 = node;
			}
			node = node.next;
		}
		dummy1.val = dummy1.val+1;
		dummy1 = dummy1.next;
		while (dummy1 != null) {
			dummy1.val = 0;
			dummy1 = dummy1.next;
		}
		return dummy2.val > 0 ? dummy2 : dummy2.next;
	}

	public static void main(String[] args) {
		Node node = new Node(9);
		node.next = new Node(9);
		node.next.next = new Node(3);
		PlusOneRecursive p = new PlusOneRecursive();
		LinkedList.iterateLL(p.plusOneRecursive(node));
	}
}
