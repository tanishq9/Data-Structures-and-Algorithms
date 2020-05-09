package RecursionClassics;

public class RatInAMaze {

	static boolean inMaze(String[] maze, int[][] soln, int i, int j, int m, int n) {
		if (i == m && j == n) {
			soln[m][n] = 1;
			// Print Path
			for (int r = 0; r <= m; r++) {
				for (int c = 0; c <= n; c++) {
					System.out.print(soln[r][c]);
				}
				System.out.println();
			}
			System.out.println();
			soln[m][n] = 0;
			return false;
		}
		// Rat should be inside the grid
		if (i > m || j > n) {
			return false;
		}
		// Dead end
		if (maze[i].charAt(j) == 'X') {
			return false;
		}
		// Assume solution exists
		soln[i][j] = 1;
		boolean right = inMaze(maze, soln, i, j + 1, m, n);
		boolean down = inMaze(maze, soln, i + 1, j, m, n);
		// Backtracking
		soln[i][j] = 0;
		if (right || down) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String[] arr = { "0000", "00X0", "000X", "0X00" };
		int m = 4, n = 4;
		int[][] soln = new int[m][n];
		boolean ans = inMaze(arr, soln, 0, 0, m - 1, n - 1);
		System.out.println(ans);
	}

}
