package com.interview.algos.bitmanipulation;

public class CountBitsSet {
	
	
	public static int countBitsSet(int n){
		int count = 0;
		int mask = 1;
		for(int i=0; i<Integer.toBinaryString(n).length(); i++){
			if((mask&n)>0){
				count++;
			}
			mask = mask << 1;
		}
		return count;
	}
	
	 public int[] countBits(int num) {
	        
	        int[] sol = new int[num+1];
	        for(int i=1; i<=num; i++){
	            sol[i] = sol[i >> 1] + sol[i & 1];
	        }
	        return sol;
	    }

	
	public static void main(String[] args){
		System.out.println(countBitsSet(35678));
		System.out.println(Integer.bitCount(35678));
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
	}
}
