package Heap;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class mostFrequentDigit {
	static class Pair implements Comparable<Pair> {
		int e;
		int freq;

		Pair(int e, int f) {
			this.e = e;
			this.freq = f;
		}

		public int compareTo(Pair o) {
			if (this.freq > o.freq) {
				return -1;
			} else if (this.freq < o.freq) {
				return 1;
			} else {
				if (this.e > o.e) {
					return -1;
				} else if (this.e < o.e) {
					return 1;
				} else {
					return 0;
				}
			}
		}
	}

	public static int solve(String s) {

		HashMap<Integer, Integer> map = new HashMap<>();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for (char cc : s.toCharArray()) {
			int offset = cc - '0';
			map.put(offset, map.getOrDefault(offset, 0) + 1);
		}
		for (int k : map.keySet()) {
			pq.add(new Pair(k, map.get(k)));
		}
		if (pq.size() > 0) {
			return pq.peek().e;
		}
		return -1;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(solve(s));

	}
}
