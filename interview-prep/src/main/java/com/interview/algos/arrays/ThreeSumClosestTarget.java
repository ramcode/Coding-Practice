package com.interview.algos.arrays;

import java.util.Arrays;

public class ThreeSumClosestTarget {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0;
        int diff = Integer.MAX_VALUE;
        int minSum = 0;
        while(i<nums.length){
            int a = nums[i];
            int j=i+1, k = nums.length-1;
            while(j<k){
                int b = nums[j], c = nums[k];
                int sum = a+nums[j]+nums[k];
                if(Math.abs(sum-target)<diff){
                    diff = Math.abs(sum-target);
                    minSum = sum;
                }
                if(sum<=target){
                    while(j<k && nums[j]==b){
                        j++;
                    }
                }
                if(sum>=target){
                    while(j<k && nums[k]==c){
                        k--;
                    }
                }
            }
            while(i<nums.length && nums[i]==a){
                i++;
            }
            
        }
        return minSum;
        
    }
    
    public static void main(String[] args){
    	System.out.println(threeSumClosest(new int[]{-1 ,2, 1, -4}, 1));
    }
}