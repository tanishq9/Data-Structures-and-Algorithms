package HashMap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class sortElementsByFrequency {
	public String frequencySort(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (char cc : s.toCharArray()) {
			// if map can get, we increment the current count
			// else we put 0+1 i.e 1 as the new count of character
			map.put(cc, map.getOrDefault(cc, 0) + 1);
		}
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		// m*log(m) ; m are the distinct character
		for (char key : map.keySet()) {
			pq.add(new Pair(map.get(key), key));
		}
		StringBuilder sb = new StringBuilder();
		// m*log(m)
		while (pq.size() > 0) {
			Pair top = pq.remove();
			int freq = top.count;
			while (freq-- > 0) {
				sb.append(top.cc);
			}
		}
		// overall : n+m*log(m) i.e n as only 26 characters are there
		return sb.toString();
	}

	class Pair implements Comparable<Pair> {
		char cc;
		int count;

		Pair(int ic, char icc) {
			this.cc = icc;
			this.count = ic;
		}

		public int compareTo(Pair other) {
			if (this.count > other.count) {
				return -1;
			} else if (this.count < other.count) {
				return 1;
			} else {
				if (this.cc < other.cc) {
					return -1;
				} else {
					return 1;
				}
			}
		}
	}
}
