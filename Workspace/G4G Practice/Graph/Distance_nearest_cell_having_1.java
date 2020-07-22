package Graph;

import java.util.LinkedList;
import java.util.Scanner;

public class Distance_nearest_cell_having_1 {

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

	public static void main(String[] args) {
		char cc = 's';
		System.out.println(cc-'a');
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] dx = { -1, 0, 0, 1 };
		int[] dy = { 0, -1, 1, 0 };
		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] graph = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					graph[i][j] = sc.nextInt();
				}
			}
			// Using BFS
			LinkedList<tr> q = new LinkedList<>();
			boolean[][] visited = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (graph[i][j] == 1) {
						q.add(new tr(i, j, 0));
						graph[i][j] = -1;
					}
				}
			}
			while (q.size() > 0) {
				tr front = q.getFirst();
				q.removeFirst();
				int x = front.x;
				int y = front.y;
				int l = front.lvl;
				if (visited[x][y] == true) {
					continue;
				} else {
					visited[x][y] = true;
				}
				for (int i = 0; i < 4; i++) {
					int px = x + dx[i];
					int py = y + dy[i];
					if (isSafe(px, py, n, m) && visited[px][py] == false && graph[px][py] == 0) {
						graph[px][py] = l + 1;
						q.add(new tr(px, py, l + 1));
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (graph[i][j] == -1) {
						graph[i][j] = 0;
					}
					sb.append(graph[i][j] + " ");
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
		}
	}

	static boolean isSafe(int x, int y, int n, int m) {
		return x >= 0 && y >= 0 && x < n && y < m;
	}

}
