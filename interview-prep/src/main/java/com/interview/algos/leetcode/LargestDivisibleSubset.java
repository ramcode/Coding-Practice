package com.interview.algos.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LargestDivisibleSubset {
	
	public static List<Integer> largestDivisibleSubset(int[] nums){
		if(nums.length<2){
			return Arrays.stream(nums).boxed().collect(Collectors.toList());
		}
		Arrays.sort(nums);
		int[] count = new int[nums.length];
		int[] track = new int[nums.length];
		Arrays.fill(count, 1);
		int maxCount = 1;
		int maxIndex = 0;
		for(int i=1; i<nums.length;i++){
			for(int j=0; j<i; j++){
				if(nums[i]%nums[j]==0 && count[j]+1 > count[i]){
					count[i] = count[j]+1;
					track[i] = j;
					if(count[i]>maxCount){
						maxCount = count[i];
						maxIndex = i;
					}
				}
			}
		}
		int[] subset = new int[maxCount];
		for(int i= subset.length-1; i>-1; i--){
			subset[i] = nums[maxIndex];
			maxIndex = track[maxIndex];
		}
		return Arrays.stream(subset).boxed().collect(Collectors.toList());
	}
	
	public static void main(String[] args){
		int[] input = new int[]{546, 669};
		for(int a : largestDivisibleSubset(input)){
			System.out.println(a);
		}
	}
	
	public static <T> List<T> arrayToList(T[] input){
		List<T> list = new ArrayList<T>();
		for(T a : input){
			list.add(a);
			}
		return list;
	}

}
