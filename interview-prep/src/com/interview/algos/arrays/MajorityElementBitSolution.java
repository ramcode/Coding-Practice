package com.interview.algos.arrays;

public class MajorityElementBitSolution {
	public static void majorityElement(int[] a) {
		int i;
		int j;
		int[] b = new int[32];

		for (i = 0; i < a.length; i++) {
			for (j = 0; j < 32; j++) {
				b[j] = b[j] + (((a[i] & (1 << j)) > 0) ? 1 : 0);
			}
		}
		int req = 0;
		int cnt = 0;
		for (i = 0; i < 32; i++) {
			if (b[i] > (a.length / 2)) {
				req = req | (1 << i);
			}
		}
		for (i = 0; i < a.length; i++) {
			if (a[i] == req) {
				cnt++;
			}
		}
		if (cnt > (a.length / 2)) {
			System.out.println(req);
		} else {
			System.out.println("no majority element");
		}
	}
	
	public static void main(String[] args){
		majorityElement(new int[]{2,3,3,3,3,5,6,4,3});
	}
}
