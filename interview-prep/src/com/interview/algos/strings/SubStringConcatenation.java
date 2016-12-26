package com.interview.algos.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubStringConcatenation {

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> indices = new ArrayList<Integer>();
		if (s == null || words.length == 0 || s.length() < words.length * words[0].length())
			return indices;
		Map<String, Integer> wordCount = new HashMap<String, Integer>();
		for (String word : words) {
			if (wordCount.containsKey(word)) {
				wordCount.put(word, wordCount.get(word) + 1);
			} else {
				wordCount.put(word, 1);
			}
		}
		int w = words.length, l = s.length(), m = words[0].length();
		for (int i = 0; i < l - w * m + 1; i++) {
			Map<String, Integer> map = new HashMap<String, Integer>(wordCount);
			for (int j = 0; j < w * m; j = j + m) {
				String sub = s.substring(i+j, i+j + m);
				if (!map.containsKey(sub)) {
					break;
				} else if (map.get(sub) > 1) {
					map.put(sub, map.get(sub) - 1);
				} else if (map.get(sub) == 1)
					map.remove(sub);
			}
			if (map.size() == 0)
				indices.add(i);
		}
		return indices;
	}

	public static void main(String[] args) {

		SubStringConcatenation sb = new SubStringConcatenation();
		System.out.println(sb.findSubstring("barfoothefoobarman", new String[] { "foo", "bar" }));

	}

}
