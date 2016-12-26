package com.interview.algos.math;

import java.util.HashMap;
import java.util.Map;

public class NumnberToWord {
	
	static String[] lessThan20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteeen", "Ninteen"};
    static String[] lessThan100 = new String[] {"", "", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninenty"};
    static String[] hundreds = new String[] {"", "Thousand", "Million", "Billion"};

	public static String numToWord(int num) {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(4, "Four");
		map.put(5, "Five");
		map.put(6, "Six");
		map.put(7, "Seven");
		map.put(8, "Eight");
		map.put(9, "Nine");
		map.put(0, "Zero");
		map.put(10, "Ten");
		map.put(11, "Eleven");
		map.put(12, "Twelve");
		map.put(13, "Thirteen");
		map.put(14, "Fourteen");
		map.put(15, "Fifteen");
		map.put(16, "Sixteen");
		map.put(17, "Seventeen");
		map.put(18, "Eighteen");
		map.put(19, "Ninteen");
		map.put(20, "Twenty");
		map.put(30, "Thirty");
		map.put(40, "Fourty");
		map.put(50, "Fifty");
		map.put(60, "Sixty");
		map.put(70, "Seventy");
		map.put(80, "Eighty");
		map.put(90, "Ninty");
		map.put(100, "Hundred");
		map.put(1000, "Thousand");
		map.put(1000000, "Million");
		map.put(100000000, "Billion");
		StringBuffer sb = new StringBuffer();
		int fac = 1;
		while(num>0){
			int lastThree = num%1000;
			int mul = fac;
			while(lastThree>0){
				int key = lastThree%10;
				boolean check = (mul/10) >= 10;
				if(!check){
					key = key*mul;
				}
				sb.insert(0, map.get(key)+" "+(check?map.get(mul)+" ":""));
				lastThree = lastThree/10;
				mul = mul*10;
			}
			fac = fac*1000;
			num = num/1000;
		}
		return sb.toString();
	}
	  public static String numberToWords(int num) {
	        if(num==0) return "Zero";
	        StringBuffer sb = new StringBuffer();
	        int i=0;
	        while(num>0){
	            if(num%1000>0){
	                sb.insert(0, getThreeDigitWord(num%1000)+" "+hundreds[i]+" ");
	            }
	            i++;
	            num = num/1000;
	        }
	        return sb.toString().trim();
	    }
	
	 public static String getThreeDigitWord(int num){
		 System.out.println(num);
	        if(num==0) return "";
	        if(num>0 && num <20) return lessThan20[num];
	        if(num>=20 && num<=99) return lessThan100[num/10] +" " + getThreeDigitWord(num%10);
	        else return lessThan20[num/100] + " Hundred "+getThreeDigitWord(num%100);
	    }
	
	public static void main(String[] args){
		System.out.println(numberToWords(10022001));
	}

}
