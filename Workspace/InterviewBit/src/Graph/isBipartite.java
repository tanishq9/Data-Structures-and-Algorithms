package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class isBipartite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] color = new int[3];
		Arrays.fill(color, -1);
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int[][] arr = new int[V][V];
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		System.out.println(isBipartite(arr, V));
	}

	// Should work for all the components of the graph

	static boolean isBipartite(int[][] G, int V) {

		// Color can also be called as set
		int[] set = new int[V];
		// Initially assign no set to the vertices
		// We have 2 sets namely 0 and 1
		for (int i = 0; i < V; i++) {
			set[i] = -1;
		}

		// Do it for the components
		for (int i = 0; i < V; i++) {
			// Do it till all the vertex are not assigned any set
			if (set[i] == -1) {
				if (helper(i, G, set, V) == false) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean helper(int src, int[][] G, int[] set, int V) {
		set[src] = 1;
		LinkedList<Integer> q = new LinkedList<>();
		q.addLast(src);
		while (q.size() > 0) {
			int front = q.getFirst();
			q.removeFirst();
			// self loop
			if (G[front][front] == 1) {
				return false;
			}
			for (int v = 0; v < V; v++) {
				// There is an edge but vertex is not in either set
				if (G[front][v] == 1 && set[v] == -1) {
					q.addLast(v);
					set[v] = 1 - set[front];
				}
				// If there is an edge and vertex is in the same set
				else if (G[front][v] == 1 && set[v] == set[front]) {
					return false;
				}
			}
		}
		return true;
	}
}
