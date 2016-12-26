package com.interview.algos.dynamic.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum {

	public static boolean subsetSum(int[] input, int sum) {
		if (sum == 0)
			return true;
		if (input.length == 0 && sum > 0)
			return false;
		return subSetSum(input, input.length, sum);

	}

	public static boolean subSetSum(int[] input, int len, int sum) {
		if (sum == 0)
			return true;
		if (len == 0 && sum > 0)
			return false;
		if (input[len - 1] > sum)
			return subSetSum(input, len - 1, sum);
		else
			return subSetSum(input, len - 1, sum) || subSetSum(input, len - 1, sum - input[len - 1]);

	}

	public static boolean[][] subSetSumDP(int[] input, int sum) {
		boolean[][] arr = new boolean[input.length][sum + 1];
		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = true;
		}
		for (int j = 1; j < arr[0].length; j++) {
			if (j == input[0]) {
				arr[0][j] = true;
			} else {
				arr[0][j] = false;
			}
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (j < input[i]) {
					arr[i][j] = arr[i - 1][j];
				} else {
					arr[i][j] = arr[i - 1][j] || arr[i - 1][j - input[i]];
				}
			}
		}
		Arrays.stream(arr).forEach(x -> {
			System.out.println(Arrays.toString(x));
		});
		return arr;
	}

	public static void main(String[] args) {
		int[] input = new int[] { 2, 3, 7, 8, 10 };
		int sum = 11;
		boolean[][] output = subSetSumDP(new int[] { 2, 3, 7, 8, 10 }, sum);
		boolean possible = output[output.length - 1][output[0].length - 1];
		System.out.println("Is Subset Sum Possible: " + possible);
		List<Integer> subsetElements = new ArrayList<Integer>();
		if (possible) {
			int i = output.length - 1;
			int j = sum;
			while (i != 0 || j != 0) {
				if (output[i - 1][j]) {
					i = i - 1;
				} else {
					subsetElements.add(input[i]);
					j = j - input[i];
					i = i - 1;
				}
			}
		}
		System.out.println(subsetElements);

	}

}
