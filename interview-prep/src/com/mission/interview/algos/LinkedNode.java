package com.mission.interview.algos;

public class LinkedNode<T extends Comparable<T>> {
	public T data;
	public LinkedNode<T> next;
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public LinkedNode<T> getNext() {
		return next;
	}
	public void setNext(LinkedNode<T> next) {
		this.next = next;
	}
	public LinkedNode(T data){
		this.data = data;
	}

}
