package com.interview.algos.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strs) {
			char[] sortedStr = str.toCharArray();
			Arrays.sort(sortedStr);
			String s = String.valueOf(sortedStr);
			if (map.containsKey(s)) {
				map.get(s).add(str);
			} else {
				List<String> list = new ArrayList<String>();
				list.add(str);
				map.put(s, list);
			}
		}
		return new ArrayList<List<String>>(map.values());
	}
	
	public static void main(String[] args){
		System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
	}
}
