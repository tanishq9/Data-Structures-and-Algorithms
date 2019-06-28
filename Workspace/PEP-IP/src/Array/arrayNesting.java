package Array;

import java.util.LinkedList;

public class arrayNesting {
	public int arrayNestingLeet(int[] nums) {
		int max = 0;
		boolean[] visited = new boolean[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]) {
				max = Math.max(max, bfs(i, nums, visited));
			}
		}
		return max;
	}

	int bfs(int i, int[] arr, boolean[] visited) {
		LinkedList<Integer> q = new LinkedList<>();
		q.add(i);
		int c = 0;
		while (q.size() > 0) {
			int front = q.remove();
			while (visited[arr[front]] == false) {
				visited[arr[front]] = true;
				c++;
				q.addFirst(arr[front]);
			}
		}
		return c;
	}

}
