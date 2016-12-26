package com.mission.interview.algos;

public class Node<T extends Comparable<T>> {

	private Node<T> parentNode;
	private Node<T> leftNode;
	private Node<T> rightNode;
	private T data;

	public Node(T data) {
		this.data = data;
	}

	public Node(T data, Node<T> leftNode, Node<T> rightNode) {
		this.data = data;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}

	public Node(T data, Node<T> parentNode) {
		this.data = data;
		this.parentNode = parentNode;
	}

	private int insertionSequence;

	public int getInsertionSequence() {
		return insertionSequence;
	}

	public void setInsertionSequence(int insertionSequence) {
		this.insertionSequence = insertionSequence;
	}

	public Node<T> getParentNode() {
		return parentNode;
	}

	public void setParentNode(Node<T> parentNode) {
		this.parentNode = parentNode;
	}

	public Node<T> getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node<T> leftNode) {
		this.leftNode = leftNode;
	}

	public Node<T> getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node<T> rightNode) {
		this.rightNode = rightNode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
