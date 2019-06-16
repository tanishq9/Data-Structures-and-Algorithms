package Heap;

import java.util.PriorityQueue;

public class reArrangeCharacters {
	class Solution {

		class multichar implements Comparable<multichar> {
			int count;
			char letter;

			multichar(int ct, char ch) {
				this.count = ct;
				this.letter = ch;
			}

			public int compareTo(multichar other) {
				if (this.count > other.count) {
					return -1;
				} else if (this.count < other.count) {
					return 1;
				} else {
					return 0;
				}
			}
		}

		public String reorganizeString(String S) {
			int N = S.length();
			PriorityQueue<multichar> pq = new PriorityQueue<>();
			int[] freq = new int[26];
			for (char cc : S.toCharArray())
				freq[cc - 'a']++;
			for (int i = 0; i < 26; i++) {
				if (freq[i] > 0) {
					if (freq[i] > (N + 1) / 2) {
						return "";
					}
					pq.add(new multichar(freq[i], (char) ('a' + i)));
				}
			}
			StringBuilder sb = new StringBuilder();
			while (pq.size() >= 2) {
				multichar m1 = pq.remove();
				multichar m2 = pq.remove();
				sb.append(m1.letter);
				sb.append(m2.letter);
				m1.count--;
				m2.count--;
				if (m1.count > 0) {
					pq.add(m1);
				}
				if (m2.count > 0) {
					pq.add(m2);
				}
			}
			if (pq.size() > 0) {
				sb.append(pq.remove().letter);
			}
			return sb.toString();
		}
	}
}
