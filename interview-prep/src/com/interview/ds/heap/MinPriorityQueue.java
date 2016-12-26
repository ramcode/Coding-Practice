package com.interview.ds.heap;

public class MinPriorityQueue implements Heap {
	public MinPriorityQueue(int capacity) {
		this.array = new int[capacity];
		heapSize = 0;
	}

	public static int heapSize;
	public int[] array;

	@Override
	public int[] buildHeap(int[] array) {
		heapSize = array.length;
		for (int i = (array.length / 2) - 1; i > -1; i--) {
			heapify(array, i);
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void heapify(int[] array, int i) {
		// TODO Auto-generated method stub

		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int smallest = 0;
		if (left < heapSize && array[left] < array[i]) {
			smallest = left;
		} else {
			smallest = i;
		}
		if (right < heapSize && array[right] < array[smallest]) {
			smallest = right;
		}
		if (smallest != i) {
			swap(array, i, smallest);
			heapify(array, smallest);
		}

	}

	public int[] swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		return array;
	}

	public int extractMin(int[] array) {
		buildHeap(array);
		int min = array[0];
		swap(array, 0, array.length - 1);
		heapSize = heapSize - 1;
		heapify(array, 0);
		return min;
	}

	public int getMin(int[] array) {
		buildHeap(array);
		return array[0];
	}
	
	public int[] insert(int item){
		array[heapSize] = item;
		int index = heapSize;
		while(index>0 && array[parentIndex(index)]>array[index]){
			swap(array,index,parentIndex(index));
			index = parentIndex(index);
		}
		heapSize++;
		return array;
	}
	
	public int parentIndex(int index){
		return (index-1)/2;
	}
	
	public static void main(String[] args){
		MinPriorityQueue pq = new MinPriorityQueue(10);
		pq.insert(4);
		pq.insert(10);
		pq.insert(-4);
		pq.insert(100);
		pq.insert(250);
		pq.insert(8);
		pq.insert(0);
		int[] finalArray = pq.insert(-10);
		for(int i : finalArray){
			System.out.print(i+" ");
		}
		
		
	}
}
