package Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class advantageShuffleLeetCode {
	public int[] advantageCount(int[] A, int[] B) {
		// Sort array A
		Arrays.sort(A);

		// Make MAX HEAP using array B
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return b[1] - a[1];
			}
		});
		for (int i = 0; i < B.length; i++) {
			pq.add(new int[] { i, B[i] });
		}

		int lo = 0;
		int hi = A.length - 1;
		int[] res = new int[A.length];

		// Try to satisfy maximum of array B using array A
		// If A > MAX of B,then settle it but if not
		// then waste the smallest element on it
		while (pq.size() > 0) {
			int[] top = pq.remove();
			int idx = top[0];
			int val = top[1];
			if (A[hi] > val) {
				res[idx] = A[hi--];
			} else {
				res[idx] = A[lo++];
			}
		}

		return res;
	}
}
