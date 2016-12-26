package com.interview.algos.bitmanipulation;

public class CountBitsFlipped {

	public static int countBitsFlipped(int i, int j) {
		int count = 0;
		int c = i ^ j;
		while (c != 0) {
			if ((c & 1) == 1)
				count++;
			c >>= 1;
		}
		return count;
	}

	public static void main(String args[]) {
		System.out.println(countBitsFlipped(29, 15));
	}
}
