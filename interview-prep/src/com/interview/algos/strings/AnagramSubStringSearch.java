package com.interview.algos.strings;

import java.util.ArrayList;
import java.util.List;

public class AnagramSubStringSearch {

	public static List<Integer> anagramSubStringIndexes(String s, String p) {
		List<Integer> list = new ArrayList<Integer>();
		if (p == null || s == null || p.length() == 0 || s.length() == 0 || s.length() < p.length())
			return list;
		int[] map = new int[256];
		for (char c : p.toCharArray()) {
			map[c - 'a']++;
		}
		int start = 0, end = 0, matchCount = 0, winLength = p.length();
		while (end < s.length()) {
			if (map[s.charAt(end) - 'a'] > 0) {
				matchCount++;
			}
			map[s.charAt(end) - 'a']--;
			if (matchCount == winLength) {
				list.add(start);
			}
			end++;
			if (end - start == winLength) {
				if (map[s.charAt(start) - 'a'] >= 0) {
					matchCount--;
				}
				map[s.charAt(start) - 'a']++;
				start++;
			}

		}
		return list;
	}

	public static void main(String[] args) {
		System.out.println(anagramSubStringIndexes("cbaebabacd", "abc"));
	}

}
