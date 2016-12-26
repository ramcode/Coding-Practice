package com.interview.algos.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListAnagramGroups {

	public static List<List<String>> anagramGrouos(List<String> words) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		List<List<String>> list = new ArrayList<List<String>>();
		for (String word : words) {
			int[] ch = new int[26];
			for (char c : word.toCharArray()) {
				ch[c - 'a']++;

			}
			String s = Arrays.toString(ch);
			System.out.println(s);
			if (map.containsKey(s)) {
				map.get(s).add(word);
			} else {
				List<String> l = new ArrayList<String>();
				l.add(word);
				map.put(s, l);
			}

		}
		list.addAll(map.values());
		return list;
	}

	public static void main(String[] args) {
		List<String> words = new ArrayList<String>();
		words.add("cat");
		words.add("dog");
		words.add("tac");
		words.add("god");
		words.add("act");
		anagramGrouos(words).forEach(x -> {
			System.out.println(x);
		});
		;
		;

	}

}
