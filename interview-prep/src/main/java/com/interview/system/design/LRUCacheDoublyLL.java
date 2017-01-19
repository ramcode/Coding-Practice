package com.interview.system.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheDoublyLL {

	public class DLNode {
		public DLNode next;
		public int val;
		public int key;
		public DLNode prev;

		public DLNode(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	DLNode head = null;
	DLNode tail = null;
	int capacity;
	Map<Integer, DLNode> map = null;

	public LRUCacheDoublyLL(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
		head = new DLNode(-1, -1);
		tail = new DLNode(-1, -1);
		head.next = tail;
		tail.prev = head;
	}

	public void addToTail(DLNode node) {
		DLNode prev = tail.prev;
		prev.next = node;
		node.prev = prev;
		node.next = tail;
		tail.prev = node;
	}

	public DLNode deleteFromHead() {
		DLNode node = head.next;
		head.next = node.next;
		node.next.prev = head;
		node.next = null;
		node.prev = null;
		return node;
	}

	public void deleteNode(DLNode node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
		node.next = null;
		node.prev = null;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			deleteNode(map.get(key));
			addToTail(map.get(key));
			return map.get(key).val;
		}
		return -1;
	}

	public void set(int key, int val) {
		if (capacity == 0)
			return;
		if (map.containsKey(key)) {
			DLNode node = map.get(key);
			deleteNode(node);
			node.val = val;
			addToTail(node);
			map.put(key, node);
		} else if (map.size() == capacity) {
			map.remove(deleteFromHead().key);
			DLNode node = new DLNode(key, val);
			addToTail(node);
			map.put(key, node);
		} else {
			DLNode node = new DLNode(key, val);
			addToTail(node);
			map.put(key, node);
		}

	}
	
	public static void main(String[] args){
		LRUCacheDoublyLL cache = new LRUCacheDoublyLL(1);
		cache.set(2, 1);
		cache.get(2);
		cache.set(3, 2);
		cache.get(2);
		cache.get(3);
	}
}
