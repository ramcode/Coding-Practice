package com.interview.algos.bitmanipulation;

public class NextLowestIntWithSameSetBits {

	public static int getNextLowest(int n){
		int c = n;
		int i0 = 0;
		int i1 = 0;
		while((c&1)==1){
			i1++;
			c>>=1;
		}
		if(c==0){
			throw new IllegalArgumentException("Invalid");
		}
		while((c&1)==0 && c!=0){
			i0++;
			c>>=1;
		}
		int i = i1+i0;
		
		n = n&(~0<<(i+1));
		n = n|(((1<<(i1+1))-1)<<(i0-1));
		return n;
	}
	
	public static void main(String arg[]){
		System.out.println(getNextLowest(14));
	}
}
