package String;

import java.util.HashSet;

public class nextClosestTime {
	// Number of operations ke terms mei brute force
	// par complexity ke hisaab se O(1) ; kyuki
	// constant 24*60 operations hoge
	public static String nextClosestTimeLeetCode(String t) {

		int curtim = 60 * Integer.parseInt(t.substring(0, 2));
		curtim += Integer.parseInt(t.substring(3));
		HashSet<Integer> hm = new HashSet<>();
		for (int i = 0; i < t.length(); i++) {
			if (i != 2) {
				hm.add(t.charAt(i) - '0');
			}
		}

		while (true) {

			curtim = (curtim + 1) % (24 * 60);
			boolean valid = true;
			StringBuilder sb = new StringBuilder();
			sb.append((curtim / 60) / 10);
			sb.append((curtim / 60) % 10);
			sb.append((curtim % 60) / 10);
			sb.append((curtim % 60) % 10);

			for (int i = 0; i < sb.length(); i++) {
				if (!hm.contains(sb.charAt(i) - '0')) {
					valid = false;
					break;
				}
			}
			if (valid) {
				return sb.insert(2, ':').toString();
			}

		}

	}
}
