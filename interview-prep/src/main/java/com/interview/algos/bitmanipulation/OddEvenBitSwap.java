package com.interview.algos.bitmanipulation;

public class OddEvenBitSwap {
	
	public static int oddEvenBitSwap(int n){
		System.out.println(Integer.toBinaryString(n));
		System.out.println(Integer.toBinaryString((n & 0xAAAAAAAA)));
		System.out.println(Integer.toBinaryString((n & 0xAAAAAAAA)>>1));
		System.out.println(Integer.toBinaryString((n & 0xAAAAAAAA)>>1));
		System.out.println(Integer.toBinaryString((n & 0x55555555)<<1));
		return ((n & 0xAAAAAAAA))>>1 | ((n & 0x55555555)<<1);
	}
	
	public static void main(String[] args){
		System.out.println(oddEvenBitSwap(2016));
	}

}
