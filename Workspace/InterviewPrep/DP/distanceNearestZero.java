package DP;

import java.util.LinkedList;

public class distanceNearestZero {
	class Pair {
		int x, y, lvl;

		Pair(int x, int y, int lvl) {
			this.x = x;
			this.y = y;
			this.lvl = lvl;
		}
	}

	int[] dx = { -1, 0, 0, 1 };
	int[] dy = { 0, -1, 1, 0 };

	public int[][] updateMatrix(int[][] matrix) {
		LinkedList<Pair> q = new LinkedList<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					q.addLast(new Pair(i, j, 0));
				} else {
					// mark the unreached cell
					matrix[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		while (q.size() > 0) {
			Pair front = q.removeFirst();
			int currx = front.x;
			int curry = front.y;
			int currl = front.lvl;
			if (visited[currx][curry] == true) {
				continue;
			} else {
				visited[currx][curry] = true;
			}
			for (int i = 0; i < 4; i++) {
				int px = currx + dx[i];
				int py = curry + dy[i];
				if (px >= 0 && px < matrix.length && py >= 0 && py < matrix[0].length
						&& matrix[px][py] == Integer.MAX_VALUE && visited[px][py] == false) {
					matrix[px][py] = currl + 1;
					q.addLast(new Pair(px, py, currl + 1));
				}
			}
		}
		return matrix;
	}
}
