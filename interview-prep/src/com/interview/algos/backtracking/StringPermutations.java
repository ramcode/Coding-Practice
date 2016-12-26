package com.interview.algos.backtracking;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {

	public static List<String> stringPerms(String s) {
		List<String> list = new ArrayList<String>();
		if (s.length() == 0)
			return list;
		stringPerms(s.length(), "", s, list);
		return list;

	}

	public static void stringPerms(int len, String prefix, String suffix, List<String> list) {
		if (prefix.length() == len) {
			list.add(prefix);
			return;
		}
		for (int i = 0; i < suffix.length(); i++) {
			stringPerms(len, prefix + suffix.charAt(i),
					suffix.substring(0, i) + suffix.substring(i + 1, suffix.length()), list);
		}
	}
	
	public static List<String> permsRecursive(String s){
		List<String> list = new ArrayList<String>();
		if (s.length() == 0)
			return list;
		return permsRecursive(s, list);
		
	}
	
	public static List<String> permsRecursive(String string, List<String> list){
		if(string.length()==1){ 
			list.add(string);
			return list;
		}
		list = merge(permsRecursive(string.substring(1), list), string.substring(0,1));
		return list;
		
	}
	
	public static List<String> merge(List<String> list, String s){
		List<String> newList = new ArrayList<>();
		for(String str : list){
			for(int i=0; i<str.length()+1; i++){
				newList.add(new StringBuffer(str).insert(i, s).toString());
			}
		}
		return newList;
	}

	public static void main(String[] args) {
		System.out.println(permsRecursive("ABCD"));
	}

}
