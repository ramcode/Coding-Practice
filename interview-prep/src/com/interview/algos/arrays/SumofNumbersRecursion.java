package com.interview.algos.arrays;

public class SumofNumbersRecursion {
	
	public static int sumOfNumbers(int n, int[] input){
		if(n==0)
			return 0;
		return sumOfNumbers(n-1, input)+input[n-1];
	}
	
	public static void main(String[] args){
		int[] nums = new int[]{2,1,4,3,5,6,8,2,5,3};
		System.out.println(sumOfNumbers(nums.length, nums));
	}

}
