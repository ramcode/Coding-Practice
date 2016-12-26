package com.interview.ds.linkedlist;

public class QueueUsingLinkedList {
	
	public Node head;
	public Node tail;
	public int size;

	public void offer(int val){
		if(head==null){
			Node head = new Node(val);
			this.head = head;
			this.tail = head;
		}
		else{
			Node node = new Node(val);
			tail.next = node;
			this.tail = node;
		}
		size++;
	}
	
	public int poll() throws IllegalAccessException{
		if(head!=null){
			int val = head.val;
			head = head.next;
			size--;
			return val;
		}
		throw new IllegalAccessException("Queue Empty");
	}
	
	
	public int peek() throws IllegalAccessException{
		if(head!=null){
			return head.val;
		}
		throw new IllegalAccessException("Queue Empty");
	}
	
	public int size(){
		return size;
	}
	
	public static void main(String[] args) throws Exception{
		QueueUsingLinkedList queue = new QueueUsingLinkedList();
		queue.offer(5);
		queue.offer(3);
		queue.offer(2);
		queue.offer(-1);
		System.out.println(queue.size());
		System.out.println(queue.poll());
		System.out.println(queue.size());
		System.out.println(queue.poll());
		System.out.println(queue.size());
		System.out.println(queue.poll());
		System.out.println(queue.size());
		System.out.println(queue.poll());
		System.out.println(queue.size());
	}

}
