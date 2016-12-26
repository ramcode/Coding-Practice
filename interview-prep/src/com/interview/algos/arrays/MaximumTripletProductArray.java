package com.interview.algos.arrays;

public class MaximumTripletProductArray {

	public static int maximumTripletProduct(int[] input) {
		if(input.length<3)
			throw new IllegalArgumentException("Invalid input");
		int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE,
				min2 = Integer.MAX_VALUE;
		for (int i = 0; i < input.length; i++) {
			if (input[i] > max1) {
				max3 = max2;
				max2 = max1;
				max1 = input[i];
			} else if (input[i] > max2) {
				max3 = max2;
				max2 = input[i];
			} else if (input[i] > max3) {
				max3 = input[i];
			}
			if (input[i] < min1) {
				min2 = min1;
				min1 = input[i];
			} else if (input[i] < min2) {
				min2 = input[i];
			}
		}
		return Math.max(max1 * max2 * max3, min1 * min2 * max1);
	}
	
	public static void main(String[] args){
		System.out.println(maximumTripletProduct(new int[]{-1,-1}));
	}
}
