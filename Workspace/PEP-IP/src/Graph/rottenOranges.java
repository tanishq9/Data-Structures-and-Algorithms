package Graph;

import java.util.LinkedList;
import java.util.Scanner;

public class rottenOranges {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		/*
		 * 1 8 7 0 1 0 0 0 1 0 1 1 1 0 0 1 1 0 2 0 0 0 1 0 0 0 0 1 1 1 0 0 1 0 2 1 0 0 2
		 * 1 0 0 1 1 0 0 1 1 0 0 0 0 0 0 1 1 1 1 0
		 */

		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] graph = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					graph[i][j] = sc.nextInt();
				}
			}
			System.out.println(bfs(graph, n, m));
		}
	}

	static class tr {
		int x;
		int y;
		int lvl;

		tr(int ix, int iy, int il) {
			this.x = ix;
			this.y = iy;
			this.lvl = il;
		}
	}

	static boolean isSafe(int x, int y, int n, int m) {
		return x >= 0 && y >= 0 && x < n && y < m;
	}

	private static int bfs(int[][] graph, int n, int m) {

		LinkedList<tr> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];

		int lvl = 0;

		int[] dx = { -1, 0, 0, 1 };
		int[] dy = { 0, -1, 1, 0 };

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (graph[i][j] == 2) {
					q.addLast(new tr(i, j, 0));
				}
			}
		}
		while (q.size() > 0) {
			// Get
			tr front = q.getFirst();
			int currx = front.x;
			int curry = front.y;
			int currl = front.lvl;
			// Remove
			q.removeFirst();
			// Mark
			if (visited[currx][curry] == true) {
				continue;
			} else {
				visited[currx][curry] = true;
			}
			// Work
			lvl = Math.max(lvl, currl);
			// Add neighboring cells
			for (int i = 0; i < 4; i++) {
				int px = currx + dx[i];
				int py = curry + dy[i];
				if (isSafe(px, py, n, m) && graph[px][py] == 1 && visited[px][py] == false) {
					graph[px][py] = 2; // Mark it rot
					q.addLast(new tr(px, py, currl + 1));
				}
			}
		}

		// Check if any fresh oranges are left
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (graph[i][j] == 1) {
					return -1;
				}
			}
		}
		return lvl;
	}

}
