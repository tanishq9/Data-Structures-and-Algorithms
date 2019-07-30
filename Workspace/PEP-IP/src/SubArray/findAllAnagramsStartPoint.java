package SubArray;

import java.util.ArrayList;
import java.util.HashMap;

public class findAllAnagramsStartPoint {

	public static void main(String[] args) {
		String s = "aabcioioioioioioaabc";
		String p = "aabc";
		// 2 pointer and hash-map approach for substring pattern search in string
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < p.length(); i++) {
			map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
		}
		int start = 0;
		int end = 0;
		int match_count = 0;
		ArrayList<Integer> spts = new ArrayList<>();
		while (end < s.length()) {
			char cend = s.charAt(end);
			if (map.containsKey(cend)) {
				map.put(cend, map.get(cend) - 1);
				// fully acquired that character
				if (map.get(cend) == 0) {
					match_count++;
				}
			}
			System.out.println(start + " " + end + " " + match_count);
			// release character from valid to make it invalid
			while (match_count == map.size()) {
				// Anagram length condition
				if ((end - start + 1) == p.length()) {
					spts.add(start);
				}

				char cstart = s.charAt(start);
				if (map.containsKey(cstart)) {
					map.put(cstart, map.get(cstart) + 1);
					if (map.get(cstart) > 0) {
						match_count--;
					}
				}
				start++;
			}

			// acquire next character
			end++;

		}
		System.out.println(spts);
	}

	static int findAll(String s, String p) {
		HashMap<Character, Integer> stillNeeded = new HashMap<>();
		int total_count = 0;
		int match_count = 0;
		int start = 0;
		int end = 0;
		for (int i = 0; i < p.length(); i++) {
			char cc = p.charAt(i);
			stillNeeded.put(cc, stillNeeded.getOrDefault(cc, 0) + 1);
		}
		while (end < s.length()) {
			char cend = s.charAt(end);
			if (stillNeeded.containsKey(cend)) {
				stillNeeded.put(cend, stillNeeded.get(cend) - 1);
				if (stillNeeded.get(cend) == 0) {
					match_count++;
				}
			}
			// check for validity and then optimize and make it invalid for further process
			while (match_count == stillNeeded.size()) {
				if ((end - start + 1) == p.length()) {
					total_count++;
				}
				// release character from start to optimize length
				char cstart = s.charAt(start);
				// if character at the start is of any use then
				if (stillNeeded.containsKey(cstart)) {
					stillNeeded.put(cstart, stillNeeded.get(cstart) + 1);
					// check if removal will make it invalid
					if (stillNeeded.get(cstart) > 0) {
						// invalid now
						match_count--;
					}
				}
				start++; // finally released after updating map if updated
			}
			end++; // acquire more
		}
		return total_count;
	}
}
