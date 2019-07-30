package Graph;

import java.util.Scanner;

public class TravellingSalesman {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[][] graph = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					graph[i][j] = sc.nextInt();
				}
			}
			minCost(graph, n);
		}
	}

	static int min = Integer.MAX_VALUE;

	static void minCost(int[][] graph, int n) {
		boolean[] visited = new boolean[n];
		int src = 0;
		min = Integer.MAX_VALUE;
		dfs(src, src, graph, visited, n, 1, 0);
		System.out.println(min);
	}

	static void dfs(int src, int current_source, int[][] graph, boolean[] visited, int n, int count, int cost) {
		if (count == n) {
			if (graph[current_source][src] != 0) {
				min = Math.min(min, cost + graph[current_source][src]);
			}
			return;
		}
		visited[current_source] = true;
		for (int i = 0; i < n; i++) {
			if (graph[current_source][i] != 0 && visited[i] == false) {
				dfs(src, i, graph, visited, n, count + 1, cost + graph[current_source][i]);
			}
		}
		visited[current_source] = false;
	}

}
