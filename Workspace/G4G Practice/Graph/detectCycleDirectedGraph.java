package Graph;

import java.util.ArrayList;

public class detectCycleDirectedGraph {

	static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V) {
		boolean[] visited = new boolean[V];
		boolean[] recStack = new boolean[V];
		// Checking for each component
		for (int i = 0; i < V; i++) {
			if (visited[i] == false) {
				if (helper(i, list, visited, recStack) == true) {
					return true;
				}
			}
		}
		return false;
	}

	static boolean helper(int src, ArrayList<ArrayList<Integer>> graph, boolean[] visited, boolean[] recStack) {
		visited[src] = true;
		recStack[src] = true;
		for (int i = 0; i < graph.get(src).size(); i++) {
			int n = graph.get(src).get(i);
			if (recStack[n] == true) {
				return true;
			}
			if (visited[n] == false) {
				if (helper(n, graph, visited, recStack)) {
					return true;
				}
			}
		}
		recStack[src] = false;
		return false;
	}

}
