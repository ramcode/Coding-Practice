package com.interview.algos.dynamic.programming;

public class LongestPalindromicSubString {
	public String longestPalindrome(String s) {
		int maxLen = 0;
		int start = 0;
		boolean[][] mat = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			mat[i][i] = true;
			start = i;
			maxLen = 1;
		}
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				mat[i][i + 1] = true;
				start = i;
				maxLen = 2;
			}
		}

		for (int i = 3; i <= s.length(); i++) {
			for (int j = 0; j < s.length() - i + 1; j++) {
				if (s.charAt(j) == s.charAt(j + i - 1) && mat[j + 1][j + i - 2]) {
					mat[j][j + i - 1] = true;
					maxLen = i;
					start = j;
				}
			}
		}
		return s.substring(start, start + maxLen);

	}
}