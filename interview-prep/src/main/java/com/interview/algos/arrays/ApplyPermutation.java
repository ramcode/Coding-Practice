package com.interview.algos.arrays;

public class ApplyPermutation {

	public static int[] applyPermutation(int[] input, int[] perm) {
		for (int i = 0; i < input.length; i++) {
			int index = i;
			while (perm[index] >= 0) {
				int temp = perm[index];
				int next = input[perm[index]];
				input[perm[index]] = input[i];
				input[i] = next;
				perm[index] = perm[index] - perm.length;
				index = temp;
			}
		}
		return input;

	}

	public static void main(String[] args) {
		for (int a : applyPermutation(new int[] { 1, 2, 3, 4 }, new int[] { 3, 2, 1, 0 })) {
			System.out.println(a);
		}

	}
}
