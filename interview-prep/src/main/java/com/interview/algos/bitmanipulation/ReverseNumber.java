package com.interview.algos.bitmanipulation;

public class ReverseNumber {

	public static int reverseBits(int n) {
		int rev = 0;
		System.out.println(Integer.toBinaryString(n));
		while (n > 0) {
			rev |= n & 1;
			System.out.println(Integer.toBinaryString(rev));
			rev <<= 1;
			n >>= 1;
		}
		return rev;

	}

	public static int reverseNum(int x) {
		if (x == 0)
			return 0;
		if (x == Integer.MIN_VALUE || x == Integer.MAX_VALUE)
			return 0;
		int num = x;
		int rev = 0;
		while (num > 0) {
			rev = rev * 10 + num % 10;
			num = num / 10;
		}
		return x < 0 ? -rev : rev;
	}

	public static void main(String[] args) {
		//System.out.println(reverseNum(1534236469));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(214748364>(2147483647/10));
	}
}
