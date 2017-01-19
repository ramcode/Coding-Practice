package com.interview.algos.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumZero {

	public static List<List<Integer>> findThreeSumList(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		int i = 0;
		while (i < nums.length) {
			int a = nums[i];
			int j = i + 1, k = nums.length - 1;
			while (j < k) {
				int b = nums[j];
				int c = nums[k];
				if (a + b + c == 0) {
					list.add(Arrays.asList(a, b, c));
						
				} if (a + b + c <=0) {
					while (j < k && nums[j] == b) {
						j++;
					}
				}

				if (a + b + c >= 0) {
					while (j < k && nums[k] == c) {
						k--;
					}
				}
			}
			while (i < nums.length && nums[i] == a) {
				i++;
			}
		}
		return list;
	}
	
	
	public static void main(String[] args){
		System.out.println(findThreeSumList(new int[]{0,0,0,3,-3
				}));
	}

}
