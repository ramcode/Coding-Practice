package com.interview.algos.arrays;

public class RemoveDupsSortedArray {
	
	public static int[] removeDups(int[] input){
		if(input.length==0 || input.length==1)
				return input;
		int i=1,j=0;
		while(i<input.length && j<i){
			if(input[i]==input[j]){
				int k = i+1;
				while(k<input.length && input[k]==input[i]){
					k++;
				}
				if(k<input.length)
					input[i] = input[k];
			}
			i++;
			j++;
		}
		return input;
	}

public static void main(String[] args){
	for(int a: removeDups(new int[]{2,3,5,5,7,11,11,11,13})){
		System.out.println(a);
	}
}
}
