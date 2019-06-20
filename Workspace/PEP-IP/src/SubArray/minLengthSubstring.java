package SubArray;

import java.util.HashMap;
import java.util.Scanner;

public class minLengthSubstring {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			String str = sc.next();
			String pattern = sc.next();
			System.out.println(minWindow(str, pattern));
		}
	}

	public static String minWindow(String s, String t) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			char cc = t.charAt(i);
			map.put(cc, map.getOrDefault(cc, 0) + 1);
		}
		int start = 0;
		int end = 0;
		int match_count = 0;
		int len = Integer.MAX_VALUE;
		int head = -1;
		// each distinct character; doesn't matter the frequency is treated individually
		while (end < s.length()) {
			// standard work
			char cend = s.charAt(end);
			if (map.containsKey(cend)) {
				map.put(cend, map.get(cend) - 1);
				if (map.get(cend) == 0) {
					match_count++;
				}
			}
			end++;
			// after finding the valid,we try to optimize it
			while (match_count == map.size()) {
				char cstart = s.charAt(start);
				// updating step
				if ((end - start) < len) {
					len = end - start;
					head = start;
				}
				// optimizing step
				if (map.containsKey(cstart)) {
					map.put(cstart, map.get(cstart) + 1);
					if (map.get(cstart) > 0) {
						match_count--;
					}
				}
				start++;
			}

		}
		if (head == -1) {
			return "-1";
		}
		return s.substring(head, head + len);
	}
}
