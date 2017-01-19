package com.interview.ds.linkedlist;

public class CircularLinkedList {
	
	public Node head;
	
	public Node insert(int val){
		if(head==null){
			Node headNode = new Node(val);
			headNode.next = headNode;
			headNode.prev = headNode;
			this.head = headNode;
			return head;
		}
		else{
			Node last = head.prev;
			Node newLast = new Node(val);
			last.next = newLast;
			newLast.prev = last;
			newLast.next = head;
			head.prev = newLast;
			return head;
		}
	}
	
	public void iterateCL(Node head){
		while(head!=null){
			System.out.print(head.val+" ");
			head = head.next;
		}
	}

	public class Node {
		public Node prev;
		public Node next;
		public int val;

		public Node(int val) {
			this.val = val;
		}
	
	}
	
	public static void main(String[] args){
		CircularLinkedList cl = new CircularLinkedList();
		cl.insert(5);
		cl.insert(-3);
		cl.insert(6);
		cl.insert(8);
		cl.insert(9);
		cl.insert(0);
		cl.iterateCL(cl.head);
		
	}

}
