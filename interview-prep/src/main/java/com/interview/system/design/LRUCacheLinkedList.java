package com.interview.system.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheLinkedList {
	public class Node {
		public Node prev;
		public Node next;
		public int val;
		public int key;

		public Node(int key, int val) {
			this.val = val;
			this.key = key;
		}
	}

	public int capacity = 0;
	public Map<Integer, Node> map = null;
	public Node head, tail;

	public LRUCacheLinkedList(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
		head = new Node(-1, -1);
		tail = new Node(-1, -1);
		head.next = tail;
		tail.prev = head;
	}

	public void add(Node node) {
		node.next = head.next;
		head.next.prev = node;
		node.prev = head;
		head.next = node;
	}

	public void deleteNode(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
		node.next = null;
		node.prev = null;
	}

	public Node delete() {
		Node node = tail.prev;
		tail.prev.prev.next = tail;
		tail.prev = tail.prev.prev;
		return node;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			deleteNode(map.get(key));
			add(map.get(key));
			return map.get(key).val;
		}
		return -1;

	}

	public void set(int key, int value) {
		if (capacity == 0)
			return;
		if (map.containsKey(key)) {
		    Node node = map.get(key);
			deleteNode(node);
			node.val = value;
			add(node);
			map.put(key, node);
		} else if (capacity == map.size()) {
			map.remove(delete().key);
			Node node = new Node(key, value);
			add(node);
			map.put(key, node);
		} else {
			Node node = new Node(key, value);
			add(node);
			map.put(key, node);
		}
	}
	
	public static void main(String[] args){
		LRUCacheLinkedList cache = new LRUCacheLinkedList(1);
		cache.set(2,1);
		System.out.println(cache.get(2));
	}

}
