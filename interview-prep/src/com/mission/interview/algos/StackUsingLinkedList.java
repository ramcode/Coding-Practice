package com.mission.interview.algos;

public class StackUsingLinkedList<T extends Comparable<T>> {
	public LinkedNode<T> push(T data){
		LinkedNode<T> temp = this.head;
		if (temp==null){
			head = new LinkedNode<T>(data);
			this.size++;
		}
		else{
			while(temp.next!=null){
				temp = temp.getNext();
			}
			LinkedNode<T> node = new LinkedNode<T>(data);
			temp.setNext(node);
			this.size++;
		}
		return head;
	}
	
	public  void printStack(LinkedNode<T> head){
		while(head!=null){
			System.out.println(head.data);
			head = head.next;
		}
	}
	
	private LinkedNode<T> head;
	private Integer size =0;
	
	public LinkedNode<T> getHead() {
		return head;
	}

	public void setHead(LinkedNode<T> head) {
		this.head = head;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public StackUsingLinkedList(T data){
		this.head = new LinkedNode<T>(data);
	}
	
	public T pop() throws Exception{
		LinkedNode<T> headNode = this.head;
		if(headNode==null){
			throw new IllegalStateException();
		}
		else{
			this.head = headNode.next;
			headNode.next = null;
			this.size--;
			return headNode.data;
		}
	}

	public T peek() throws Exception{
		if(this.head==null){
			throw new IllegalStateException();
		}
		else{
			return this.head.data;
		}
	}
	public Integer size(){
		return this.size;
		
	}
	
	
	public static void main(String arg[]) throws Exception{
	StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<Integer>(10);
	stack.push(11);
	stack.push(12);
	stack.push(13);
	stack.push(14);
	stack.push(15);
	stack.push(16);
	stack.printStack(stack.getHead());
	System.out.println(stack.pop());
	System.out.println(stack.peek());
	System.out.println(stack.size());
	}

}
