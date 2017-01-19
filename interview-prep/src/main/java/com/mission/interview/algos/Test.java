package com.mission.interview.algos;

public class Test {
	public static boolean isPowerOfThree(int n) {
		if (n == 1)
			return true;
		while (n % 3 == 0)
			n /= 3;
		return n == 1;
	}
	
	public static void main(String[] args){
		System.out.println(isPowerOfThree(0));
	}
	
}