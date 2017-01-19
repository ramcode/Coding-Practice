package com.interview.algos.arrays;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

	Deque<Integer> stack = null;
	Deque<Integer> minStack = null;

	/** initialize your data structure here. */
	public MinStack() {
		stack = new ArrayDeque<>();
		minStack = new ArrayDeque<>();
	}

	public void push(int x) {
		if (minStack.isEmpty() || x <= minStack.peek()) {
			minStack.push(x);
		}
		stack.push(x);

	}

	public void pop() {
		if (stack.peek().equals(minStack.peek())) {
			// stack.pop();
			minStack.pop();
		}
		stack.pop();
	}

	public int top() {
		return stack.peek();

	}

	public int getMin() {
		return minStack.peek();
	}

	public static void main(String[] args) {
		MinStack obj = new MinStack();
		obj.push(512);
		obj.push(-1024);
		obj.push(-1024);
		obj.push(512);
		obj.pop();
		obj.getMin();
		obj.pop();
		obj.getMin();
		obj.pop();
		obj.getMin();
	}
}
