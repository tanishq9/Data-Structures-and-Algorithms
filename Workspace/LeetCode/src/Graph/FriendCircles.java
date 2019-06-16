package Graph;

public class FriendCircles {

	class Solution {
		public int findCircleNum(int[][] M) {
			int n = M.length;
			boolean[] visited = new boolean[n];
			int comp = 0;
			for (int i = 0; i < n; i++) {
				if (visited[i] == false) {
					dfs(M, visited, i);
					comp++;
				}
			}
			return comp;
		}

		private void dfs(int[][] M, boolean[] visited, int src) {
			visited[src] = true;
			for (int i = 0; i < M.length; i++) {
				if (i != src && M[src][i] == 1 && visited[i] == false) {
					dfs(M, visited, i);
				}
			}
		}
	}

}
