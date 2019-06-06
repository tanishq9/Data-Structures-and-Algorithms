package Graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class numberIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1 3 3 1 1 0 0 0 1 1 0 1
		// BFS Approach used for finding connected components
		// DFS Approach used in X_TotalShapes
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			list.add(new ArrayList<>());
		}
		list.get(0).add(1);
		list.get(0).add(1);
		list.get(0).add(0);
		list.get(1).add(0);
		list.get(1).add(0);
		list.get(1).add(1);
		list.get(2).add(1);
		list.get(2).add(0);
		list.get(2).add(1);

		System.out.println(findIslands(list, 3, 3));
	}

	// Function to find the number of island in the given list
	// N, M: size of list row and column respectively
	static int findIslands(ArrayList<ArrayList<Integer>> list, int N, int M) {

		boolean[][] visited = new boolean[N][M];
		// Find the number of components
		int comp = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int val = list.get(i).get(j);
				if (val == 1 && visited[i][j] == false) {
					System.out.println("Inside helper");
					helper(i, j, list, visited, N, M);
					comp++;
				}
			}
		}
		return comp;
	}

	static class Pair {
		int i;
		int j;

		Pair(int ii, int ij) {
			this.i = ii;
			this.j = ij;
		}
	}

	static boolean isSafe(int x, int y, int n, int m) {
		return x >= 0 && y >= 0 && x < n && y < m;
	}

	static void helper(int i, int j, ArrayList<ArrayList<Integer>> list, boolean[][] visited, int N, int M) {
		int[] px = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] py = { -1, 0, 1, -1, 1, -1, 0, 1 };
		LinkedList<Pair> q = new LinkedList<>();
		q.add(new Pair(i, j));
		while (q.size() > 0) {
			Pair front = q.getFirst();
			q.removeFirst();
			if (visited[front.i][front.j] == true) {
				continue;
			} else {
				visited[front.i][front.j] = true;
			}
			for (int idx = 0; idx < 8; idx++) {
				int x = px[idx] + front.i;
				int y = py[idx] + front.j;
				if (isSafe(x, y, N, M) && list.get(x).get(y) == 1) {
					System.out.println("Added");
					q.addLast(new Pair(x, y));
				}
			}
		}
	}
}
