package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KPairsWithSmallestSums {
	static class Pair implements Comparable<Pair> {
		int idx1;
		int idx2;
		int sum;

		Pair(int idx1, int idx2, int is) {
			this.idx1 = idx1;
			this.idx2 = idx2;
			this.sum = is;
		}

		public int compareTo(Pair o) {
			return this.sum - o.sum;
		}
	}

	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		// 0(n*logn) ; n is the length of the smaller array among them
		for (int i = 0; i < nums2.length; i++) {
			pq.add(new Pair(0, i, nums1[0] + nums2[i]));
		}
		List<List<Integer>> res = new ArrayList<>();
		while (k-- > 0) {
			Pair t = pq.remove();
			res.add(Arrays.asList(nums1[t.idx1], nums2[t.idx2]));
			if (t.idx1 == nums1.length - 1) {
				continue;
			} else {
				pq.add(new Pair(t.idx1 + 1, t.idx2, nums1[t.idx1 + 1] + nums2[t.idx2]));
			}
		}
		return res;
	}
}
