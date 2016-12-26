package com.interview.algos.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourSumTarget {

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Map<Integer, List<List<Integer>>> map = new HashMap<Integer, List<List<Integer>>>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = 1; j < nums.length; j++) {
				int sum = nums[i] + nums[j];
				if (map.containsKey(sum)) {
					map.get(sum).add(Arrays.asList(new Integer[] { nums[i], nums[j] }));
				} else {
					List<List<Integer>> l = new ArrayList<List<Integer>>();
					l.add(Arrays.asList(new Integer[] { nums[i], nums[j] }));
					map.put(sum, l);

				}
			}
		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = 1; j < nums.length; j++) {
				int req = target - nums[i] - nums[j];
				if (map.containsKey(req)) {
					for (List<Integer> sums : map.get(req)) {
						List<Integer> newsums = new ArrayList<Integer>();
						newsums.addAll(sums);
						newsums.addAll(Arrays.asList(new Integer[] { nums[i], nums[j] }));
						Collections.sort(newsums);
						if (!list.contains(newsums)) {
							list.add(newsums);
						}
					}
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		System.out.println(fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0));
	}

}
