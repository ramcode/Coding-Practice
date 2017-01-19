package com.mission.interview.algos;

import java.util.Arrays;

public class QuickSort {
	
	public static void quickSort(int[] inputArray,int p, int r){
		if(p<r){
			int q = partitionArray(inputArray,p,r);
			quickSort(inputArray, p, q-1);
			quickSort(inputArray, q+1, r);
		}
		
	}

	private static int partitionArray(int[] inputArray, int p, int r) {
		// TODO Auto-generated method stub
		int x = inputArray[r];
		int i = p-1;
		for(int j=p;j<r;j++){
			if(inputArray[j]<=x){
				i++;
				int temp = inputArray[i];
				inputArray[i] = inputArray[j];
				inputArray[j] = temp;
			}
		}
		int temp = inputArray[i+1];
		inputArray[i+1] = inputArray[r];
		inputArray[r] = temp;	
	return i+1;
}
	
	public static void main(String arg[]){
		int[] input = {2 ,8 ,7, 1, -3, 5,5,4};
		quickSort(input, 0, input.length-1);
		System.out.println(Arrays.toString(input));
	}
}
