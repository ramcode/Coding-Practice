package com.interview.algos.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortCharsByFreq {
	public String frequencySort(String s) {
		int maxFreq = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
				maxFreq = Math.max(maxFreq, map.get(c));
			} else {
				map.put(c, 1);
			}
		}
		List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());
		Collections.sort(list, new MyComparator());
		StringBuffer sb = new StringBuffer();
		list.stream().forEach(entry -> {
			for (int i = 0; i < entry.getValue(); i++) {
				sb.append(entry.getKey());
			}
		});
		return sb.toString();

	}

	public static String frequencySortByBuckets(String s) {
		int maxFreq = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
			maxFreq = Math.max(maxFreq, map.get(c));
		}
		List<Character>[] buckets = new ArrayList[maxFreq + 1];
		for (Entry<Character, Integer> entry : map.entrySet()) {
			char key = entry.getKey();
			int value = entry.getValue();
			if (buckets[value] == null)
				buckets[value] = new ArrayList<Character>();
			buckets[value].add(key);
		}

		StringBuffer sb = new StringBuffer();
		for (int i = buckets.length - 1; i >= 0; i--) {
			if (buckets[i] != null) {
				for (char c : buckets[i]) {
					for (int j = 0; j < i; j++) {
						sb.append(c);
					}
				}
			}
		}
		return sb.toString();

	}

	public class MyComparator implements Comparator<Map.Entry<Character, Integer>> {
		@Override
		public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
			return e2.getValue() - e1.getValue();
		}
	}
	
	public static void main(String[] args){
		System.out.println(frequencySortByBuckets("dabc"));
	}
}