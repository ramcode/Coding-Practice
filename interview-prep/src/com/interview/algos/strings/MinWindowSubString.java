package com.interview.algos.strings;

public class MinWindowSubString {
	public String minWindow(String s, String t) {

		int[] map = new int[256];
		for (char c : t.toCharArray()) {
			map[c]++;
		}
		int minLen = Integer.MAX_VALUE, start = 0, end = 0, minStart = start, counter = t.length();

		while (end < s.length()) {
			char e = s.charAt(end);
			if (map[e] > 0) {
				counter--;
			}
			map[e]--;
			end++;
			while (counter == 0) {
				if (end - start < minLen) {
					minLen = end - start;
					minStart = start;
				}
				char st = s.charAt(start);
				if (map[st] == 0) {
					counter++;
				}
				map[st]++;
				start++;
			}
		}

		return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);

	}
}