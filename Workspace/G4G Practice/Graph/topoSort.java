package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class topoSort {

	static int[] topoSort(ArrayList<ArrayList<Integer>> list, int N) {
		boolean[] visited = new boolean[N];
		Stack<Integer> ordering = new Stack<>();
		// For each component
		for (int i = 0; i < N; i++) {
			if (visited[i] == false) {
				helper(i, list, visited, ordering);
			}
		}
		int[] order = new int[N];
		int idx = 0;
		while (ordering.size() > 0) {
			order[idx++] = ordering.pop();
		}
		return order;
	}

	static void helper(int src, ArrayList<ArrayList<Integer>> graph, boolean[] visited, Stack<Integer> order)

	{
		visited[src] = true;
		for (int i = 0; i < graph.get(src).size(); i++) {
			Integer ngbr = graph.get(src).get(i);
			if (visited[ngbr] == false) {
				helper(ngbr, graph, visited, order);
			}
		}
		order.push(src);
	}

}
