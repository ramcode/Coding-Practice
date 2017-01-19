package com.interview.algos.strings;

import java.util.Stack;

public class DecodeString {

	public static String decodeString(String input) {
		int i = 0;
		String res = "";
		Stack<Integer> countStack = new Stack<Integer>();
		Stack<String> strStack = new Stack<String>();
		while (i < input.length()) {
			char c = input.charAt(i);
			if (Character.isDigit(c)) {
				int num = 0;
				while (Character.isDigit(input.charAt(i))) {
					num = num * 10 + (input.charAt(i) - '0');
					i++;
				}
				countStack.push(num);
			} else if (c == '[') {
				strStack.push(res);
				res = "";
				i++;
			} else if (c == ']') {
				StringBuilder str = new StringBuilder(strStack.pop());
				int count = countStack.pop();
				for (int j = 0; j < count; j++) {
					str.append(res);
				}
				res = str.toString();
				i++;
			} else {
				res = res + input.charAt(i);
				i++;
			}
		}
		return res;
	}
	
	public static void main(String[] ags){
		System.out.println(decodeString("2[a]3[ac2[b]]"));
	}

}
