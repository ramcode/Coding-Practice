package com.interview.ds.linkedlist;

public class ReorderList {
	public void reorderList(Node head) {
		if (head == null || head.next == null)
			return;
		Node slow = head;
		Node fast = head.next.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		Node middle = slow.next;
		slow.next = null;
		Node rev = reverse(middle);
		while (head != null && rev != null) {
			Node next = head.next;
			head.next = rev;
			head = rev;
			rev = next;
		}
	}

	public Node reverse(Node head) {
		Node prev = null;
		while (head != null) {
			Node temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}
		return prev;
	}
	
	public static void main(String[] args){
		Node f = new Node(1);
		Node s= new Node(2);
		Node t = new Node(3);
		Node fo = new Node(4);
		Node fi = new Node(5);
		Node si = new Node(6);
		Node se = new Node(7);
		f.next = s; s.next = t;t.next = fo;fo.next = fi;fi.next = si;si.next = se;
		ReorderList list = new ReorderList();
		list.reorderList(f);
		LinkedList.iterateLL(f);
	}
}
