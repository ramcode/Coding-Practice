package com.interview.algos.arrays;

public class RotateArrays {
	public static int[] rotateArraySimple(int[] input, int d) {
		for (int i = 0; i < d; i++) {
			rotateArray(input);
		}
		return input;
	}

	public static void rotateArray(int[] input) {
		int temp = input[0];
		int i;
		for (i = 0; i < input.length - 1; i++) {
			input[i] = input[i + 1];
		}
		input[i] = temp;
	}

	public static void main(String[] args) {
		for (int a : rotateArraySimple(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 2)) {
			System.out.print(a + " ");
		}
		System.out.println();
		for (int a : rotateArrayJumbling(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 2)) {
			System.out.print(a + " ");
		}
		System.out.println();
		for (int a : leftRotate(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 2, 7)) {
			System.out.print(a + " ");
		}
	}

	public static int findGcd(int x, int y) {
		while (y != 0) {
			int temp = y;
			y = y % x;
			x = temp;
		}
		return x;
	}

	public static void moveElements(int[] input, int index, int segmentSize) {
		int temp = input[index];
		int i;
		for (i = index; i < input.length-segmentSize; i = i + segmentSize) {
			input[i] = input[i + segmentSize];
		}
		input[i] = temp;
	}

	public static int[] rotateArrayJumbling(int[] input, int d) {
		int gcd = findGcd(input.length, d);
		for (int i = 0; i < gcd; i++) {
			moveElements(input, i, gcd);
		}
		return input;
	}
	
	public static int[] leftRotate(int arr[], int d, int n)
	{
	    int i, j, k, temp;
	    int g = findGcd(d, n);
	    for (i = 0; i < g; i++)
	    {
	    	temp = arr[i];
	    	for (j = i; j + g < n; j += g) {
	    	    arr[j] = arr[j + g];
	    	}
	    	arr[j] = temp;
	    }
	    return arr;
	}

}