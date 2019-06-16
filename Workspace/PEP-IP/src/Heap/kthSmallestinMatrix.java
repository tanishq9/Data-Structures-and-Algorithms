package Heap;

import java.util.PriorityQueue;

public class kthSmallestinMatrix {
	class Solution {
		class Tuple implements Comparable<Tuple> {
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

		public int kthSmallest(int[][] matrix, int k) {
			PriorityQueue<Tuple> pq = new PriorityQueue<>();
			// n*logn
			int n = matrix.length;
			for (int i = 0; i < matrix[0].length; i++) {
				pq.add(new Tuple(0, i, matrix[0][i]));
			}
			// k*logn
			for (int i = 0; i < k - 1; i++) {
				Tuple top = pq.remove();
				if (top.i == n - 1) {
					continue;
				} else {
					pq.add(new Tuple(top.i + 1, top.j, matrix[top.i + 1][top.j]));
				}
			}
			return pq.peek().val;
		}
	}
}
