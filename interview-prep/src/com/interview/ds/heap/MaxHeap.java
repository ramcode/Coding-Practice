package com.interview.ds.heap;

/*
 * Heap Sort algorithm 
 * - build heap
 * - exchange root with last element of array
 * - heapify with root
 * - loop till last but one element
 * 
 */
public class MaxHeap implements Heap{
	public int heapSize;
	public int[] buildHeap(int[] array){
		heapSize = array.length;
		for(int i= (array.length/2) - 1; i>-1; i--){
			heapify(array,i);
		}
		return array;
	}
	
	public void heapify(int[] array, int i){
		int left = 2*i + 1;
		int right = 2*i + 2;
		int largest = 0;
		if(left<heapSize && array[left]>array[i]){
			largest = left;
		}
		else{
			largest = i;
		}
		if(right<heapSize && array[right]>array[largest]){
			largest = right;
		}
		if(largest!=i){
			swap(array, i, largest);
			heapify(array, largest);
		}
	}
	
	public int[] swap(int[] array, int i , int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		return array;
	}
	
	public int[] heapSort(int[] array){
		buildHeap(array);
		for(int i=array.length-1; i>0; i--){
			swap(array,0,i);
			heapSize = heapSize-1;
			heapify(array,0);
		}
		return array;
	}
	

	
	public static void main(String arg[]){
		/*MaxHeap hs = new MaxHeap();
		int[] array = new int[]{8,67,32,667,5,545,4,54,5};
		hs.heapSort(array);
		for(int i : array){
			System.out.println(i);
		}*/
		MaxHeap mh1 = new MaxHeap();
		int[] mergeArray = new int[10];
		for(int i=1; i<6; i++){
			mergeArray[i] = i;
		}
		int[] heap1 = mh1.buildHeap(mergeArray);
		for(int i: heap1){
			System.out.print(i+" ");
		}
		MaxHeap mh2 = new MaxHeap();
		int[] heap2 = mh2.buildHeap(new int[]{6,7,8,9,10});
		System.out.println();
		for(int i: heap2){
			System.out.print(i+" ");
		}
		for(int i=0; i<heap2.length; i++){
			heap1[i+heap2.length] = heap2[i]; 
		}
		for(int i= (heap1.length/2) - 1; i>-1; i--){
			mh1.heapify(heap1,i);
		}
		System.out.println();
		for(int i: heap1){
			System.out.print(i+" ");
		}
	}

}
