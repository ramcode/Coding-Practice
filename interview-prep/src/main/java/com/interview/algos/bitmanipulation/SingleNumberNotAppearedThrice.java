package com.interview.algos.bitmanipulation;

public class SingleNumberNotAppearedThrice {
	public static int singleNumber(int[] nums) {
		int target = 0;
		for (int i = 0; i < 32; i++) {
			int sum = 0;
			for (int num : nums) {
				sum += (num>>i) & 1;
			}
			if (sum % 3 != 0) {
				target+= (1 << i);
			}
		}
		return target;
	}

	public static void main(String[] args) {
		System.out.println(
				singleNumber(new int[] { -19, -46, -19, -46, -9, -9, -19, 17, 17, 17, -13, -13, -9, -13, -46, -28 }));
	}
}
