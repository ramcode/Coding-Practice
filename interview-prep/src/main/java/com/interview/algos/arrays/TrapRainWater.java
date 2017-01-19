package com.interview.algos.arrays;

import java.util.Stack;

public class TrapRainWater {

	public static int trapRainWater(int[] input) {
		if (input.length < 3)
			return 0;
		int left = 0, right = input.length - 1, trappedWater = 0, max = 0;
		while (left < right) {
			if (input[left] < input[right]) {
				max = Math.max(max, input[left]);
				trappedWater += max - input[left];
				left++;
			} else {
				max = Math.max(max, input[right]);
				trappedWater += max - input[right];
				right--;
			}
		}
		return trappedWater;
	}

	public static int trapRainWaterStack(int[] height) {
		if (height.length == 0)
			return 0;
		Stack<Integer> stack = new Stack<Integer>(); // store index
		int vol = 0;
		for (int i = 0; i < height.length; i++) {
			// columns in stack will be decreasing in height.
			// current column index is "i"
			if (stack.empty() || height[stack.peek()] >= height[i])
				stack.push(i);
			// if we encounter a column lower than the previous one, push it to
			// stack.
			else {
				// if we encounter a column higher than the previous one
				// (denoted as "mid"), start poping,
				// calculate the water trapped between column before mid(denote
				// as "j") and "i"
				while (!stack.empty() && height[stack.peek()] < height[i]) {
					int mid = stack.pop();
					if (!stack.empty()) {
						int j = stack.peek();
						vol += (i - j - 1) * (Math.min(height[i], height[j]) - height[mid]);
					}
				}
				stack.push(i);
			}
		}
		return vol;
	}

	public static void main(String[] args) {
		System.out.println(trapRainWaterStack(new int[] { 2,1,0,2}));
	}

}
