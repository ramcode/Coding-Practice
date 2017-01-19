package com.interview.ds.linkedlist;

public class MergeSortedLinkedLists {
	
	public static Node mergeLL(Node h1, Node h2){
		Node dummy = new Node(-1);
		Node temp = dummy;
		while(h1!=null && h2!=null){
			if(h1.val<=h2.val){
				temp.next = h1;
				h1 = h1.next;
			}
			else{
				temp.next = h2;
				h2 = h2.next;
			}
			temp = temp.next;
		}
		temp.next = (h1!=null)?h1:h2;
		return dummy.next;
	}
	
	
	public static void main(String[] args){
		LinkedList l1 = new LinkedList();
		l1.insert(2);
		l1.insert(4);
		l1.insert(6);
		l1.insert(8);
		l1.insert(10);
		// l1.insert(7);
		LinkedList l2 = new LinkedList();
		l2.insert(1);
		l2.insert(3);
		l2.insert(5);
		l2.insert(7);
		l2.insert(9);
		l2.insert(11);
		LinkedList.iterateLL(mergeLL(l1.head, l2.head));
	}

}
