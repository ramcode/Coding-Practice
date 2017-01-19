package com.interview.algos.strings;

public class ReverseWords {

	public static String reverseWords(String input){
		char[] charArray = input.toCharArray();
		reverseChars(charArray, 0, charArray.length-1);
		int i=0, j=0;
		while(i < charArray.length && j<charArray.length){
			while(i<charArray.length && charArray[i]==' '){
				i++;
				j++;
			}
			while(j<charArray.length && charArray[j]!= ' ') j++;
			reverseChars(charArray, i, j-1);
			i = j;
		}
		return new String(charArray);
	}
	public static char[] reverseChars(char[] input, int i, int j){
		while(i<j){
			char temp = input[i];
			input[i++] = input[j];
			input[j--] = temp;
		}
		return input;
	}
	
	public static void main(String[] args){
		System.out.println(reverseWords("the sky    is blue"));
	}
}
