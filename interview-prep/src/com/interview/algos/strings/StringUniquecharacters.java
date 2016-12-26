package com.interview.algos.strings;

public class StringUniquecharacters {
	
	public static boolean isStringCOntainsUniqueChars(String input){
		boolean[] charCount = new boolean[128];
		for(char c : input.toCharArray()){
			if(charCount[c])
				return false;
			charCount[c] = true;
		}
		return true;
	}
	public static boolean isStringCOntainsUniqueCharsUSingBitVector(String input){
		boolean[] charCount = new boolean[128];
		int mask = 0;
		for(char c : input.toCharArray()){
			if((mask & 1<<c) > 0)
				return false;
			mask = mask | 1<<c;
		}
		return true;
	}
	
	public static void main(String[] args){
		System.out.println(Character.BYTES);
		System.out.println(Character.MAX_VALUE);
		System.out.println(Character.MIN_VALUE);
		System.out.println(Integer.BYTES);
		System.out.println(isStringCOntainsUniqueCharsUSingBitVector(""));
	}

}
