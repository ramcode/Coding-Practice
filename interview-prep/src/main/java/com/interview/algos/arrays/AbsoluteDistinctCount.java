package com.interview.algos.arrays;

public class AbsoluteDistinctCount {

	/**
	 * @param input
	 * @return
	 */
	public static int absDistinctCountArray(int[] input) {
		int length = input.length;
		int i = 0, j = length - 1;
		while (i < j) {
			while (i != j && input[i] == input[i + 1]) {
				length--;
				i++;
			}
			while (i != j && input[j] == input[j - 1]) {
				length--;
				j--;
			}
			if (i == j)
				break;

			if (input[i] + input[j] == 0) {
				length--;
				i++;
				j--;
			} else if (input[i] + input[j] < 0) {
				i++;
			} else
				j--;
		}
		return length;
	}

	public static void main(String[] args) {
		System.out.print(absDistinctCountArray(new int[] {-5,-5,-5,-4,-3,-2,0,1,5,5,5,5,5 }));
	}

}
