package com.interview.algos.arrays;

public class UniqueElementThreeRepeatArray {

	public static int findUniqueElementInThriceRepeats(int[] input) {
		int[] bitSum = new int[32];
		for (int num : input) {
			int bitMask = 1;
			int index = 31;
			while (num != 0) {
				if ((num & bitMask) > 0) {
					bitSum[index]++;
				}
				num >>= 1;
				index--;
			}
		}
		int result = 0;
		int shift = 1;
		for (int i = 31; i >= 0; i--) {
			if (bitSum[i] % 3 != 0) {
				result = result + (bitSum[i] % 3) * shift;
			}
			shift <<= 1;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(findUniqueElementInThriceRepeats(new int[] { 1, 3, 3, 1, 3, 1, 4, 4, 10, 4 }));
	}

}
