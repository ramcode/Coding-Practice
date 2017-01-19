package com.interview.algos.math;

public class PalindromicNumber {
	
	   public static boolean isPalindrome(int x) {
	        if(x<=0) return false;
	        int num = x;
	        int rev = 0;
	        while(num>rev){
	            rev = rev*10 + num%10;
	            num/= 10;
	        }
	        return num == rev || num == rev/10;
	    }
	   
	   public static void main(String[] args){
		   System.out.println(isPalindrome(100));
	   }

}
