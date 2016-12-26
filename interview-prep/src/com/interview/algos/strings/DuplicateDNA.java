package com.interview.algos.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DuplicateDNA {

	// using brute force
	public List<String> findRepeatedDnaSequencesBF(String s) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		List<String> list = new ArrayList<String>();
		for (int i = 0; i <= s.length() - 10; i++) {
			String sub = s.substring(i, i + 10);
			if (!map.containsKey(sub)) {
				map.put(sub, 1);
			} else {
				map.put(sub, map.get(sub) + 1);
			}
		}
		map.entrySet().stream().forEach(x -> {
			if (x.getValue() > 1) {
				list.add(x.getKey());
			}
		});

		return list;

	}

	// using bits

	public List<String> findRepeatedDnaSequences(String s) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Set<Integer> seen = new HashSet<Integer>();
		Set<String> res = new HashSet<String>();
		map.put('A' - 'A', 0);
		map.put('T' - 'A', 1);
		map.put('G' - 'A', 2);
		map.put('C' - 'A', 3);
		for (int i = 0; i <= s.length() - 10; i++) {
			int bit = 0;
			for (int j = i; j < i + 10; j++) {
				bit <<= 2;
				bit = bit | map.get(s.charAt(j) - 'A');
			}
			if (!seen.add(bit)) {
				res.add(s.substring(i, i + 10));
			}
		}
		return new ArrayList<String>(res);
	}
}