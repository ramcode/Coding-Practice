package com.interview.system.design;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUCache {

	public class Item {
		public int key;
		public int priority;

		public Item(int key, int priority) {
			this.key = key;
			this.priority = priority;
		}

		public Item(int key) {
			this.key = key;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + key;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Item other = (Item) obj;
			if (key != other.key)
				return false;
			return true;
		}
	}

	public int capacity;

	public PriorityQueue<Item> queue;
	public Map<Integer, Integer> valueMap;
	public Map<Integer, Integer> priorityMap;

	public LFUCache(int capacity) {
		this.capacity = capacity;
		this.queue = new PriorityQueue<>(new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				// TODO Auto-generated method stub
				return o1.priority - o2.priority;
			}

		});
		valueMap = new HashMap<>();
		priorityMap = new HashMap<>();
	}

	public int get(int key) {
		Item cand = new Item(key);
		if (queue.contains(cand)) {
			int newPriority = priorityMap.get(key) + 1;
			queue.remove(cand);
			queue.add(new Item(key, newPriority));
			priorityMap.put(key, newPriority);
		}
		return valueMap.getOrDefault(key, -1);

	}

	public void set(int key, int value) {

		if (capacity == 0)
			return;
		if (valueMap.size() == capacity) {
			int toremove = queue.poll().key;
			Item newItem = new Item(key, 1);
			if (queue.contains(newItem)) {
				queue.remove(newItem);
				queue.add(newItem);
			}
			valueMap.remove(toremove);
			valueMap.put(key, value);
			priorityMap.put(key, newItem.priority);
		} else {
			valueMap.put(key, value);
			priorityMap.put(key, 1);
			Item cand = new Item(key, 1);
			if (queue.contains(cand)) {
				queue.remove(cand);
			}
			queue.add(cand);
		}
	}

	public static void main(String[] args) {

		LFUCache cache = new LFUCache(2);
		System.out.println(cache.get(2));
		cache.set(2, 6);
		System.out.println(cache.get(1));
		cache.set(1, 5);
		cache.set(1, 2);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));

		/*
		 * LFUCache cache = new LFUCache(2 capacity ); cache.set(2, 1);
		 * cache.set(2, 2); System.out.println(cache.get(2)); cache.set(1, 1);
		 * cache.set(4, 1); System.out.println(cache.get(2));
		 * 
		 * System.out.println(cache.get(1)); // returns 1 cache.set(3, 3); //
		 * evicts key 2 System.out.println(cache.get(2)); // returns -1 (not
		 * found) System.out.println(cache.get(3)); // returns 3. cache.set(4,
		 * 4); // evicts key 1. System.out.println(cache.get(1)); // returns -1
		 * (not found) System.out.println(cache.get(3)); // returns 3
		 * System.out.println(cache.get(4)); // returns 4
		 */
	}

}
