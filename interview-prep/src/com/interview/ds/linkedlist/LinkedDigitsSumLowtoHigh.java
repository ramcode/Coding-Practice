package com.interview.ds.linkedlist;

public class LinkedDigitsSumLowtoHigh {
	
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

	public void iterateLL(Node head) {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
	
public Node linkedSumLowToHigh(Node l1, Node l2){
	Node large = null;
	Node large1 = l1;
	Node large2 = l2;
	if(l1==null && l2==null){
		return null;
	}
	if(l1==null)
		return l2;
	else if(l2==null)
		return l1;
	else{
		while(l1.next!=null && l2.next!=null){
			l1 = l1.next;
			l2 = l2.next;
		}
		if(l1.next==null){
			large = large2;
			while(l2.next!=null){
				l1.next = new Node(0);
				l1 = l1.next;
				l2 = l2.next;
			}
		}
		if(l2.next==null){
			large = large1;
			while(l1.next!=null){
				l2.next = new Node(0);
				l1 = l1.next;
				l2 = l2.next;
			}
		}
		int carry = 0;
		Node returnNode = large;
		while(large1!=null&&large2!=null){
			int val = large1.val + large2.val + carry;
			large.val = (val)%10;
			carry = (val)/10;
			large1 = large1.next;
			large2 = large2.next;
			large = large.next;
		}
		if(carry>0){
			large = new Node(carry);
		}
		return returnNode;
	}
}

public static void main(String[] args){
	LinkedDigitsSumLowtoHigh l1 = new LinkedDigitsSumLowtoHigh();
	l1.insert(5);
	l1.insert(2);
	l1.insert(3);
	l1.insert(4);
	l1.insert(6);
	LinkedDigitsSumLowtoHigh l2 = new LinkedDigitsSumLowtoHigh();
	l2.insert(7);
	l2.insert(3);
	l2.insert(9);
	l1.iterateLL(l1.linkedSumLowToHigh(l1.head, l2.head));
}
}
