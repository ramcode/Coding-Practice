package com.interview.algos.arrays;

public class ReverseArrayInGroups {

	public static int[] reverseArray(int[] input, int k) {
		if (input.length == 0 || input.length == 1)
			return input;
		int left = 0, right;
		for (int i = 1; i <= (input.length / k) + 1; i++) {
			if (left < input.length) {
				right = Math.min(i * k - 1, input.length - 1);
				reverseArray(input, left, right);
				left = i * k;
			}
		}
		return input;
	}

	public static void reverseArray(int[] input, int left, int right) {
		while (left < right) {
			int temp = input[left];
			input[left++] = input[right];
			input[right--] = temp;
		}
	}
	
	public static void main(String[] args){
		for(int i: reverseArray(new int[]{1,2,3,4,5,6,7,8,9,10,11}, 1)){
			System.out.println(i+" ");
		}
	}

}
