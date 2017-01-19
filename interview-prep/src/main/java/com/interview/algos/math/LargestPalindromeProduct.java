package com.interview.algos.math;

public class LargestPalindromeProduct {

	public int largestPalindrome(int n) {
		if (n == 1)
			return 9;
		int pro = (int) Math.pow(10, n);
		int max = pro - 1;
		int min = max / 10;
		long pal = (long) max * (long) max;
		int left = (int) pal / pro;
		while (left > min) {
			pal = left * pro + reverseNum(left);
			for (long i = max; i > pal/i; i--) {
				if (pal % i == 0) {
					return (int) pal % 1337;
				}
			}
			left--;
		}
		new StringBuffer().su
		return (int) pal % 1337;

	}

	public int reverseNum(int num) {
		int rev = 0;
		while (num > 0) {
			rev = rev * 10 + num % 10;
			num = num / 10;
		}
		return rev;
	}
	
	public static void main(String[] args){
		LargestPalindromeProduct pro = new LargestPalindromeProduct();
		System.out.println(pro.largestPalindrome(5));
	}

}
