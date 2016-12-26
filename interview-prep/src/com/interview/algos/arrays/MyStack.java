package com.interview.algos.arrays;

public class MyStack<E> {
	private int capacity = 0;
	private Object[] myStack =null;

	public MyStack(int capacity) {
		this.capacity = capacity;
		myStack = new Object[capacity];
	}

	private int top = -1;

	public void push(Object E) throws StackOverflowError {
		if (top == capacity - 1) {
			throw new StackOverflowError("Stack is full");
		} else {
			myStack[++top] = E;
		}
	}

	public E pop() throws StackUnderFlowError {
		if (top == -1) {
			throw new StackUnderFlowError("Stack is Empty");
		}
		Object poppedElement = myStack[top];
		top--;
		return (E) poppedElement;
	}
	
	public int size() {
		return top + 1;
	}

	public static void main(String[] args) throws StackUnderFlowError {
		MyStack<String> myStack = new MyStack<String>(10);
		myStack.push("1");
		myStack.push("10");
		myStack.push("5");
		myStack.push("6");
		myStack.push(8);
		System.out.println(myStack.pop().getClass());
		
	}

}
