package com.interview.algos.dynamic.programming;

public class PainteFenceDP {
	
	public static int paintFence(int posts, int colors){
		int[] ways = new int[]{0,colors,colors*colors,0};
		if(posts<=2) return ways[posts];
		for(int i=3; i<=posts; i++){
			ways[3] = (colors-1)*( ways[2]+ways[1]);
			ways[1] = ways[2];
			ways[2] = ways[3];
		}
		return ways[3];
	}

	public static void main(String[] args){
		System.out.println(paintFence(5, 3));
	}
}
