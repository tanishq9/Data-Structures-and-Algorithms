package Graph;

import java.util.ArrayList;

public class pathFromSrcToDest {

	class Graph {
		int v; // Number of vertices
		int e; // Number of edges

		ArrayList<Integer>[] edges;
		// Edges are given as adjacency list
		// edges[i].get(j) gives the jth neighbour of i.
	}

	static int count = 0;

	public int pathCount(Graph g, int src, int des) {
		boolean[] visited = new boolean[g.v];
		count = 0;
		dfs(g, visited, src, des);
		return count;
	}

	private void dfs(Graph g, boolean[] visited, int src, int dest) {
		if (src == dest) {
			count += 1;
			return;
		}
		visited[src] = true;
		for (int i = 0; i < g.edges[src].size(); i++) {
			int n = g.edges[src].get(i);
			if (visited[n] == false) {
				dfs(g, visited, n, dest);
			}
		}
		visited[src] = false;
	}
}