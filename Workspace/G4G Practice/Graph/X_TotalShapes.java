package Graph;
/*package whatever //do not write package name here */

import java.util.*;

public class X_TotalShapes {
	// DFS Approach used for finding connected components
	// BFS Approach used in number islands
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			char[][] graph = new char[n][m];
			for (int i = 0; i < n; i++) {
				String s = sc.next();
				graph[i] = s.toCharArray();
			}
			System.out.println(dfs(graph, n, m));
		}
	}

	static int dfs(char[][] graph, int n, int m) {
		boolean[][] visited = new boolean[n][m];
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j] == false && graph[i][j] == 'X') {
					dfshelper(i, j, graph, n, m, visited);
					count++;
				}
			}
		}
		return count;
	}

	static boolean isSafe(int x, int y, int n, int m) {
		return x >= 0 && y >= 0 && x < n && y < m;
	}

	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	static void dfshelper(int x, int y, char[][] graph, int n, int m, boolean[][] visited) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int px = x + dx[i];
			int py = y + dy[i];
			if (isSafe(px, py, n, m) && visited[px][py] == false && graph[px][py] == 'X') {
				dfshelper(px, py, graph, n, m, visited);
			}
		}
	}
}
