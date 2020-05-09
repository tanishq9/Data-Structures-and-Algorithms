package Queue;

import java.util.LinkedList;

public class minMovesKnightChessboard {
	// Write the code
	static class Pair {
		int x;
		int y;
		int lvl;

		Pair(int ix, int iy, int il) {
			this.x = ix;
			this.y = iy;
			this.lvl = il;
		}
	}

	static boolean isSafe(int x, int y, int n) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}

	static int[] dx = { 2, 1, 2, 1, -2, -1, -2, -1 }; // possible x
	static int[] dy = { 1, 2, -1, -2, 1, 2, -1, -2 }; // possible y

	static int knightChessboard(int knightPos[], int targetPos[], int N) {
		LinkedList<Pair> q = new LinkedList<>();
		q.add(new Pair(knightPos[0] - 1, knightPos[1] - 1, 0));
		int destx = targetPos[0] - 1, desty = targetPos[1] - 1;
		boolean[][] visited = new boolean[N][N];
		while (q.size() > 0) {
			// Get
			Pair front = q.peek();
			int cx = front.x;
			int cy = front.y;
			int lvl = front.lvl;
			// Remove
			q.remove();
			// Mark
			if (visited[cx][cy] == true) {
				continue;
			} else {
				visited[cx][cy] = true;
			}
			// Work
			if (cx == destx && cy == desty) {
				return lvl;
			}

			// Add
			for (int i = 0; i < 8; i++) {
				int px = cx + dx[i];
				int py = cy + dy[i];
				if (isSafe(px, py, N) && visited[px][py] == false) {
					q.add(new Pair(px, py, lvl + 1));
				}
			}
		}
		return Integer.MAX_VALUE;
	}

}
