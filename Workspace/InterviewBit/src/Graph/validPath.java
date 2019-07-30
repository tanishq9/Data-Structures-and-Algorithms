package Graph;

import java.util.Scanner;

public class validPath {
	/* package whatever //do not write package name here */
	public static void main(String[] args) {
		// 1 3 1 3 3 3 3 3 3 3 2
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int sx = -1, sy = -1, dx = -1, dy = -1;
			int[][] maze = new int[n + 1][n + 1];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					maze[i][j] = sc.nextInt();
					if (maze[i][j] == 1) {
						sx = i;
						sy = j;
					} else if (maze[i][j] == 2) {
						dx = i;
						dy = j;
					}
				}
			}
			System.out.println(sx + " " + sy);
			System.out.println(dx + " " + dy);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(maze[i][j] + " ");
				}
				System.out.println();
			}
			int[][] path = new int[n][n];
			int cx = sx;
			int cy = sy;
			sb.append(check(maze, cx, cy, dx, dy, n, path) + "\n");
			System.out.println();
			System.out.println();
			path = new int[n][n];
			cx = sx;
			cy = sy;
			System.out.println("PP all paths");
			pp(maze, cx, cy, dx, dy, n, path);
			System.out.println();
			System.out.println();
		}
		System.out.println(sb.toString());
	}

	// Prints just one valid path
	private static int check(int[][] maze, int sx, int sy, int dx, int dy, int n, int[][] path) {
		if (sx == dx && sy == dy) {
			path[sx][sy] = 1;
			System.out.println("Printing Output");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(path[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			path[sx][sy] = 0;// Mark unvisited
			return 1; // true
		}
		// Out of bounds
		if (sx < 0 || sy < 0 || sx >= n || sy >= n) {
			return 0;
		}
		// Blank wall or path already going from that cell
		if (maze[sx][sy] == 0 || path[sx][sy] == 1) {
			return 0;
		}
		// Implies move is possible
		path[sx][sy] = 1; // Mark as visited
		if (check(maze, sx + 1, sy, dx, dy, n, path) == 1) {
			return 1;
		}
		if (check(maze, sx, sy + 1, dx, dy, n, path) == 1) {
			return 1;
		}
		if (check(maze, sx - 1, sy, dx, dy, n, path) == 1) {
			return 1;
		}
		if (check(maze, sx, sy - 1, dx, dy, n, path) == 1) {
			return 1;
		}
		path[sx][sy] = 0; // Mark as unvisited
		return 0; // false
	}

	// Print all the valid paths
	// Prints just one valid path
	private static void pp(int[][] maze, int sx, int sy, int dx, int dy, int n, int[][] path) {
		if (sx == dx && sy == dy) {
			path[sx][sy] = 1;
			System.out.println("Printing Output");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(path[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			path[sx][sy] = 0;// Mark unvisited
			return; // true
		}
		// Out of bounds
		if (sx < 0 || sy < 0 || sx >= n || sy >= n) {
			return;
		}
		// Blank wall
		if (maze[sx][sy] == 0 || path[sx][sy] == 1) {
			return;
		}
		// Implies move is possible
		path[sx][sy] = 1; // Mark as visited
		pp(maze, sx + 1, sy, dx, dy, n, path);
		pp(maze, sx, sy + 1, dx, dy, n, path);
		pp(maze, sx - 1, sy, dx, dy, n, path);
		pp(maze, sx, sy - 1, dx, dy, n, path);
		path[sx][sy] = 0; // Mark as unvisited
		return; // false
	}

}
