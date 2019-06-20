package HashMap;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class maxDistinctElementsAfterKRemovals {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(distinct(arr, n, k));
		}
	}

	static class Pair implements Comparable<Pair> {
		int val;
		int freq;

		Pair(int iv, int ifr) {
			this.val = iv;
			this.freq = ifr;
		}

		public int compareTo(Pair o) {
			if (this.freq > o.freq) {
				return -1;
			} else if (this.freq < o.freq) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	static int distinct(int[] arr, int n, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int ele : arr) {
			map.put(ele, map.getOrDefault(ele, 0) + 1);
		}
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for (int key : map.keySet()) {
			pq.add(new Pair(key, map.get(key)));
		}
		while (k-- > 0) {
			Pair top = pq.remove();
			int freq = top.freq;
			int val = top.val;
			if (freq > 1) {
				pq.add(new Pair(val, freq - 1));
			}
		}
		return pq.size();
	}
}
