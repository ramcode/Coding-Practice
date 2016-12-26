package com.interview.algos.strings;

import java.util.Arrays;

public class StringCompression {
	
	public static String compressString(String s){
		int[] arr = new int[52];
		for(char c:s.toCharArray()){
			arr[c-'a']++;
		}
		System.out.println(Arrays.toString(arr));
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<s.length();i++){
			if(arr[s.charAt(i)-'a']>0){
				sb.append(s.charAt(i)).append(arr[s.charAt(i)-'a']);
				arr[s.charAt(i)-'a'] = 0;
			}
		}
		return sb.toString();
		
	}
	
	public static void main(String[] args){
		System.out.println(compressString("bbbbabbbbbbabbbbeeebrrrrababacccbcbcbbc"));
	}

}
