package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class dijkstra_adj_matrix_implementation {
	static class tr implements Comparable<tr> {
		int v;
		int dist;

		tr(int iv, int id) {
			this.v = iv;
			this.dist = id;
		}

		public int compareTo(tr other) {
			if (this.dist < other.dist) {
				return -1;
			} else if (this.dist > other.dist) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	static void dijkstra(ArrayList<ArrayList<Integer>> list, int src, int V) {
		PriorityQueue<tr> pq = new PriorityQueue<>();

		int[] distance = new int[V];

		boolean[] visited = new boolean[V];

		pq.add(new tr(src, 0));

		while (pq.size() > 0) {

			tr front = pq.peek();

			pq.remove();

			int curr = front.v;
			int dist = front.dist;

			if (visited[curr] == true) {
				continue;
			} else {
				distance[curr] = dist;
				visited[curr] = true;
			}

			for (int i = 0; i < V; i++) {
				if (list.get(curr).get(i) != 0 && visited[i] == false) {
					pq.add(new tr(i, dist + list.get(curr).get(i)));
				}
			}
		}

		for (int i = 0; i < V; i++) {
			System.out.print(distance[i] + " ");
		}

	}
}
