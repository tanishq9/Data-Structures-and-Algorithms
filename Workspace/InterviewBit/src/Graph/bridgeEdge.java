package Graph;

import java.util.ArrayList;

// For edge uv that is removed, check if by calling dfs on u , if v is reachable
// or not , if reachable then the edge was not a bridge edge
public class bridgeEdge {
	class Graph {
		int v; // Number of vertices
		int e; // Number of edges

		ArrayList<Integer>[] edges;
		// Edges are given as adjacency list
		// edges[i].get(j) gives the jth neighbour of i.
	}

	public void isBridge(Graph g, int u, int v) {
		int n = g.v;
		boolean[] visited = new boolean[n];
		// Remove the edge
		int ru = -1, rv = -1;
		for (int i = 0; i < g.edges[u].size(); i++) {
			if (g.edges[u].get(i) == v) {
				ru = i;
				break;
			}
		}
		for (int i = 0; i < g.edges[v].size(); i++) {
			if (g.edges[v].get(i) == u) {
				rv = i;
				break;
			}
		}
		g.edges[u].remove(ru);
		g.edges[v].remove(rv);
		// Do DFS
		dfs(g, visited, u);
		if (visited[v] == false) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	void dfs(Graph g, boolean[] visited, int src) {
		visited[src] = true;
		for (int i = 0; i < g.edges[src].size(); i++) {
			int n = g.edges[src].get(i);
			if (visited[n] == false) {
				dfs(g, visited, n);
			}
		}
	}
}
