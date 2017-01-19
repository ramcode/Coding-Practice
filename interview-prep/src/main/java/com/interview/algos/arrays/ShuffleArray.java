package com.interview.algos.arrays;

import java.util.Arrays;
import java.util.Random;

public class ShuffleArray {
	
	public static void main(String[] args){
		Random rand = new Random();
		int[] rands = new int[10];
		for(int i=0; i<10; i++){
			rands[i] = rand.nextInt(9);
		}
		System.out.println(Arrays.toString(rands));
	}

}
