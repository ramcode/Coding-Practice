package com.interview.ds.linkedlist;

public class ReverseLinkedList{
	
	//iterative
	public static Node reverseLL(Node head){
		Node prev = null;
		while(head!=null){
			Node temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}
		return prev;
	}
	
	//reverseSubList
	
	public static Node reverseSubList(Node head, int m, int n) throws IllegalArgumentException{
		if(m==n){
			return head;
		}
		else if(m>n){
			throw new IllegalArgumentException("m shoule be less than n");
		}
		else{
			/*int count =1;
			Node dummy = new Node(-1);
			dummy.next = head;
			Node prev = dummy;
			while(count++<m){
				prev = prev.next;
			}
			Node curr = prev.next;
			while(count++<n){
				Node temp = curr.next;
				curr.next = temp.next;
				temp.next = prev.next;
				prev.next = temp;
				
			}
			return dummy.next;*/
			Node dummy = new Node(-1);
			dummy.next = head;
			Node prev = dummy;
			Node start = null;
			Node end = null;
			int count = 0;
			while(head!=null){
				count++;
				if(count<m){
					prev = head;
					head = head.next;
				}
				else if(count==m){
					start = prev;
					end = head;
					prev = head;
					head = head.next;
				}
				else if(count>m && count<n){
					Node temp = head.next;
					head.next = prev;
					prev = head;
					head = temp;
				}
				else if(count==n){
					Node temp = head.next;
					head.next = prev;
					start.next = head;
					end.next = temp;
					break;
				}
			}
			return dummy.next;
		}
	}
	
	//recursive
	public static Node reverseLLRecFromStart(Node head){
		Node prev = null;
		return reverseLL(head, prev);
	}
	
	public static Node reverseLLRecFromEnd(Node head){
		if(head==null || head.next==null){
			return head;
		}
		Node next = head.next;
		Node newHead = reverseLLRecFromEnd(next);
		next.next = head;
		head.next = null;
		return newHead;
	}
	
	public static Node reverseLL(Node head, Node prev){
		if(head.next==null){
			head.next = prev;
			return head;
		}
		Node next = head.next;
		head.next = prev;
		return reverseLL(next, head);
	}
	
	
	public static void main(String[] args){
		LinkedList l1 = new LinkedList();
		l1.insert(5);
		l1.insert(2);
		l1.insert(3);
		l1.insert(-3);
		l1.insert(6);
		l1.insert(7);
		LinkedList.iterateLL(reverseSubList(l1.head, 1, 1));
	}

}
