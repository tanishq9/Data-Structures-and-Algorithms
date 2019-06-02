package Graph;

import java.util.ArrayList;

public class bellmanFord {

	public static class Edge {
		int u;
		int v;
		int wt;

		Edge(int u, int v, int wt) {
			this.u = u;
			this.v = v;
			this.wt = wt;
		}
	}

	public static class Pair {
		int cost;
		String path;

		Pair(int f, String s) {
			this.cost = f;
			this.path = s;
		}
	}

	public static void addEdge(ArrayList<Edge> graph, int u, int v, int wt) {
		graph.add(new Edge(u, v, wt));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Edge> graph = new ArrayList<Edge>();
		int V = 4;

		/*
		 * addEdge(graph, 0, 1, 2); addEdge(graph, 1, 2, 3); addEdge(graph, 2, 3, 4);
		 * addEdge(graph, 4, 2, -6); addEdge(graph, 3, 4, 5); addEdge(graph, 4, 5, 4);
		 * addEdge(graph, 5, 6, -15); addEdge(graph, 6, 3, 2);
		 */

		addEdge(graph, 3, 0, 7);
		addEdge(graph, 1, 3, 3);
		addEdge(graph, 2, 3, 1);
		addEdge(graph, 1, 2, -4);
		addEdge(graph, 0, 2, 3);
		addEdge(graph, 0, 1, 2);

		ArrayList<Pair> result = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			result.add(new Pair(Integer.MAX_VALUE, "."));
		}
		result.set(0, new Pair(0, ".")); // source
		for (int i = 0; i <= V - 1; i++) {
			for (int e = 0; e < graph.size(); e++) {
				Edge edge = graph.get(e);
				if (result.get(edge.u).cost != Integer.MAX_VALUE
						&& result.get(edge.u).cost + edge.wt < result.get(edge.v).cost) {
					// update cost and path
					Pair newPair = new Pair(result.get(edge.u).cost + edge.wt, result.get(edge.v).path);
					result.set(edge.v, newPair);
				}
			}
			for (Pair p : result) {
				System.out.println(p.cost + " "+p.path);
			}
			System.out.println();
		}

		boolean isCycle = false;
		// Check if still there is some optimization
		for (int i = 0; i <= V - 1; i++) {
			for (int e = 0; e < graph.size(); e++) {
				Edge edge = graph.get(e);
				if (result.get(edge.u).cost != Integer.MAX_VALUE
						&& result.get(edge.u).cost + edge.wt < result.get(edge.v).cost) {
					isCycle = true;
					break;       
				}
			}
		}
		System.out.println(isCycle);
	}

}
