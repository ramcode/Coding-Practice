package com.interview.system.design;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

	Queue<Integer> queue = null;
	Queue<Integer> q2 = null;
	Integer top = null;

	MyStack() {
		queue = new LinkedList<>();
	}

	// Push element x onto stack.
	public void push(int x) {
		queue.offer(x);
		top = x;
	}

	// Removes the element on top of the stack.
	public void pop() {
		int size = queue.size();
		for (int i = 0; i < size; i++) {
			if (i == size - 1)
				queue.poll();
			else if (i == size - 2) {
				top = queue.poll();
				queue.offer(top);
			} else {
				queue.offer(queue.poll());
			}
		}
		if (queue.isEmpty())
			top = null;
	}

	// Get the top element.
	public int top() {
		return top;
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return queue.isEmpty();
	}
}