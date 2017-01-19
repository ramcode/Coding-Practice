package com.interview.algos.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DelimiterMatching {
	
	public static boolean isValidExpression(String exp){
		if (exp.length()==0 || exp.length()==1)
				return false;
		List<Character> delimiters = new ArrayList<Character>();
		delimiters.addAll(Arrays.asList(new Character[]{'(', ')', '{', '}', '[', ']'}));
		Stack<Character> stack = new Stack<Character>();
		for(int i=0 ;i <exp.length(); i++){
			Character ele = exp.charAt(i);
			if(!delimiters.contains(ele)){
				continue;
			}
			else if(ele=='('|| ele=='['||ele=='{' ){
				stack.push(ele);
				continue;
			}
			else if(ele==')'|| ele=='}'||ele==']'){
				Character elemat = stack.pop();
				if(elemat!=ele)
					return false;
				else{
					continue;
				}
			}
			return stack.size()==0;
			
		}
		return false;
	}

}
