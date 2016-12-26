package com.interview.algos.arrays;

import java.util.ArrayList;
import java.util.List;

public class ArrayNextNumber {

	public static int[] nextNumber(int[] input) {
		int carry = 1;
		for (int i = input.length - 1; i >= 0; i--) {
			if ((carry + input[i]) >= 10) {
				int sum = carry + input[i];
				input[i] = (sum) % 10;
				carry = sum / 10;
			} else {
				input[i] = input[i] + carry;
				carry = 0;
			}
		}
		return input;
	}

	public static List<Integer> nextNumber(List<Integer> input) {
		int carry = 1;
		int index = input.size() - 1;
		while (carry > 0 && index >= 0) {
			int sum = carry + input.get(index);
			if (sum >= 10) {
				input.set(index, sum % 10);
				carry = sum / 10;
			} else {
				input.set(index, input.get(index) + carry);
				carry = 0;
			}
			index--;
		}
		if (carry > 0) {
			input.add(0, carry);
		}
		return input;
	}

	public static void main(String[] args) {
		for (int a : nextNumber(new int[] { 8, 9, 9 })) {
			System.out.println(a);
		}
		List<Integer> list = new ArrayList<Integer>();
		list.add(9);
		list.add(9);
		list.add(9);
		list.add(9);
		list.add(9);
		list.add(9);
		list.add(9);
		System.out.println(nextNumber(list));
	}
}
