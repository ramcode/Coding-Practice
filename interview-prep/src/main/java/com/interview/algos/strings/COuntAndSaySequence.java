package com.interview.algos.strings;

public class COuntAndSaySequence {
	public static String countAndSay(int n) {

		if (n == 0)
			return "";
		String s = "1";
		int loop = 1;
		while (loop < n) {
			StringBuffer sb = new StringBuffer();
			char c = s.charAt(0);
			System.out.println(c);
			int count = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == c) {
					count++;
				} else {
					sb.append(String.valueOf(count) + String.valueOf(c));
					count = 1;
					c = s.charAt(i);
				}
			}
			sb.append(String.valueOf(count) + String.valueOf(c));
			s = sb.toString();
			loop++;
		}
		return s;
	}
	
	public static void main(String[] args){
		System.out.println(countAndSay(5));
	}
}