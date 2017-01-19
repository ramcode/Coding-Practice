package com.interview.algos.strings;

public class LongestSubStringWithoutRepeatingChar {

	public static int longestSubStr(String str) {
		int[] map = new int[256];
		int maxLen = 0;
		int start = 0, end = -1;
		for (int i = 0; i < str.length(); i++) {
			if (map[str.charAt(i)] > 0) {
				maxLen = Math.max(maxLen, end - start + 1);
				start = Math.max(map[str.charAt(i)], start);
			}
			map[str.charAt(i)] = i + 1;
			end++;

		}
		return Math.max(maxLen, end - start + 1);
	}

	public static void main(String[] args) {
		System.out.println(longestSubStr("nmmxughfn"));
	}

}
