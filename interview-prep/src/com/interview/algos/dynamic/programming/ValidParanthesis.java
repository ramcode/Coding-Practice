package com.interview.algos.dynamic.programming;

import java.util.ArrayList;
import java.util.List;

public class ValidParanthesis {
	
	public static List<String> generateValidParanthesis(int count){
		List<String> paran = new ArrayList<String>();
		generateParan(paran, count, count, new char[2*count], 0);
		return paran;
		
	}
	
	public static void generateParan(List<String> paran, int leftCount, int rightCount,char[] array, int count){
		if(leftCount==0 && rightCount==0){
			paran.add(String.copyValueOf(array));
		}
		else if(leftCount<0 || leftCount>rightCount){
			return;
		}
		else {
			if(leftCount>0){
				array[count] = '(';
				generateParan(paran, leftCount-1, rightCount, array, count+1);
			}
			if(leftCount<rightCount){
				array[count] = ')';
				generateParan(paran, leftCount, rightCount-1, array, count+1);
			}
		}
	}
	public static void main(String[] args){
		System.out.println(generateValidParanthesis(3));
	}
}
