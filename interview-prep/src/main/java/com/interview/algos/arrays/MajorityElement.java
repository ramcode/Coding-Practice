package com.interview.algos.arrays;

public class MajorityElement {

	public static int majorityElement(int[] input) {
		int targetIndex = 0;
		int count = 1;
		for (int i = 1; i < input.length; i++) {
			if (input[targetIndex] == input[i]) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				targetIndex = i;
				count = 1;
			}
		}
		if (checkMajorityElement(input, input[targetIndex]))
			return input[targetIndex];
		return 0;
	}

	public static boolean checkMajorityElement(int[] input, int a) {
		int count = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] == a)
				count++;
		}
		if (count > (input.length / 2))
			return true;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(majorityElement(new int[] { 2, 3, 5, 2, 2, 6 }));
	}
}
