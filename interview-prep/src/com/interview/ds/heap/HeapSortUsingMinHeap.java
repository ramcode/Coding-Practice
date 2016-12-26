package com.interview.ds.heap;

import java.io.Externalizable;

public class HeapSortUsingMinHeap implements Heap {

	public static int heapSize;

	@Override
	public int[] buildHeap(int[] array) {
		heapSize = array.length;
		for (int i = (array.length / 2) - 1; i > -1; i--) {
			heapify(array, i);
		}
		return array;

	}

	@Override
	public void heapify(int[] array, int i) {
		int leftIndex = 2 * i + 1;
		int rightIndex = 2 * i + 2;
		int parent = array[i];
		int smallest = i;
		if (leftIndex < heapSize && (array[leftIndex] < parent)) {
			smallest = leftIndex;
		}
		if (rightIndex < heapSize && array[rightIndex] < array[smallest]) {
			smallest = rightIndex;
		}
		if (smallest != i) {
			swap(array, i, smallest);
			heapify(array, smallest);
		}

	}

	public int extractMin(int[] input) {
		int min = input[0];
		input[0] = input[input.length - 1];
		heapSize = heapSize - 1;
		heapify(input, 0);
		return min;
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}

	public static void main(String[] args) {
		HeapSortUsingMinHeap hs = new HeapSortUsingMinHeap();
		int[] heap = hs.buildHeap(new int[] { 5, 8, 1, 565, 2, 95, 0, 232, -1, 545, -45, 5, 88, 23 });
		System.out.println(hs.extractMin(heap));
		for (int i : heap) {
			System.out.println(i);
		}
		System.out.println(hs.extractMin(heap));
		System.out.println(hs.extractMin(heap));
	}

}
