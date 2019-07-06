package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {

	static class Pair {
		int cap;
		int pro;

		Pair(int icap, int ipro) {
			this.cap = icap;
			this.pro = ipro;
		}
	}

	public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
		PriorityQueue<Pair> pqcap = new PriorityQueue<>(new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				if (o1.cap < o2.cap) {
					return -1;
				} else if (o1.cap > o2.cap) {
					return 1;
				} else {
					return 0;
				}
			}
		});

		PriorityQueue<Pair> pqpro = new PriorityQueue<>(new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				if (o1.pro > o2.cap) {
					return -1;
				} else if (o1.pro < o2.pro) {
					return 1;
				} else {
					return 0;
				}
			}
		});

		for (int i = 0; i < Capital.length; i++) {
			pqcap.add(new Pair(Capital[i], Profits[i]));
		}
		while (k-- > 0) {
			while (pqcap.size() > 0 && pqcap.peek().cap <= W) {
				pqpro.add(pqcap.remove());
			}
			if (pqpro.size() == 0) {
				break;
			}
			W += pqpro.remove().pro;
		}
		return W;
	}
}
