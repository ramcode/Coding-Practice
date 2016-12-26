package com.interview.algos.arrays;

public class RemoveAndShiftKey {

	public static int removeAndShiftKey(int[] input, int key) {
		if (input.length == 0)
			return -1;
		int j = 0;
		for (int a : input) {
			if (a != key) {
				input[j++] = a;
			}
		}
		return j;

	}

	public static void main(String[] args){
		int[] input = new int[]{1,4, 3,3,5,3,4,6,7,3};
		System.out.println(removeAndShiftKey(input, 3));
		for(int a:input){
			System.out.print(a+" ");
		}
	}

}
