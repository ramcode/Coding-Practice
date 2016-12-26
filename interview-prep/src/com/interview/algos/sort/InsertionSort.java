package com.interview.algos.sort;

public class InsertionSort {
	
	public static int[] insertionSort(int[] input){
		for (int i = 1; i<input.length; i++){
			int key = input[i];
			int j = i-1;
			while(j>=0 && input[j]>key){
				input[j+1] = input[j];
				j=j-1;
			}
			input[j+1] = key;
		}
		return input;
	}
	
	
	public static void main(String[] args){
		int[] input = new int[]{3,1,6,2,7,3,7,3,5,8,9,2,4,1};
		for(int a: insertionSort(input)){
			System.out.print(a+" ");
		}
	}
	

}
