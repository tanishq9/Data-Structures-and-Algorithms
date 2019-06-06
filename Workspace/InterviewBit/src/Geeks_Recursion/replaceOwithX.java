package Geeks_Recursion;

import java.util.Scanner;

public class replaceOwithX {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			char[][] graph = new char[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					graph[i][j] = sc.next().charAt(0);
				}
			}
			replace(graph, n, m);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					System.out.print(graph[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	static void replace(char[][] graph, int n, int m) {
		// Fill all 0's and replace them with '-'
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (graph[i][j] == 'O') {
					graph[i][j] = '-';
				}
			}
		}

		// Flood fill (-,0) for edge elements
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (graph[i][j] == '-') {
					// Checking for only edge element
					if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
						floodFill(graph, i, j, n, m, '-', 'O');
					}
				}
			}
		}

		// Fill '-'s inside with 'X'
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (graph[i][j] == '-') {
					graph[i][j] = 'X';
				}
			}
		}
	}

	static void floodFill(char[][] graph, int i, int j, int n, int m, char prevc, char newc) {
		if (i < 0 || j < 0 || i >= n || j >= m) {
			return;
		}
		if (graph[i][j] != prevc) {
			return;
		}
		graph[i][j] = newc; // new color
		floodFill(graph, i + 1, j, n, m, prevc, newc);
		floodFill(graph, i - 1, j, n, m, prevc, newc);
		floodFill(graph, i, j + 1, n, m, prevc, newc);
		floodFill(graph, i, j - 1, n, m, prevc, newc);
	}

}
