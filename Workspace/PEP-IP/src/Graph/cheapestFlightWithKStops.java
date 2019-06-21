package Graph;

import java.util.PriorityQueue;

public class cheapestFlightWithKStops {
	class Solution {
		class tr implements Comparable<tr> {
			int vtx;
			int lvl;
			int distance;

			tr(int iv, int il, int id) {
				this.vtx = iv;
				this.lvl = il;
				this.distance = id;
			}

			public int compareTo(tr o) {
				return this.distance - o.distance;
			}
		}

		public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

			int[][] weights = new int[n][n];
			for (int i = 0; i < flights.length; i++) {
				int a = flights[i][0];
				int b = flights[i][1];
				int wt = flights[i][2];
				weights[a][b] = wt;
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(weights[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			PriorityQueue<tr> pq = new PriorityQueue<>();
			boolean[] visited = new boolean[n];
			pq.add(new tr(src, 0, 0));
			int minDist = Integer.MAX_VALUE;
			while (pq.size() > 0) {
				// Get and Remove
				tr front = pq.remove();
				int vtx = front.vtx;
				int currdistance = front.distance;
				int currlevel = front.lvl;
				System.out.println(vtx + " " + currdistance + " " + currlevel);
				// Mark
				// Go through all the parts and don't skip them
				// even if it has been already been visited
				visited[vtx] = true;
				// Work
				if (vtx == dst) {
					minDist = Math.min(minDist, currdistance);
				}
				// Add neighbors
				for (int i = 0; i < n; i++) {
					if (i != vtx && weights[vtx][i] != 0 && visited[i] == false && currlevel <= K) {
						pq.add(new tr(i, currlevel + 1, currdistance + weights[vtx][i]));
					}
				}
			}
			if (minDist == Integer.MAX_VALUE) {
				return -1;
			}
			return minDist;
		}
	}
}
