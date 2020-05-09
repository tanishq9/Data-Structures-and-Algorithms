package RecursionClassics;

import java.util.ArrayList;

public class NQueens2DList {

	public class Solution {

		ArrayList<ArrayList<String>> res = null;

		public ArrayList<ArrayList<String>> solveNQueens(int a) {
			int[][] arr = new int[a][a];
			int currentrow = 0;
			res = new ArrayList<ArrayList<String>>();
			queens(arr, currentrow, a);
			return res;
		}

		private boolean queens(int[][] board, int cr, int n) {
			ArrayList<String> arr = new ArrayList<String>();
			StringBuilder sb = new StringBuilder();
			if (cr == n) {
				// Print Board
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (board[i][j] == 1) {
							sb.append("Q");
						} else {
							sb.append(".");
						}
					}
					if (i != n - 1) {
						sb.append(" ");
					}
				}
				arr.add(sb.toString());
				res.add(arr);
				return false;
			}
			for (int cc = 0; cc < n; cc++) {
				if (isSafe(board, cr, cc, n)) {
					board[cr][cc] = 1;
					boolean nextQueenRakhPaaye = queens(board, cr + 1, n);
					if (nextQueenRakhPaaye) {
						return true;
					} else {
						board[cr][cc] = 0;
					}
				}
			}
			return false; // Agar nahi rakh paaye toh
		}

		private boolean isSafe(int[][] queens, int i, int j, int n) {

			// Check vertically
			for (int r = 0; r < n; r++) {
				if (queens[r][j] == 1) {
					return false;
				}
			}
			// Left Diagonal
			int x = i;
			int y = j;
			while (x >= 0 && y >= 0) {
				if (queens[x][y] == 1) {
					return false;
				}
				x--;
				y--;
			}
			x = i;
			y = j;
			// Right Diagonal
			while (x >= 0 && y < n) {
				if (queens[x][y] == 1) {
					return false;
				}
				x--;
				y++;
			}

			return true;
		}
	}

}
