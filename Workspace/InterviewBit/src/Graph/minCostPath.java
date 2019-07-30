package Graph;

import java.util.PriorityQueue;
import java.util.Scanner;

public class minCostPath {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[][] matrix = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}
			sb.append(solver(matrix, n) + "\n");
		}
		System.out.print(sb.toString());
	}

	// 2 5 31 100 65 12 18 10 13 47 157 6 100 113 174 11 33 88 124 41 20 140 99 32 111 41 20 2 42 93 7 14

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
