package com.interview.algos.arrays;

import java.util.Arrays;

public class PairSumInArray {

	public static int[] pairSumInArray(int[] input, int targetSum) {
		Arrays.sort(input);
		int i=0;
		int j = input.length-1;
		int[] output = new int[2];
		while(i<j){
			int pairSum = input[i]+input[j];
			if(pairSum==targetSum){
				output[0] = input[i];
				output[1] = input[j];
				return output;
			}
			else if(pairSum<targetSum){
				i++;
			}
			else
				j--;
		}
		return output;
	}
	
	public static void main(String[] args){
		for(int a: pairSumInArray(new int[]{1,4,45,6,10,-8}, 6)){
		System.out.println(a);
		}
	}

}
