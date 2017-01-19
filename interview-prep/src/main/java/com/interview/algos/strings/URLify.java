package com.interview.algos.strings;

public class URLify {
	
	public static String urilfyString(String s, int trueLen){
		if(s.length()<trueLen) return s;
		int i = trueLen-1,j=s.length()-1;
		char[] chars = s.toCharArray();
		while(i>=0){
			if(chars[i]!= ' '){
				chars[j--] = chars[i--];
			}
			else{
				chars[j--] = '0'; 
				chars[j--] = '2';
				chars[j--] = '%';
				i--;
			}
		}
		return new String(chars);
	}
	
	public static void main(String[] args){
		System.out.println(urilfyString("Mr John Smith    ", 13));
	}

}
