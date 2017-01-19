package com.interview.algos.strings;

public class ValidWordAbbreviation {
	
	public static boolean isValid(String str, String abr){
		if(str.length()==0 && abr.length()!=0 || (str.length()>0 && abr.length()==0)) return false;
		int i=0, j=0;
		while(i<str.length() && j<abr.length()){
			if(str.charAt(i)==abr.charAt(j)){
				i++;
				j++;
			}
			else if(j<abr.length() && abr.charAt(j)<'0' || abr.charAt(j)> '9') return false;
			else{
				String num = "" ;
				while(j<abr.length() && abr.charAt(j)>='0' && abr.charAt(j)<'9'){
					num = num+abr.charAt(j++);
				}
				i = i+Integer.valueOf(num);
			}
		}
		return i==str.length() && j==abr.length();
	}
	
	 public static int strStr(String haystack, String needle) {
	        if(needle.length() > haystack.length()) return -1;
	        if(needle.length() ==0) return 0;
	        
	        int i=0, j=0, match = 0;
	        while(i<haystack.length() && j<needle.length()){
	            if(haystack.charAt(i)!=needle.charAt(j)) i++;
	            else {
	                while(i<haystack.length() && j<needle.length() && haystack.charAt(i) == needle.charAt(j)){
	                    i++;
	                    j++;
	                    match++;
	                }
	                if(match == needle.length()) return i-match;
	                else{
	                	i = i-match+1;
	                    j = j-match;
	                   match = 0;
	                } 
	        }
	        }
	        if(match == needle.length()) return i-match;
	                else return -1;
	    }
	
	public static void main(String[] args){
		
		System.out.println(strStr("mississippi", "issip"));
		
	}

}
