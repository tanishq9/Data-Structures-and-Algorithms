package Graph;

import java.util.*;

public class nodesAtEvenDistance {
	// Trick : Find the number of nodes at the even and the odd level
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			int n = sc.nextInt();
			ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				graph.add(new ArrayList<>());
			}
			int edges = 2 * (n - 1);
			while (edges != 0) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				graph.get(u - 1).add(v - 1);
				graph.get(v - 1).add(u - 1);
				edges -= 2;
			}
			sb.append(ways(graph, n) + "\n");
		}
		System.out.println(sb.toString());
	}

	static class Pair {
		int v;
		int lvl;

		Pair(int v, int l) {
			this.v = v;
			this.lvl = l;
		}
	}

	private static int ways(ArrayList<ArrayList<Integer>> graph, int n) {
		// Assigning even and odd level using BFS

		int even = 0, odd = 0, level = 0;

		LinkedList<Pair> q = new LinkedList<>();
		q.add(new Pair(1, 0));

		boolean[] visited = new boolean[n + 1];

		while (q.size() > 0) {
			// Get
			Pair front = q.getFirst();
			int currVertex = front.v;
			int currLevel = front.lvl;
			// Remove
			q.removeFirst();
			// Mark
			visited[currVertex] = true;
			// Work
			if (currLevel % 2 == 0) {
				even++;
			} else {
				odd++;
			}
			// Add neighbors
			for (int i = 0; i < graph.get(currVertex).size(); i++) {
				int ngr = graph.get(currVertex).get(i);
				if (visited[ngr] == false) {
					q.addLast(new Pair(ngr, 1 - currLevel));
				}
			}
			// Increment the level
			level++;
		}
		return (even * (even - 1)) / 2 + (odd * (odd - 1)) / 2;
	}
}
