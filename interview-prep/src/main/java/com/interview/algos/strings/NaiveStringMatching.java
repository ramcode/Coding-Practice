package com.interview.algos.strings;

public class NaiveStringMatching {

	public static int patternCountMatch(String text, String pattern) {
		int count = 0;
		char[] textArray = text.toCharArray();
		char[] patternArray = pattern.toCharArray();
		int j;
		for (int i = 0; i < text.length() - pattern.length() + 1; i++) {
			for (j = 0; j < pattern.length(); j++) {
				if (textArray[i + j] != patternArray[j]) {
					break;
				}
			}
			if (j == pattern.length())
				count++;
		}
		return count;
	}

	
	public static void main(String[] args){
		System.out.println(patternCountMatch("ATGTGFGSCGTGGTSGTGSGTBCTT","GS"));
	}
}
