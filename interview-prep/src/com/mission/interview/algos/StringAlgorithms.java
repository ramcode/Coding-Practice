/*package com.mission.interview.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class StringAlgorithms {
	public static List<String> printAllPalindromePermutations(String input){
		List<String> permutations = new ArrayList<String>();
		
		
	}
	
	public static boolean checkPalindromePossible(String input){
		int[] charCount = new int[26];
		int odd=0;
		for(int i=0; i<input.length(); i++){
			charCount[input.charAt(i) - 'a']++;
		}
		for(int i=0; i<charCount.length;i++){
			if(charCount[i]%2==1)
				odd++;
		}
		if((input.length()%2==1 && odd==1) || input.length()%2==0 && odd==0){
			return true;
		}
		else 
			return false;
	}
	
	public static String getHalfString(String input){
		int[] charCount = new int[26];
		for(int i=0; i<input.length(); i++){
			charCount[input.charAt(i) - 'a']++;
		}
		StringBuffer sb = new StringBuffer();
		
		String odd ="";
		for(int i=0; i<charCount.length;i++){
			if(charCount[i]%2==0){
				char[] letter = new char[charCount[i]/2];
				Arrays.fill(letter, (char)(charCount[i] + 'a'));
				sb.
			}
			else
				odd = String.valueOf(charCount[i]+'a');
				
		}
		if(odd!=""){
			sb.append(odd);
		}	
		return sb.toString().r;
	}
	
	public static List<String> getPermutations(String input){
		List<String> perms = new ArrayList<String>();
		for(String s: input){
			//s.re
			 Map<String, String> psgList = new LinkedHashMap<String, String>();
			 Iterator<Entry<String, String>> it = psgList.entrySet().iterator();
			 Entry<String, String> newPsg = it.next();
			 
		}
		
	}

}
*/