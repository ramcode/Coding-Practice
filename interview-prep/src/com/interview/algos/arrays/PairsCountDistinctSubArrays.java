package com.interview.algos.arrays;

public class PairsCountDistinctSubArrays {
	
	public static int countPairsFormedFromDistinctSubArrays(int[] input){
		int count = 0;
		int l=0, r=0;
		boolean[] visited = new boolean[input.length];
		while(r<input.length){
			while(r<input.length && !visited[input[r]]){
				count = count + (r-l);
				visited[input[r]] = true;
				r++;
			}
			while(l<r && r<input.length && visited[input[r]]){
				visited[input[l]] = false;
				l++;
			}
		}
		return count;
	}
	public static void main(String[] args){
		System.out.println(countPairsFormedFromDistinctSubArrays(new int[]{1,1,1,1,1,1,1}));
	}
}
