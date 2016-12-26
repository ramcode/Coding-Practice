package com.interview.algos.arrays;

public class CountInversions {
	
	public static int countInversions(int[] input){
		int len = input.length;
		return countInv(input,0, len-1);
	}
	
	public static int countInv(int[] input, int low, int high){
		if(low==high)
			return 0;
		int mid = high-low+1/2;
		int leftCount = countInv(input, low, mid-1);
		int rightCount = countInv(input, mid+1, high);
		int crossCount = countCrossInv(input, low,mid,high);
		return leftCount+rightCount+crossCount;
	}

	private static int countCrossInv(int[] input, int low, int mid, int high) {
		// TODO Auto-generated method stub
		int count = 0;
		int i = low, j= mid+1;
		/*while(i<=mid && j<=high){
			if
		}*/
		return 0;
		
	}
	
	

}
