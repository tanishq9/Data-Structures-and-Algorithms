package Geeks_Recursion;

import java.util.Scanner;

public class Valid_Sudoku {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int[][] board = new int[9][9];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			if (solveSudoku(board)) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}

	static boolean solveSudoku(int[][] board) {
		int x = -1, y = -1;
		boolean isempty = false;
		// Find the empty cell
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == 0) {
					isempty = true; // that means we found one empty cell
					x = i;
					y = j;
					break;
				}
			}
			if (isempty) {
				break;
			}
		}

		// Indicating it is completely filled now
		if (!isempty) {
			return true;
		}

		// Fill this empty cell
		for (int num = 1; num <= 9; num++) {
			if (isSafe(board, x, y, num)) {
				board[x][y] = num;
				boolean nextCell = solveSudoku(board);
				if (nextCell) {
					return true;
				}
				board[x][y] = 0;
			}
		}
		return false;
	}

	static boolean isSafe(int[][] board, int x, int y, int num) {
		// Row
		for (int i = 0; i < 9; i++) {
			if (board[x][i] == num) {
				return false;
			}
		}
		// Column
		for (int i = 0; i < 9; i++) {
			if (board[i][y] == num) {
				return false;
			}
		}
		// Box
		int rs = x - x % 3;
		int cs = y - y % 3;
		for (int i = rs; i < rs + 3; i++) {
			for (int j = cs; j < cs + 3; j++) {
				if (board[i][j] == num) {
					return false;
				}
			}
		}
		return true;
	}
}
