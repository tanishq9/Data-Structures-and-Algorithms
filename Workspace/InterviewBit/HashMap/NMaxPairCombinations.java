package HashMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class NMaxPairCombinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Pair, Integer> map = new HashMap<>();
		map.put(new Pair(2, 3), 1);
		Pair p = new Pair(2, 3);
		System.out.println(map.containsKey(p));
	}

	public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		// Collections.sort(A);
		// Collections.sort(B);
		// PriorityQueue<SumElement> pq = new PriorityQueue<>();
		ArrayList<Integer> result = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < A.size(); i++) {
			for (int j = 0; j < B.size(); j++) {
				pq.add(A.get(i) + B.get(j));
			}
		}
		int k = A.size();
		while (k-- > 0) {
			result.add(pq.remove());
		}
		return result;
	}
	// NLog(N) approach

	class sumElement implements Comparable<sumElement> {
		int sum;
		int i;
		int j;

		sumElement(int isum, int ii, int ij) {
			this.sum = isum;
			this.i = ii;
			this.j = ij;
		}

		// Max Heap
		public int compareTo(sumElement other) {
			if (this.sum > other.sum) {
				return -1;
			} else if (this.sum < other.sum) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	static class Pair {
		// You must override hashCode() in every class that overrides equals(). Failure
		// to do so will result in a violation of the general contract for
		// Object.hashCode(), which will prevent your class from functioning properly in
		// conjunction with all hash-based collections, including HashMap & HashSet
		int i;
		int j;

		Pair(int ii, int ij) {
			this.i = ii;
			this.j = ij;
		}

		@Override
		public int hashCode() {
			long hashcode = 0;
			hashcode = ((long) i * 1000000000) % 1000000007;
			hashcode += (long) j;
			return (int) hashcode % 100000007;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			} else if (obj == null || obj.getClass() != this.getClass()) {
				return false;
			} else {
				Pair other = (Pair) obj;
				return this.i == other.i && this.j == other.j;
			}

		}

	}

	public ArrayList<Integer> solve2(ArrayList<Integer> A, ArrayList<Integer> B) {
		ArrayList<Integer> result = new ArrayList<>();
		Collections.sort(A);
		Collections.sort(B);
		int n = A.size();

		PriorityQueue<sumElement> pq = new PriorityQueue<>();
		sumElement ele = new sumElement(A.get(n - 1) + B.get(n - 1), n - 1, n - 1);
		pq.add(ele);

		HashSet<Pair> set = new HashSet<>();

		int k = A.size();
		while (k-- > 0) {
			sumElement top = pq.remove();
			int i = top.i;
			int j = top.j;
			Pair p = new Pair(i - 1, j);
			if (!set.contains(p) && i > 0 && j > 0) {
				pq.add(new sumElement(A.get(i - 1) + B.get(j), i - 1, j));
			}
			p = new Pair(i, j - 1);
			if (!set.contains(p) && i > 0 && j > 0) {
				pq.add(new sumElement(A.get(i) + B.get(j - 1), i, j - 1));
			}
		}
		return result;
	}
}
