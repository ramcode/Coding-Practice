package com.interview.algos.dynamic.programming;

public class StairCaseClimb {

	public static int countWays(int n) {
		int n0 = 1;
		int n1 = 1;
		int n2 = 2;
		if (n == n1)
			return n1;
		if (n == n2)
			return n2;
		for (int i = 3; i <= n; i++) {
			int count = n0 + n1 + n2;
			n0 = n1;
			n1 = n2;
			n2 = count;
		}
		return n2;
	}
	
	public static void main(String[] args){
		System.out.println(countWays(4));
	}

}
