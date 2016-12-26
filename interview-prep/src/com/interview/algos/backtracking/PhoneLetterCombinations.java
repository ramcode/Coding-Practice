package com.interview.algos.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class PhoneLetterCombinations {

	public static List<String> letterCombinations(String s) {
		Queue<String> queue = new LinkedList<>();
		queue.add("");
		Map<String, String> map = new HashMap<>();
		map.put("2", "abc");
		map.put("3", "def");
		map.put("4", "ghi");
		map.put("5", "jkl");
		map.put("6", "mno");
		map.put("7", "pqrs");
		map.put("8", "tuv");
		map.put("9", "wxyz");
		for (int i = 0; i < s.length(); i++) {
			while (queue.peek().length() == i) {
				String keyVal = map.get(String.valueOf(s.charAt(i)));
				String preVal = queue.poll();
				for (char c : keyVal.toCharArray()) {
					queue.add(preVal + c);
				}
			}
		}
		return new ArrayList<>(queue);
	}

	public static void main(String[] args) {
		System.out.println(letterCombinations("2"));
	}

}
