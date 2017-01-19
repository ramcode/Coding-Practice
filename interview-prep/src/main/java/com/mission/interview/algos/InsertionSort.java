package com.mission.interview.algos;

public class InsertionSort {
	
	//Algo
	static int[] insertionSort(int[] inputArray){
		for(int j=1; j<inputArray.length; j++){
			int i = j-1;
			int key = inputArray[j];
			while(i>=0 && inputArray[i] > key){
				inputArray[i+1] = inputArray[i];
				i = i-1;
			}
			inputArray[i+1] = key;
		}
		return inputArray;
	}
	
//test implementation
	
	public static void main(String[] args){
		int[] inputArray = {1000000, -2, 4, 6, 0, 3};
		insertionSort(inputArray);
		for(int i=0; i<inputArray.length;i++){
			System.out.println(inputArray[i]);
		}
	}
	}


