package com.mission.interview.algos;

import java.util.Arrays;

public class MergeSort {

	public static void mergeSort(Integer[] input) {
		if(input.length>1){
			int len = input.length;
			int mid = len / 2;
			Integer[] left = Arrays.copyOfRange(input, 0, mid);
			Integer[] right = Arrays.copyOfRange(input, mid, len);
			mergeSort(left);
			mergeSort(right);
			merge(input, left,right);
		}
	}

	public static void merge(Integer[] input, Integer[] left, Integer[] right) {
		int i = 0, j = 0;
		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				input[i] = left[i];
				i++;
			} else if (left[i] > right[j]) {
				input[j] = right[j];
				j++;
			} else {
				input[i] = left[i];
				i++;
				j++;
			}
		}
		if (i == left.length) {
			while (j < right.length) {
				input[j] = right[j];
				j++;
			}
		}
		else if (j == right.length) {
			while (i < left.length) {
				input[i] = right[i];
				i++;
			}
		}
	}

	public static void main(String[] args) {
		Integer[] inputArray = { 10000, -2, 4, 6, 0, 3 };
		Integer[] test = Arrays.copyOfRange(inputArray, 0, 1);
		/*for(int i=0; i<test.length;i++){
			System.out.println(test[i]);
		}*/
		MergeSort.mergeSort(inputArray);
		for(int i=0; i<inputArray.length;i++){
			System.out.println(inputArray[i]);
		}
	}

}
