package com.interview.algos.recursion;

import java.util.Stack;

public class TowersOfHanoi {

	public class Tower {
		public Stack<Integer> disks = new Stack<Integer>();

		public void removeTop(Tower destination) {
			if (!disks.isEmpty()) {
				destination.addDisk(disks.pop());
			}
		}

		public void addDisk(int disk) {
			disks.add(disk);
		}

		public void moveDisks(int n, Tower buffer, Tower destination) {
			if (n > 0) {
				moveDisks(n - 1, this, buffer);
				this.removeTop(destination);
				moveDisks(n - 1, buffer, destination);
			} else {
				return;
			}
		}
	}

	public void moveDisks(Tower source, Tower buffer, Tower destination) {
		int n = source.disks.size();
		if (n > 0) {
			source.moveDisks(n - 1, source, buffer);
			source.removeTop(destination);
			buffer.moveDisks(n - 1, buffer, destination);
		}
	}

	public static void main(String[] args) {
		TowersOfHanoi t = new TowersOfHanoi();
		TowersOfHanoi.Tower source = t.new Tower();
		TowersOfHanoi.Tower buffer = t.new Tower();
		TowersOfHanoi.Tower destination = t.new Tower();
		for (int i = 5; i > 0; i--) {
			source.addDisk(i);
		}
		t.moveDisks(source, buffer, destination);
		System.out.println(destination.disks);
	}

}
