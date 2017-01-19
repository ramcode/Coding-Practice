package com.interview.system.design;

public class HashMap<K, V> {

	public static int initialCapacity = 10;
	public int size = 0;
	private Entry<K, V>[] buckets = null;
	public float loadFactor = 0.75f;
	public int capacity = 0;

	public HashMap(int capacity) {
		if (capacity < 0)
			throw new IllegalArgumentException();
		this.capacity = capacity;
	}

	public void init() {
		buckets = new Entry[capacity];
	}

	public HashMap() {
		capacity = initialCapacity;
		init();
	}

	public V get(K key) {
		int hash = hash(key);
		Entry<K, V> entry = buckets[hash];
		if (entry == null)
			return null;
		else {
			while (entry != null && !entry.getKey().equals(key)) {
				entry = entry.next;
			}
			if (entry == null)
				return null;
			return entry.val;
		}
	}

	public void put(K key, V val) {
		if (!containsKey(key)) refactor();
		int hash = hash(key);
		Entry<K, V> head = buckets[hash];
		if (head == null) {
			buckets[hash] = new Entry<K, V>(key, val);
			size++;
			return;
		}
		Entry<K, V> pre = null;
		while (head != null) {
			if (head.key.equals(key)) {
				head.val = val;
				return;
			}
			pre = head;
			head = head.next;
		}
		pre.next = new Entry<K, V>(key, val);
		size++;
	}

	public int size() {
		return size;
	}

	public boolean containsKey(K key) {
		int hash = hash(key);
		Entry<K, V> head = buckets[hash];
		if (head == null) {
			return false;
		}
		while (head != null) {
			if (head.key.equals(key)) {
				return true;
			}
			head = head.next;
		}
		return false;
	}

	public void remove(K key) {
		int hash = hash(key);
		Entry<K, V> head = buckets[hash];
		if (head == null) {
			return;
		}
		Entry<K, V> pre = null;
		while (head != null) {
			if (head.key.equals(key)) {
				Entry<K, V> next = head.next;
				if (pre != null)
					pre.next = next;
				else
					buckets[hash] = null;
				size--;
				return;
			}
			pre = head;
			head = head.next;
		}
	}

	public void refactor() {
		float load = size /(float) capacity;
		if (load > loadFactor) {
			// buckets = new Entry[2*capacity];
			capacity = 2 * capacity;
			Entry<K, V>[] newTable = new Entry[capacity];
			reHashMap(newTable);
			buckets = newTable;
		}
	}

	public void reHashMap(Entry<K, V>[] table) {
		for (int i = 0; i < buckets.length; i++) {
			Entry<K, V> entry = buckets[i];
			while (entry != null) {
				reHash(entry, table);
				entry = entry.next;
			}
		}
	}

	public void reHash(Entry<K, V> entry, Entry<K, V>[] table) {
		int hash = hash(entry.key);
		Entry<K, V> head = table[hash];
		if (head == null) {
			table[hash] = entry;
			return;
		}
		Entry<K, V> pre = null;
		while (head != null) {
			pre = head;
			head = head.next;
		}
		pre.next = entry;
	}

	public int hash(K key) {
		return Math.abs(key.hashCode()) % capacity;
	}

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		/*Random rand = new Random();
		int size = rand.nextInt(1000000000);
		for (int i = 0; i < size; i++) {
			map.put(i, rand.nextInt(100000));
		}
		System.out.println(map.size);
		System.out.println(map.containsKey(5));
		for (int i = 0; i < size; i++) {
			System.out.println("["+i+","+map.get(i)+"]");
		}*/
		map.put("Venkata", "ramesh");
		map.put("cat", "dog");
		map.put("k1", "val1");
		map.put("k2", "val2");
		map.put("k3", "val3");
		System.out.println(map.get("k1"));
		map.put("k1", "cat");
		map.put("k2", "ramesh");
		System.out.println(map.size);
		System.out.println(map.get("cat"));
		System.out.println(map.get("k1"));
		map.remove("cat");
		System.out.println(map.get("ramesh"));
	}

}
