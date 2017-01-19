package com.interview.ds.linkedlist;

public class CheckLLPalindromeRecursive {
	
	public static Node head;
	public static boolean isPlaindrome(Node node){
		head = node;
		return checkPalindrome(node);
	}
	
	public static boolean checkPalindrome(Node node){
		if(node==null) return true;
		boolean test = checkPalindrome(node.next);
		if(!test) return false;
		boolean isP = head.val == node.val;
		head = head.next;
		return isP;
	}
	
	public static void main(String[] args){
		LinkedList l1 = new LinkedList();
		l1.insert(5);
		l1.insert(1);
		l1.insert(3);
		l1.insert(1);
		l1.insert(5);
		System.out.println(isPlaindrome(l1.head));
	}

}
