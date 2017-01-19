package com.practice.interview.java.snippets;


/**
 * final class can't be subclassed....PrivateChild extends PrivateClass ---> not allowed
 * @author VenkataRamesh
 *
 */
final class PrivateClass {
	
	public static void main(String[] args){
		PrivateClass pc = new PrivateClass();
	}

}
