package com.interview.algos.dynamic.programming;

public class GuessNumberDynamicProgramming {

	public int getMoneyAmount(int n) {
		int[][] amount = new int[n + 1][n + 1];
		for (int i = 1; i < n + 1; i++) {
			for (int from = 1, to = from + i; to <= n; from++, to++) {
				amount[from][to] = Integer.MAX_VALUE;
				if (to - from == 1) {
					amount[from][to] = from;
				} else {
					for (int split = from + 1; split < to; split++) {
						amount[from][to] = Math.min(amount[from][to],
								split + Math.max(amount[from][split - 1], amount[split + 1][to]));
					}
				}
			}
		}
		return amount[1][n];
	}

	public static void main(String[] args) {
		GuessNumberDynamicProgramming guess = new GuessNumberDynamicProgramming();
		System.out.println(guess.getMoneyAmount(7));
	}

}
