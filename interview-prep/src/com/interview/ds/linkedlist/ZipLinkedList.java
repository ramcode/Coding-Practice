package com.interview.ds.linkedlist;

public class ZipLinkedList {

	public static LinkedList zipLinkedLists(LinkedList list) {
		// to do
		if(list==null || list.head==null)
			return null;
		Node mid = findMid(list);
		Node second = reverse(mid.next);
		mid.next = null;
		Node first = list.head;
		while(second!=null){
			Node temp = second.next;
			second.next = first.next;
			first.next = second;
			first = first.next.next;
			second = temp;
		}
		return list;

	}

	public static Node findMid(LinkedList list) {
		if (list == null || list.head == null)
			return list.head;
		Node slow = list.head;
		Node fast = list.head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	public static Node reverse(Node head) {
		if (head == null)
			return head;
		Node prev = null;
		return reverse(prev, head);

	}
	
	public static Node reverse(Node prev, Node head){
		if(head ==null)
			return prev;
		Node next = head.next;
		head.next = prev;
		return reverse(head, next);
		
	}
	
	public static void main(String[] args){
		LinkedList list = LinkedList.createLL(new int[]{});
		list.iterateLL(ZipLinkedList.zipLinkedLists(list).head);
	}

}
