package com.interview.algos.arrays;

public class MaxProductInArray {

	public static int maxProductSubArray(int[] input) {
		int minEndingHere = input[0], maxEndingHere = input[0], maxProduct = input[0];
		for (int i = 1; i < input.length; i++) {
			int tempMin = minEndingHere;
			int tempMax = maxEndingHere;
			minEndingHere = Math.min(Math.min(tempMax * input[i], tempMin * input[i]), input[i]);
			maxEndingHere = Math.max(Math.max(tempMax * input[i], tempMin * input[i]), input[i]);
			maxProduct = Math.max(maxProduct, maxEndingHere);
		}
		return maxProduct;
	}

	public static void main(String[] args) {
		System.out.println(maxProductSubArray(new int[] { -10 }));
	}

}
