package com.interview.algos.arrays;

public class FindSingleIndoubles {
	
	public static int returnSingle(int[] arr){
		int missing = 0;
		for(int i: arr){
			missing = missing ^ i;
		}
		return missing;
	}
	
	public static void main(String[] args){
		System.out.println(returnSingle(new int[]{2,3,2,5,3,4,5}));
	}

}
