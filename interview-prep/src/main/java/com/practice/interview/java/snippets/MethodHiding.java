package com.practice.interview.java.snippets;

public class MethodHiding {

	public static void print() {
		System.out.println("printing from parent class");
	}
	
	public static void main(String[] args){
		MethodHiding hiding = new MethodHidingChild();
		hiding.print();
	}

}
