package com.interview.system.design;

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