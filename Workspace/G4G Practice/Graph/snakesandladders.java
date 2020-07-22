package Graph;

import java.util.*;

public class snakesandladders {

	static class tr {
		int cell;
		int level;

		tr(int ic, int il) {
			this.cell = ic;
			this.level = il;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int src = 1;
			int n = 31;
			int[] move = new int[n]; // each index is vertex and value is the destination vertex

			// Initialize the move array graph
			for (int i = 1; i < n; i++) {
				move[i] = i;
			}
			// Input the number of move pairs
			int mp = sc.nextInt();
			for (int i = 1; i <= mp; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				move[start] = end;
			}

			boolean[] visited = new boolean[n];
			int min = -1;

			LinkedList<tr> queue = new LinkedList<>();
			queue.addLast(new tr(move[1], 0));
			while (queue.size() > 0) {
				// get
				tr front = queue.getFirst();
				int currentCell = front.cell;
				int currentLevel = front.level;
				// remove
				queue.removeFirst();
				// mark
				if (visited[currentCell] == true) {
					continue;
				} else {
					visited[currentCell] = false;
				}
				// work
				if (currentCell == 30) {
					min = currentLevel;
					break;
				}
				// add neighbors
				for (int i = currentCell; i <= (currentCell + 6); i++) {
					if (i <= 30) {
						queue.addLast(new tr(move[i], currentLevel + 1));
					}
				}
			}
			System.out.println(min);
		}
	}

}
