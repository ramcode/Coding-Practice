package com.interview.algos.backtracking;

import java.util.ArrayList;
import java.util.List;

public class WordSearchBoard {
	public static boolean exist(char[][] board, String word) {
		if (word == null || word.length() == 0 || word.length() > board.length * board[0].length)
			return false;
		char start = word.charAt(0);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == start) {
					if (checkWord(board, i, j, word, 0))
						return true;
				}
			}
		}
		return false;
	}

	public static boolean checkWord(char[][] board, int i, int j, String word, int charIndex) {
		if (charIndex == word.length())
			return true;
		if (i == board.length || j == board[0].length || i < 0 || j < 0)
			return false;
		char c = board[i][j];
		if (board[i][j] != '*' && board[i][j] == word.charAt(charIndex)) {
			board[i][j] = '*';
			charIndex++;
		} else {
			return false;
		}

		boolean result = checkWord(board, i + 1, j, word, charIndex) || checkWord(board, i, j + 1, word, charIndex)
				|| checkWord(board, i - 1, j, word, charIndex) || checkWord(board, i, j - 1, word, charIndex);

		if (board[i][j] == '*')
			board[i][j] = c;
		return result;
	}

	public static void main(String[] args) {
		System.out.println(exist(
				new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'E', 'S' }, { 'A', 'D', 'E', 'E' } }, "ABCESEEEFS"));
	}
}