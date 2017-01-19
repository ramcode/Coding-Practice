package com.interview.algos.strings;

public class LongestSubStringWithKDistinct {
	
	public int lengthOfLongestSubstringKDistinct(String s, int k){
		int start = 0, end = 0, maxLen = 0, len = s.length(), num=0;
		int[] map = new int[26];
		for(end = 0; end<len; end++){
			if(map[s.charAt(end)-'a']++==0){
				num++;	
			}
			if(num>k){
				while(--map[s.charAt(start++)-'a'] > 0){
				}
				num--;
			}
			maxLen = Math.max(maxLen, end-start+1);
		}
		return maxLen;
	}
	
	public static void main(String[] args){
		LongestSubStringWithKDistinct lsKDistinct = new LongestSubStringWithKDistinct();
		System.out.println(lsKDistinct.lengthOfLongestSubstringKDistinct("abcbbbbcccbdddadacb", 2));
	}

}
