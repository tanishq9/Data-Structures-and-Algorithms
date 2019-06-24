package Heap;

import java.util.PriorityQueue;

public class kthSmallestInMatrixSortedRowsNOTcolumns {
	static class Tuple implements Comparable<Tuple> {
		int i;
		int j;
		int val;

		Tuple(int i, int j, int val) {
			this.i = i;
			this.j = j;
			this.val = val;
		}

		public int compareTo(Tuple other) {
			if (this.val < other.val) {
				return -1;
			} else if (this.val > other.val) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	public static int findKthSmallest(int[][] matrix, int k) {
		PriorityQueue<Tuple> pq = new PriorityQueue<>();
		// n*logn
		int n = matrix[0].length;
		for (int i = 0; i < matrix.length; i++) {
			pq.add(new Tuple(i, 0, matrix[i][0]));
		}
		// k*logn
		for (int i = 0; i < k - 1; i++) {
			Tuple top = pq.remove();
			if (top.j == n - 1) {
				continue;
			} else {
				pq.add(new Tuple(top.i, top.j + 1, matrix[top.i][top.j + 1]));
			}
		}
		return pq.peek().val;
	}

}
