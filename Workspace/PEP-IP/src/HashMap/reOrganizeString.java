package HashMap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class reOrganizeString {
	static class Pair implements Comparable<Pair> {
		char cc;
		int freq;

		Pair(char ic, int ifr) {
			this.cc = ic;
			this.freq = ifr;
		}

		public int compareTo(Pair o) {
			if (this.freq > o.freq) {
				return -1;
			} else if (this.freq < o.freq) {
				return 1;
			} else {
				String s1 = this.cc + "";
				String s2 = o.cc + "";
				return s1.compareTo(s2) > 0 ? 1 : -1;
			}
		}
	}

	public static String reorganizeString(String S) {
		HashMap<Character, Integer> map = new HashMap<>();
		int max = 0;
		for (int i = 0; i < S.length(); i++) {
			char cc = S.charAt(i);
			map.put(cc, map.getOrDefault(cc, 0) + 1);
			max = Math.max(max, map.get(cc));
		}
		if (max > (S.length() + 1) / 2) {
			return "";
		}
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for (char key : map.keySet()) {
			pq.add(new Pair(key, map.get(key)));
		}
		StringBuilder sb = new StringBuilder();
		while (pq.size() >= 2) {
			Pair one = pq.remove();
			Pair two = pq.remove();
			sb.append(one.cc + "" + two.cc);
			if (one.freq > 1) {
				one.freq--;
				pq.add(one);
			}
			if (two.freq > 1) {
				two.freq--;
				pq.add(two);
			}
		}
		if (pq.size() > 0) {
			sb.append(pq.remove().cc);
		}
		return sb.toString();
	}

}
