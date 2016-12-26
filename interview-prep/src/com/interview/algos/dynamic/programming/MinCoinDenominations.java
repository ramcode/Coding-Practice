package com.interview.algos.dynamic.programming;

import java.util.ArrayList;
import java.util.List;

/*
 * Min coin denominations required to acheive given sum
 * dynamic programming as sub problems with least denominations
 *  leads to overall minimum denomination
 *  use bottom approach to fill denominations array
 *  greedy solution won't work as there are no continous denominations from 1....total
 *  i.e denominations[i] = min(denominations[i], 1+denominations[i-coins[j]]) for each coin in coins
 */
public class MinCoinDenominations {

	public static int minCoinDenominations(int[] coins, int sum) {
		if (coins.length == 0 || sum == 0)
			return 0;
		int[] denominations = new int[sum + 1];
		int[] selectedCoins = new int[sum + 1];
		denominations[0] = 0;
		selectedCoins[0] = -1;
		for (int i = 1; i <= sum; i++) {
			denominations[i] = Integer.MAX_VALUE-1;
			selectedCoins[i] = -1;
		}
		for (int i = 0; i < coins.length; i++) {
			for (int j = 1; j < denominations.length; j++) {
				if (j >= coins[i]) {
					if (1 + denominations[j - coins[i]] < denominations[j]) {
						denominations[j] = 1 + denominations[j - coins[i]];
						selectedCoins[j] = i;
					}
				}
			}
		}
		System.out.println(printSelectedCoins(selectedCoins,coins));
		return denominations[sum];
	}
	
	public static List<Integer> printSelectedCoins(int[] selectedCoins, int[] coins){
		List<Integer> coinsList = new ArrayList<Integer>();
		if(coins[coins.length-1]==-1)
			return coinsList;
		int i = selectedCoins.length-1;
		while(i>0){
			coinsList.add(coins[selectedCoins[i]]);
			i = i-coins[selectedCoins[i]];
		}
		return coinsList;
	}

	public static void main(String[] args) {
		System.out.println(minCoinDenominations(new int[] {1,2,5,10}, 249));
	}
	
	

}
