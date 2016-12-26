package com.mission.interview.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumRange {
	
	    public static List<List<Integer>> combinationSum3(int k, int n) {
	    	int[] candidates = new int[n];
	    	for(int i=1; i<=n; i++){
	    		candidates[i-1] = i;
	    	}
	    	Arrays.sort(candidates);
	    	List<List<Integer>> results = new ArrayList<List<Integer>>();
	    	combinationSum(k, n, candidates,new ArrayList<Integer>(),results, 0);
	    	return results;
	        
	    }
	    
	    private static void combinationSum(int combNo, int target, int[] candidates, List<Integer> res,List<List<Integer>> results, int start){
	    	if(combNo<0){
	    		return;
	    	}
	    	else if(target ==0 && res.size()==combNo){
	    		List<Integer> temp = new ArrayList<Integer>(res);
	    		results.add(temp);
	    	}
	    	else{
	    		for(int i=start;i<candidates.length &&candidates[i]<=target; i++){
	    			res.add(candidates[i]);
	    			combinationSum(combNo, target-candidates[i], candidates, res, results, i+1);
	    			res.remove(res.get(res.size()-1));
	    		}
	    	}
	    }
	    
	    public static void main(String arg[]){
	    	System.out.println(combinationSum3(3, 9));
	    }
}
