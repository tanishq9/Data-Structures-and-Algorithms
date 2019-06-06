package Graph;

import java.util.*;

public class circle_of_strings {
	// Based on concept of Euler circuit
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			String[] strs = new String[n];
			for (int i = 0; i < n; i++) {
				strs[i] = sc.next();
			}
			if (canBeChained(strs)) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}

	static boolean canBeChained(String[] strs) {
		int[][] graph = new int[26][26];
		boolean[] visited = new boolean[26];
		int[] indegree = new int[26];
		int[] outdegree = new int[26];
		// Add edge in graph for every string
		for (int i = 0; i < strs.length; i++) {
			int u = strs[i].charAt(0) - 'a';
			int v = strs[i].charAt(strs[i].length() - 1) - 'a';
			// Add edge
			graph[u][v] = 1;
			// Update indegree and outdegree & the visited array
			visited[u] = true;
			visited[v] = true;
			outdegree[u]++;
			indegree[v]++;
		}
		// First essential condition : Check if in and out degree for all vertices is
		// same
		for (int i = 0; i < 26; i++) {
			if (indegree[i] != outdegree[i]) {
				return false;
			}
		}
		// Second essential condition : Check using kosaraju for SCC
		// Pass the starting vertex as first char of first string
		return isConnected(graph, visited, strs[0].charAt(0) - 'a');
	}

	static boolean isConnected(int[][] graph, boolean[] mark, int start) {
		// Build revStack
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[26];
		// Perform DFS from source
		fillStack(graph, visited, start, stack);
		// Check if the all the chars which are marked are also visited in dfs
		// because for SCC , we need to be sure that we are considering all the chars
		for (int i = 0; i < 26; i++) {
			if (mark[i] && !visited[i]) {
				return false;
			}
		}
		// Find the Transpose of graph
		int[][] gt = new int[26][26];
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 26; j++) {
				if (graph[i][j] == 1) {
					gt[j][i] = 1;
				}
			}
		}
		// Now find number of components using stack and gt
		int components = 0;
		visited = new boolean[26];
		while (stack.size() > 0) {
			int v = stack.pop();
			if (visited[v] == false) {
				dfs(gt, visited, v);
				components++;
			}
		}
		return components == 1;
	}

	static void dfs(int[][] graph, boolean[] visited, int source) {
		visited[source] = true;
		for (int i = 0; i < 26; i++) {
			if (graph[source][i] == 1 && visited[i] == false) {
				dfs(graph, visited, i);
			}
		}
	}

	static void fillStack(int[][] graph, boolean[] visited, int source, Stack<Integer> stack) {
		visited[source] = true;
		for (int i = 0; i < 26; i++) {
			if (graph[source][i] == 1 && visited[i] == false) {
				fillStack(graph, visited, i, stack);
			}
		}
		stack.push(source);
	}

}
