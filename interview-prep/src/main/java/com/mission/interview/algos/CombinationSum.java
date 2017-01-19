package com.mission.interview.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CombinationSum {

	public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(candidates);
		addUp(candidates, 0, target, new ArrayList<Integer>(), results);
		return results;
	}

	private static void addUp(int[] candidates, int start, int target, ArrayList<Integer> path,
			ArrayList<ArrayList<Integer>> results) {
		if (start < 0 || target < 0)
			return;

		if (0 == target) {
			ArrayList<Integer> res = new ArrayList<Integer>(path);
			results.add(res);
		} else {
			for (int i = start; i < candidates.length && candidates[i] <= target; ++i) {
				// if (candidates[i] > target) continue; // if we don't sort the
				// data at the beginning, we skip large numbers here
				path.add(candidates[i]);
				addUp(candidates, i, target - candidates[i], path, results);
				path.remove(path.size() - 1);
			}
		}
	}

	public static List<List<Integer>> returnCombSumsTarget(List<Integer> candidates, Integer target) {

		List<List<Integer>> results = new ArrayList<List<Integer>>();
		List<Integer> combs = new ArrayList<Integer>();
		candidates.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 == o2) {
					return 0;
				} else if (o1 < o2) {
					return -1;

				} else {
					return 1;
				}
			}

		});
		returnCombs(candidates, target, combs, results, 0);
		return results;

	}

	private static void returnCombs(List<Integer> candidates, Integer target, List<Integer> combs,
			List<List<Integer>> results, Integer start) {
		if (start <0 || target < 0) {
			return;
		} else if (target == 0) {
			List<Integer> res = new ArrayList<Integer>(combs);
			results.add(res);
		} else {
			for (int i = start; i < candidates.size() && candidates.get(i) <= target; ++i) {
				combs.add(candidates.get(i));
				returnCombs(candidates, target - candidates.get(i), combs, results, i+1);
				combs.remove(combs.get(combs.size() - 1));
			}
		}
	}

	public static void main(String arg[]) {
		List<Integer> list = Arrays.asList(new Integer[] { 2, 3, 6, 7 });
		System.out.println(returnCombSumsTarget(list, 7));
		//System.out.println(combinationSum(new int[] { 2, 3, 6, 7 }, 7));
	}

}
