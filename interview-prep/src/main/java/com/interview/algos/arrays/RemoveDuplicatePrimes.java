package com.interview.algos.arrays;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatePrimes {

	public static int[] removeDuplicatePrimes(int[] input) {
		List<Integer> output = new ArrayList<Integer>();
		boolean[] track = new boolean[input.length];
		for (int i = 0; i < input.length; i++) {
			if (!track[input[i]] && checkPrime(input[i])) {
				output.add(input[i]);
				track[input[i]] = true;
			}
		}
		return output.stream().mapToInt(i -> i).toArray();
	}

	public static boolean checkPrime(int input) {
		int sqrt = (int) Math.ceil(Math.sqrt(Double.parseDouble(Integer.toString(input))));
		for (int i = 2; i <= sqrt; i++) {
			if (input == 2)
				return true;
			else if (input % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		for (int a : removeDuplicatePrimes(new int[] { 3, 5, 7, 3, 3, 13, 5, 13, 29, 13 })) {
			System.out.print(a + " ");
		}
	}

}
