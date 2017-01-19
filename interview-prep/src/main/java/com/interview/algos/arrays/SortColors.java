package com.interview.algos.arrays;

import java.util.Arrays;

public class SortColors {

	public static void sortColors(int[] nums) {
		int left = 0, right = nums.length - 1, i = 0;
		while (i <= right && i>=left) {
			if (nums[i] == 0) {
				int temp = nums[left];
				nums[left++] = nums[i];
				nums[i++] = temp;
			}
			else if (nums[i] == 2) {
				int temp = nums[i];
				nums[i] = nums[right];
				nums[right--] = temp;
			}
			else i++;
		}
	}
	
	public static void main(String[] args){
		int[] nums = {0,0,2,0,1};
		sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}

}
