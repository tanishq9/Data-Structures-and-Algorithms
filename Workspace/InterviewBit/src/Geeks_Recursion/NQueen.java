package Geeks_Recursion;

public class NQueen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 11;
		boolean[][] board = new boolean[n][n];
		nqueen(board, 0, n);
	}

	private static boolean isSafe(int cr, int cc, boolean[][] board, int n) {
		// Vertically
		for (int i = 0; i < n; i++) {
			if (board[i][cc] == true) {
				return false;
			}
		}
		// Left Diagonal
		int i = cr;
		int j = cc;
		while (i >= 0 && j >= 0) {
			if (board[i][j] == true) {
				return false;
			}
			i--;
			j--;
		}
		// Right Diagonal
		i = cr;
		j = cc;
		while (i >= 0 && j < n) {
			if (board[i][j] == true) {
				return false;
			}
			i--;
			j++;
		}
		return true;
	}

	private static boolean nqueen(boolean[][] board, int row, int n) {
		if (row == n) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] == true) {
						System.out.print("Q");
					} else {
						System.out.print("_");
					}
				}
				System.out.println();
			}
			System.out.println();
			return false;
		}
		for (int col = 0; col < n; col++) {
			if (isSafe(row, col, board, n)) {
				board[row][col] = true;
				boolean nextQueen = nqueen(board, row + 1, n);
				if (nextQueen) {
					return true;
				}
				board[row][col] = false;
			}
		}
		return false;
	}

}
