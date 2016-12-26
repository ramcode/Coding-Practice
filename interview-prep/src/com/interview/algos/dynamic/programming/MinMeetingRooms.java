package com.interview.algos.dynamic.programming;

import java.util.Arrays;
import java.util.Comparator;

public class MinMeetingRooms {
	
	public static int minRooms(int[][] times){
		if(times.length==0) return 0;
		Arrays.sort(times, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
			
		});
		int minRooms = 1;
		int[] prev = times[0];
		for(int i=1; i<times.length; i++){
			if(times[i][0]<prev[1]){
				minRooms++;
			}
			prev = times[i];
		}
		return minRooms;
	}
	
	public static void main(String[] args){
		System.out.println(minRooms(new int[][] {{0, 30},{5, 10},{15, 20}}));
	}

}
