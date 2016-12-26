package com.interview.algos.arrays;

import java.util.Arrays;

public class CountingSort {

	public static int[] countingSort(int[] input, int range) {
		int[] count = new int[range + 1];
		for (int i : input) {
			count[i]++;
		}
		int j = 0;
		for (int i = 0; i < count.length; i++) {
			int cnt = count[i];
			while (cnt > 0) {
				input[j++] = i;
				cnt--;
			}
		}
		return input;
	}

	public static void main(String[] args){
		System.out.println(Arrays.toString(countingSort(new int[]{6,3,6,1,4,3,2,1,3,1,5,5,5,5,0,0}, 6)));
	}

}
