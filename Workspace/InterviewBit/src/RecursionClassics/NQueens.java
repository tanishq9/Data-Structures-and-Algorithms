package RecursionClassics;

import java.util.ArrayList;

public class NQueens {

	public static void main(String[] args) {
		int[][] queens = new int[4][4];
		nq(queens, 0, 4);
		ArrayList<Integer> l = new ArrayList<>();
		l.get(0);
	}

	static boolean nq(int[][] queens, int currentRow, int n) {
		if (currentRow == n) {
			// Queen has been placed
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (queens[i][j] == 1) {
						System.out.print("0");
					} else {
						System.out.print("-");
					}
				}
				System.out.println();
			}
			System.out.println();
			return false;
		}
		// Recursive Case
		for (int currentCol = 0; currentCol < 4; currentCol++) {
			// Lets check if i,j is a safe position or not
			if (isSafe(queens, currentRow, currentCol, n)) {
				// Place the queen - Assuming i,j is the right position
				queens[currentRow][currentCol] = 1;

				boolean nextQueenRakhPaaye = nq(queens, currentRow + 1, n);
				if (nextQueenRakhPaaye) {
					return true;
				} else {
					// Means i,j is not the right position , assumption is wrong
					queens[currentRow][currentCol] = 0; // Backtrack
				}
			}
		}
		// You have tried for all positions but could not place the queen
		return false;
	}

	private static boolean isSafe(int[][] queens, int i, int j, int n) {

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
