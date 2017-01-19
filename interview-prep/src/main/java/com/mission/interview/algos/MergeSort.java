package com.mission.interview.algos;

import java.util.Arrays;

public class MergeSort {

	public static void mergeSort(int[] input) {
		if(input.length>1){
			int len = input.length;
			int mid = len / 2;
			int[] left = Arrays.copyOfRange(input, 0, mid);
			int[] right = Arrays.copyOfRange(input, mid, len);
			mergeSort(left);
			mergeSort(right);
			merge(input, left,right);
		}
	}

	public static void merge(int[] input, int[] left, int[] right) {
		int i = 0, j = 0, index = 0;
		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				input[index++] = left[i++];
			} else if (left[i] > right[j]) {
				input[index++] = right[j++];
			} else {
				input[index++] = left[i++];
				input[index++] = right[j++];
			}
		}
		if (i == left.length) {
			while (j < right.length) {
				input[index++] = right[j++];
			}
		}
		if (j == right.length) {
			while (i < left.length) {
				input[index++] = left[i++];
			}
		}
	}

	public static void main(String[] args) {
		int[] inputArray = new int[]{ 10000, -2, 3, 6, 6, 3 };
		/*Integer[] test = Arrays.copyOfRange(inputArray, 0, 1);
		/*for(int i=0; i<test.length;i++){
			System.out.println(test[i]);
		}*/
		MergeSort.mergeSort(inputArray);
		for(int i=0; i<inputArray.length;i++){
			System.out.println(inputArray[i]);
		}
	}

}
