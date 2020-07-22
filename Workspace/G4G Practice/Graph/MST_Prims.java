package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MST_Prims {

	static class Pair {
		int x, y;

		Pair(int first, int second) {
			this.x = first;
			this.y = second;
		}
	}

	// By Prims
	static class tr implements Comparable<tr> {
		int vertex;
		int wt; // this the weight of edge incident on it

		tr(int iv, int iw) {
			this.vertex = iv;
			this.wt = iw;
		}

		public int compareTo(tr other) {
			if (this.vertex > other.vertex) {
				return 1;
			} else if (this.vertex < other.vertex) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	static int spanningTree(ArrayList<ArrayList<Pair>> list) {
		PriorityQueue<tr> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[101];
		int total_wt = 0;
		pq.add(new tr(1, 0));
		while (pq.size() > 0) {
			// Get
			tr front = pq.peek();
			// Remove
			pq.remove();
			int currv = front.vertex;
			int currwt = front.wt;
			total_wt += currwt;
			// System.out.println(currwt);
			// Mark
			if (visited[currv] == true) {
				continue;
			} else {
				visited[currv] = true;
			}
			// Add ngbhrs
			for (int i = 0; i < list.get(currv).size(); i++) {
				Pair edge = list.get(currv).get(i);
				int n = edge.x;
				int edge_wt = edge.y;
				// System.out.println(n+" "+edge_wt);
				if (visited[n] == false) {
					pq.add(new tr(n, edge_wt));
				}
			}
		}
		return total_wt;
	}
}
