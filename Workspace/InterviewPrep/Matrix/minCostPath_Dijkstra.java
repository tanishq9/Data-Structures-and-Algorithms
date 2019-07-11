package Matrix;

import java.util.PriorityQueue;

public class minCostPath_Dijkstra {

	static class tr implements Comparable<tr> {
		int x;
		int y;
		int cost;

		tr(int ix, int iy, int c) {
			this.x = ix;
			this.y = iy;
			this.cost = c;
		}

		public int compareTo(tr other) {
			if (this.cost < other.cost) {
				return -1;
			} else if (this.cost > other.cost) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	private static boolean isSafe(int x, int y, int n) {
		return x >= 0 && y >= 0 && x < n && y < n;
	}

	private static int solver(int[][] matrix, int n) {
		int[] px = { -1, 1, 0, 0 };
		int[] py = { 0, 0, -1, 1 };

		PriorityQueue<tr> pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[n][n];

		pq.add(new tr(0, 0, matrix[0][0]));
		int res = matrix[0][0];

		while (pq.size() > 0) {
			tr front = pq.peek();
			pq.remove();
			int currx = front.x;
			int curry = front.y;
			int currcost = front.cost;
			// System.out.println(currx + " " + curry + " " + currcost);
			// We won't go through the visited cell again even
			// if it has least value among 8 neighbors
			if (visited[currx][curry] == true) {
				continue;
			} else {
				visited[currx][curry] = true;
			}
			// Work : Check if destination is reached
			if (currx == n - 1 && curry == n - 1) {
				res = currcost;
				break;
			}

			// Add neighbors
			for (int i = 0; i < 4; i++) {
				int x = currx + px[i];
				int y = curry + py[i];
				if (isSafe(x, y, n) && visited[x][y] == false) {
					pq.add(new tr(x, y, currcost + matrix[x][y]));
				}
			}
		}
		return res;
	}
}
