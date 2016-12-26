package com.interview.algos.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinSwapsToSortArray {
	
	public static int findMinSwapsToSort(int[] ar) {
	    int n = ar.length;
	    Map<Integer, Integer> m = new HashMap<>();
	    for (int i = 0; i < n; i++) {
	        m.put(ar[i], i);
	    }
	    Arrays.sort(ar);
	    for (int i = 0; i < n; i++) {
	        ar[i] = m.get(ar[i]);
	    }
	    m = null;
	    int swaps = 0;
	    for (int i = 0; i < n; i++) {
	        int val = ar[i];
	        if (val < 0) continue;
	        while (val != i) {
	            int new_val = ar[val];
	            ar[val] = -1;
	            val = new_val;
	            swaps++;
	        }
	        ar[i] = -1;
	    }
	    return swaps;
	}
	
	public static void main(String[] args){
		System.out.println(findMinSwapsToSort(new int[]{1, 5, 4, 3, 2}));
	}

}
