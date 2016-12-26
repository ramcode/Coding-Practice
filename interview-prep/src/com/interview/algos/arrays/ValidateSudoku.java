package com.interview.algos.arrays;

import java.util.HashSet;
import java.util.Set;

public class ValidateSudoku {

	public boolean validateSudoku(char[][] board) {
		// validate rows

		for (int i = 0; i < board.length; i++) {
			Set<Character> row = new HashSet<Character>();
			Set<Character> col = new HashSet<Character>();
			Set<Character> block = new HashSet<Character>();
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != '.' && !row.add(board[i][j])) {
					return false;
				}
				if (board[i][j] != '.' && !col.add(board[j][i])) {
					return false;
				}
				int rowIndex = 3 * (i / 3) + j / 3;
				int colIndex = 3 * (j % 3) + j % 3;
				if (board[rowIndex][colIndex] != '.' && !block.add(board[rowIndex][colIndex])) {
					return false;
				}

			}
		}
		return true;

	}

	public boolean validateRowColBlock(char[][] board, int rowStart, int rowEnd, int colStart, int colEnd) {
		Set<Character> set = new HashSet<Character>();
		for (int i = rowStart; i < rowEnd; i++) {
			for (int j = colStart; j < colEnd; j++) {
				if (!set.add(board[i][j])) {
					return false;
				}
			}
		}
		return true;
	}

}
