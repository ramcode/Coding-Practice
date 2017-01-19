package com.interview.algos.arrays;

import java.util.Collections;

public class MultiplyArrayNumbers {

	public int[] multiplyArrays(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		int start = c.length - 1;
		for (int i = a.length - 1; i > -1; i--) {
			int carry = 0;
			int currentIndex = start;
			for (int j = b.length - 1; j > -1; j--) {
				int result = a[i] * b[j];
				int sum = c[currentIndex] + carry + result;
				c[currentIndex] = sum % 10;
				carry = sum / 10;
				currentIndex--;
			}
			c[currentIndex] = c[currentIndex] + carry;
			start--;
		}
		return c;
	}

	public static void main(String[] args) {
		MultiplyArrayNumbers multiply = new MultiplyArrayNumbers();
		for (int a : multiply.multiplyArrays(new int[] { 1, 2, 3 }, new int[] { 5, 1 })) {
			System.out.print(a + " ");
		}
	}

}
