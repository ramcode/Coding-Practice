package com.interview.algos.arrays;

import java.util.Arrays;

public class MinJumpsToEnd {
	static int[] track;

	public static int minJumpsToReachEnd(int[] input) {
		if(input.length==0)
			return 0;
		int[] jump = new int[input.length];
		track = new int[input.length];
		Arrays.fill(jump, Integer.MAX_VALUE - 1);
		jump[0] = 0;
		for (int i = 1; i < input.length; i++) {
			for (int j = 0; j < i; j++) {
				if (j + input[j] >= i) {
					if (jump[j] + 1 < jump[i]) {
						jump[i] = jump[j] + 1;
						track[i] = j;
					}
				}
			}
		}
		return jump[input.length - 1];
	}
	
	public static void main(String[] args){
		System.out.println(minJumpsToReachEnd(new int[]{3,3,1,0,2,0,1}));
		System.out.println("Jump positions are: ");
		System.out.println(track);
		int i = track.length-1;
		while(i!=0)	{
			System.out.println("Position "+i+" reached from "+track[i]);
			i = track[i];
		}
	}

}
