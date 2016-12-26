package com.interview.algos.math;

public class PowerofNumber {
	
	//recursive
	public static double pow(double x, int n){
		if(n==0) return 1;
		if(x<0) x= -x;
		if(n<0){
			n = -n;
			x= 1/x;
		}
		return n%2==0?pow(x*x, n/2):x * pow(x*x, n/2);
	}
	
	//iterative
	public static double powiter(double x, int n){
		if(n==0) return 1;
		double ans = 1;
		if(n==Integer.MIN_VALUE) n = -(n+1);
		int absn = Math.abs(n);
		while(absn>0){
			if((absn & 1)>0) ans*=x;
			absn >>=1;
			x*=x;
		}
		 return n<0?1/ans:ans;
	}
	
	public static void main(String[] args){
		System.out.println(powiter(1.5, 5));
		System.out.println(Integer.MIN_VALUE);
		
	}

}
