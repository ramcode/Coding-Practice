package com.practice.interview.java.snippets;

public class StaticVariables {
	
	private final String instanceVariable = "I_AM_FINAL";
	private static String classVariable;
	
	public static String accessInstanceVariable(){
		return new StaticVariables().classVariable;
	}
	
	public static void main(String[] args){
		StaticVariables stats  = new StaticVariables();
		stats.instanceVariable = "I AM NOT FINAL";
	}

}
