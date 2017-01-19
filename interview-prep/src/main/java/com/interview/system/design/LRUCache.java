package com.interview.system.design;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LRUCache {

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

	int counter = 0;
	Map<Integer, Integer> map = null;
	PriorityQueue<Item> queue = null;
	int capacity = 0;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
		queue = new PriorityQueue<>(new Comparator<Item>() {

			@Override
			public int compare(Item i1, Item i2) {
				return i1.priority - i2.priority;
			}
		});

	}

	public int get(int key) {
		if (queue.contains(new Item(key))) {
			queue.remove(new Item(key));
			queue.offer(new Item(key, counter++));
		}
		return map.getOrDefault(key, -1);
	}

	public void set(int key, int value) {
		if (capacity == 0) {
			return;
		}
		if (capacity == map.size()) {
			if (map.containsKey(new Integer(key))) {
				queue.remove(new Item(key));
				queue.offer(new Item(key, counter++));
				map.put(key, value);
			} else {
				Item item = queue.poll();
				map.remove(new Integer(item.key));
				map.put(key, value);
				queue.offer(new Item(key, counter++));
			}
		} else {
			map.put(key, value);
			if (queue.contains(new Item(key))) {
				queue.remove(new Item(key));
			} else {
				queue.offer(new Item(key, counter++));
			}
		}

	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		System.out.println(cache.get(2));
		cache.set(2, 6);
		System.out.println(cache.get(1));
		cache.set(1, 5);
		cache.set(1, 2);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
	}

}