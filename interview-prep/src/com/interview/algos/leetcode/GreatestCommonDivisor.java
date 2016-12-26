package com.interview.algos.leetcode;

public class GreatestCommonDivisor {

	public static Integer gcdByDivison(int a, int b){
		while(b!=0){
			int temp= b;
			b = a%b;
			a = temp;
		}
		return a;
	}
	
	
	public static int gcdBySubtraction(int a, int b){
		while(a!=b){
			if(a>b && a!=0) a = a-b;
			else if (a==0) a=b;
			if(b>a && b!=0) b= b-a;
			else if(b==0) b=a;
		}
		return a;	
	}
	
	public static int gcdByRecursive(int a, int b){
		if (b==0) return a;
		return gcdByRecursive(b, a%b);
	}
	
	public static void main(String[] args){
		System.out.println(gcdByDivison(0,30));
		System.out.println(gcdByDivison(0, 30));
		System.out.println(gcdByRecursive(0, 30));
	}
}

