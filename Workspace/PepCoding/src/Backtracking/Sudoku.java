package Backtracking;

import java.util.Scanner;

public class Sudoku {

	public static void main(String[] args) {
		// Check if same number is not repeated in same row or column
		// If yes, backtrack and put some other number there
		// Keep doing until you achieve completely filled board
		Scanner sc = new Scanner(System.in);
		int[][] board = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board[i][i] = sc.nextInt();
			}
		}
		solve(board);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][i] + " ");
			}
		}
	}

	private static void solve(int[][] board) {

	}

}
