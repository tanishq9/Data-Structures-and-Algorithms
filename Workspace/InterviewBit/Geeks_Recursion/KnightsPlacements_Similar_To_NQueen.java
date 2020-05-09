package Geeks_Recursion;

public class KnightsPlacements_Similar_To_NQueen {

	public static void main(String[] args) {
		int n = 2, m = 3, k = 2;
		boolean[][] visited = new boolean[n][m];
		knights(visited, n, m, k);
		System.out.println(count);
		int res = m * n * (m * n - 1);
		if (m > 1 && n > 1)
			res = res - 4 * (2 * m * n - 3 * n - 3 * m + 4);
	}

	static int[] dx = { 2, 2, 1, 1, -1, -1, -2, -2 };
	static int[] dy = { 1, -1, 2, -2, 2, -2, 1, -1 };
	static int count = 0;

	private static boolean withinBounds(int nx, int ny, int n, int m) {
		return nx >= 0 && ny >= 0 && nx < n && ny < m;
	}

	private static boolean isSafe(boolean[][] visited, int px, int py, int n, int m) {
		for (int i = 0; i < 8; i++) {
			int nx = px + dx[i];
			int ny = py + dy[i];
			if (withinBounds(nx, ny, n, m) && visited[nx][ny] == true) {
				return false;
			}
		}
		return true;
	}

	private static boolean knights(boolean[][] visited, int n, int m, int k) {
		if (k == 0) {
			count++;
			int num = 1;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (visited[i][j] == true) {
						System.out.print("K" + num + "  ");
						num++;
					} else {
						System.out.print("*" + "  ");
					}
				}
				System.out.println();
			}
			System.out.println();
			return false;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j] == false && isSafe(visited, i, j, n, m)) {
					visited[i][j] = true;
					boolean nextKnight = knights(visited, n, m, k - 1);
					if (nextKnight) {
						return true;
					}
					visited[i][j] = false;
				}
			}
		}
		return false;
	}

}
