package Graph;

import java.util.Scanner;
import java.util.Stack;

public class headToTailOrdering {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Check for Eulerian Path
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			String[] strs = new String[n];
			for (int i = 0; i < n; i++) {
				strs[i] = sc.next();
			}
			if (canBeOrdered(strs)) {
				System.out.println("Head to tail ordering is possible.");
			} else {
				System.out.println("Head to tail ordering is not possible.");
			}
		}
	}

	static boolean canBeOrdered(String[] strs) {
		int[][] graph = new int[26][26];
		int[] ind = new int[26];
		int[] outd = new int[26];
		boolean[] mark = new boolean[26];
		for (int i = 0; i < strs.length; i++) {
			int u = strs[i].charAt(0) - 'a';
			int v = strs[i].charAt(strs[i].length() - 1) - 'a';
			graph[u][v] = 1;
			ind[v]++;
			outd[u]++;
			mark[u] = true;
			mark[v] = true;
		}
		// Test 1 : in and out same except two vertex
		int start = 0, end = 0;
		int s = -1, e = -1;
		for (int i = 0; i < 26; i++) {
			// System.out.println(i + " " + ind[i] + "," + outd[i]);
			if (ind[i] != outd[i]) {
				// Case 1 : Start vertex
				if (outd[i] == ind[i] + 1) {
					s = i;
					start += 1;
				}
				// Case 2 : End vertex
				if (outd[i] + 1 == ind[i]) {
					end += 1;
					e = i;
				}
			} else if (ind[i] == outd[i]) {
				continue;
			}
		}
		// System.out.println(start + " " + end);
		if (start == 1 && end == 1) {
			// Cool
		} else {
			return false;
		}
		// Add edge from end to start such that all in degree and out degree are same
		graph[e][s] = 1;
		// Test 2 : Use kosaraju
		return isConnected(graph, mark, strs[0].charAt(0) - 'a');
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
		// System.out.println(components);
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
