package Graph;

import java.util.*;

public class minStepsByKnight {

	static class Traversal {
		int x;
		int y;
		int level;

		Traversal(int ix, int iy, int il) {
			this.x = ix;
			this.y = iy;
			this.level = il;
		}
	}

	static boolean isSafe(int x, int y, int n) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[][] maze = new int[n][n];
			int sx = sc.nextInt();
			int sy = sc.nextInt();
			int dx = sc.nextInt();
			int dy = sc.nextInt();
			// Using BFS
			LinkedList<Traversal> queue = new LinkedList<>();
			boolean[][] visited = new boolean[n][n];
			int min = -1; // Initialize

			int[] px = { 2, 1, 2, 1, -2, -1, -2, -1 }; // possible x
			int[] py = { 1, 2, -1, -2, 1, 2, -1, -2 }; // possible y
			queue.addLast(new Traversal(sx, sy, 0));
			while (queue.size() > 0) {
				Traversal front = queue.getFirst();

				int currentX = front.x;
				int currentY = front.y;
				int currentL = front.level;

				queue.removeFirst();

				if (visited[currentX][currentY] == true) {
					continue;
				} else {
					// set as true
					visited[currentX][currentY] = true;
				}

				if (currentX == dx && currentY == dy) {
					min = currentL;
					break;
				}

				// Add neighbors
				for (int i = 0; i < 8; i++) {
					int nx = currentX + px[i];
					int ny = currentY + py[i];
					if (isSafe(nx, ny, n) && visited[nx][ny] == false) {
						queue.addLast(new Traversal(nx, ny, currentL + 1));
					}
				}
			}
			System.out.println(min);
		}
	}

}
