package Matrix;

import java.util.LinkedList;

public class BFS_shortestPathBinaryMatrix {
	class Solution {

		class Pair {
			int x;
			int y;
			int lvl;

			Pair(int x, int y, int lvl) {
				this.x = x;
				this.y = y;
				this.lvl = lvl;
			}
		}

		int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

		boolean isInBounds(int i, int j, int n) {
			return i >= 0 && i < n && j >= 0 && j < n;
		}

		public int shortestPathBinaryMatrix(int[][] grid) {

			if (grid[0][0] == 1) {
				return -1;
			}

			LinkedList<Pair> queue = new LinkedList<>();
			boolean[][] visited = new boolean[grid.length][grid.length];
			queue.add(new Pair(0, 0, 1));
			while (queue.size() > 0) {
				// Get and Remove
				Pair front = queue.removeFirst();
				int cx = front.x;
				int cy = front.y;
				int lvl = front.lvl;

				// Mark
				if (visited[cx][cy] == true) {
					continue;
				} else {
					visited[cx][cy] = true;
				}

				// Work
				if (cx == grid.length - 1 && cy == grid.length - 1) {
					return lvl;
				}

				// Visit
				for (int i = 0; i < 8; i++) {
					int px = cx + dx[i];
					int py = cy + dy[i];
					if (isInBounds(px, py, grid.length) && visited[px][py] == false && grid[px][py] == 0) {
						queue.addLast(new Pair(px, py, lvl + 1));
					}
				}
			}
			return -1;
		}
	}
}
