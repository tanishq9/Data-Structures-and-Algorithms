package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class shortestPathInMatrix_SrcToDest {
	public static void main(String[] args) {

		String str = "sdasd";
		System.out.println(str);
		str = "" + str.charAt(str.length() - 1);
		System.out.println(str);
		HashSet<String> set = new HashSet<>();
		set.add("str");
		set.add("str");
		set.add("a");
		set.add("stra");
		ArrayList<String> list = new ArrayList<>(set);
		Collections.sort(list);
		System.out.println(list);

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		char c = sc.next().charAt(0);
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] matrix = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}
			int dx = sc.nextInt();
			int dy = sc.nextInt();
			sb.append(bfs(matrix, n, m, dx, dy) + "\n");
		}
		System.out.println(sb.toString());
	}

	static class tr {
		int x;
		int y;
		int lvl;

		tr(int ix, int iy, int il) {
			this.x = ix;
			this.y = iy;
			this.lvl = il;
		}
	}

	static boolean isSafe(int x, int y, int n, int m) {
		return x >= 0 && y >= 0 && x < n && y < m;
	}

	private static int bfs(int[][] matrix, int n, int m, int dx, int dy) {
		if (matrix[0][0] == 0) {
			return -1;
		}
		int[] px = { 0, 0, 1, -1 };
		int[] py = { 1, -1, 0, 0 };
		LinkedList<tr> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];
		q.add(new tr(0, 0, 0));
		while (q.size() > 0) {
			// Get
			tr front = q.getFirst();
			// Remove
			q.removeFirst();
			int currx = front.x;
			int curry = front.y;
			int currl = front.lvl;
			// Mark
			visited[currx][curry] = true;

			// Work
			if (currx == dx && curry == dy) {
				return currl;
			}
			// Add neighbors
			for (int i = 0; i < 4; i++) {
				int x = currx + px[i];
				int y = curry + py[i];
				if (isSafe(x, y, n, m) && visited[x][y] == false && matrix[x][y] == 1) {
					q.addLast(new tr(x, y, currl + 1));
				}
			}
		}
		return -1;
	}

}
