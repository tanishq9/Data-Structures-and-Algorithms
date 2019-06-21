package Heap;

import java.util.PriorityQueue;

public class KclosestPointsToOrigin {
	class Pair implements Comparable<Pair> {
		int x;
		int y;
		long dist;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
			this.dist = x * x + y * y;
		}

		public int compareTo(Pair o) {
			if (o.dist < this.dist) {
				return -1;
			} else if (this.dist < o.dist) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	public int[][] kClosest(int[][] points, int k) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			pq.add(new Pair(points[i][0], points[i][1]));
		}
		for (int i = k; i < points.length; i++) {
			long currDist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
			if (currDist < pq.peek().dist) {
				pq.remove();
				pq.add(new Pair(points[i][0], points[i][1]));
			}
		}
		int[][] res = new int[k][2];
		int index = k - 1;
		while (pq.size() > 0) {
			res[index][0] = pq.peek().x;
			res[index][1] = pq.peek().y;
			index--;
			pq.remove();
		}
		return res;
	}
}
