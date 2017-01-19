package com.interview.test.knowledge;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KLargestNumbers {

	public static int[] kLargestNumbers(int[] input, int k) {
		int[] output = new int[k];
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		for (int i = 0; i < input.length; i++) {
			if (pq.size() < k) {
				pq.offer(input[i]);
			} else if (pq.size() == k && input[i] > pq.peek()) {
				pq.poll();
				pq.add(input[i]);
			}
		}
		int i = output.length - 1;
		while (pq.size() > 0) {
			output[i--] = pq.poll();
		}
		return output;
	}

	public static int[] kSmallestNumbers(int[] input, int k) {
		int[] output = new int[k];
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});

		for (int i = 0; i < input.length; i++) {
			if (pq.size() < k) {
				pq.offer(input[i]);
			} else if (pq.size() == k && input[i] < pq.peek()) {
				pq.poll();
				pq.add(input[i]);
			}
		}
		int i = output.length - 1;
		while (pq.size() > 0) {
			output[i--] = pq.poll();
		}
		return output;
	}

	public static void main(String[] args) {
		for (int a : kSmallestNumbers(new int[] { 11, 4, 2, 7, 8, 9, 3 }, 3)) {
			System.out.print(a + " ");
		}
	}

}
