package com.interview.algos.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ThirdMaxArray {
    public static int thirdMax(int[] nums) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Double.NEGATIVE_INFINITY);
        int max1 = Integer.MIN_VALUE, max2=Integer.MIN_VALUE, max3=Integer.MIN_VALUE;
        for(int a:nums){
            if(a>max1){
                max3 = max2;
                max2 = max1;
                max1 = a;
            }
            else if(a>max2){
                max3 = max2;
                max2 = a;
            }
            else if(a>max3){
                max3 = a;
            }
        }
        if(max3!=Integer.MIN_VALUE) return max3;
        else return max1;
    }
    
    public static int thridMaxWithoutDups(int[] nums){
    	Set<Integer> set = new HashSet<Integer>();
    	for(int a: nums){
    		set.add(a);
    	}
    	Integer[] arr = set.toArray(new Integer[0]);
    	return arr[arr.length-3];
    }
    
    public static void main(String[] args){
    	System.out.println(thridMaxWithoutDups(new int[]{1,2,2,3,5}));
    }
}