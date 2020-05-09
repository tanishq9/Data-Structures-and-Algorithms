package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class wordBoggle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			String[] strs = new String[n];
			for (int i = 0; i < n; i++) {
				strs[i] = sc.next();
			}
			n = sc.nextInt();
			int m = sc.nextInt();
			char[][] graph = new char[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					graph[i][j] = sc.next().charAt(0);
				}
			}
			dfs(graph, strs, n, m);
			System.out.println();
		}
	}

	private static void dfs(char[][] graph, String[] strs, int n, int m) {
		boolean[][] visited = new boolean[n][m];
		set = new HashSet<>();

		int maxLen = 0;
		for (int i = 0; i < strs.length; i++) {
			maxLen = Math.max(strs[i].length(), maxLen);
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// Consider every char as source once
				dfshelper(graph, n, m, visited, i, j, strs, "", maxLen);
			}
		}

		// Sort the set
		ArrayList<String> list = new ArrayList<>(set);
		Collections.sort(list);

		StringBuilder sb = new StringBuilder();
		for (String str : list) {
			sb.append(str + " ");
		}
		if (list.size() == 0) {
			System.out.println("-1");
		} else {
			System.out.println(sb.toString());
		}
	}

	static boolean isWord(String word, String[] words) {
		for (int i = 0; i < words.length; i++) {
			if (word.equals(words[i])) {
				return true;
			}
		}
		return false;
	}

	static boolean isSafe(int x, int y, int n, int m) {
		return x >= 0 && y >= 0 && x < n && y < m;
	}

	static int[] px = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] py = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static HashSet<String> set = null;

	private static void dfshelper(char[][] graph, int n, int m, boolean[][] visited, int i, int j, String[] strs,
			String res, int maxLen) {
		visited[i][j] = true;
		// System.out.println(res);
		if (isWord(res, strs)) {
			set.add(res);
		}
		for (int id = 0; id < 8; id++) {
			int x = i + px[id];
			int y = j + py[id];
			if (isSafe(x, y, n, m) && visited[x][y] == false) {
				dfshelper(graph, n, m, visited, x, y, strs, res + graph[x][y], maxLen);
			}
		}
		// Mark unvisited now
		visited[i][j] = false;
		// Erase last char
		if (res.length() != 0) {
			res = res.substring(0, res.length() - 1);
		}
	}

}
