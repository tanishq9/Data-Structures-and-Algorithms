package Graph;

import java.util.Scanner;

public class hamiltonianPath {

	// For Undirected Graph
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[][] graph = new int[n][n];
			int m = sc.nextInt();
			int edges = 2 * m;
			while (edges > 0) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				graph[u - 1][v - 1] = 1;
				graph[v - 1][u - 1] = 1;
				edges -= 2;
			}
			if (dfs(graph, n)) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}

	static boolean hamil = false;

	static boolean dfs(int[][] graph, int n) {
		boolean[] visited = new boolean[n];
		int src = 0;
		int count = 1;
		hamil = false;
		for (int i = 0; i < n; i++) {
			src = i;
			count = 1;
			dfshelper(src, graph, visited, n, count);
			if (hamil == true) {
				return true;
			}
		}
		return false;
	}

	static void dfshelper(int src, int[][] graph, boolean[] visited, int n, int count) {
		if (count == n) {
			hamil = true;
			return;
		}
		visited[src] = true;
		for (int i = 0; i < n; i++) {
			// If there exits an edge from src to i and i is not viisted yet
			if (graph[src][i] == 1 && visited[i] == false) {
				dfshelper(i, graph, visited, n, count + 1);
			}
		}
		visited[src] = false;
	}

}
