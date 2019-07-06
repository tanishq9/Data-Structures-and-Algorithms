package HashMap;

import java.util.HashMap;

public class LongestSubstringHavingKUniqueCharacters {
	public static int longest(String str, int k) {
		HashMap<Character, Integer> map = new HashMap<>();
		int max_len = 0;
		int maxs = 0;
		int maxe = 0;
		int end = 0;
		int start = 0;
		boolean valid = true;
		while (end < str.length()) {
			// Acquiring process
			char cend = str.charAt(end);
			map.put(cend, map.getOrDefault(cend, 0) + 1);
			// Update maximum length if valid
			if (map.size() == k) {
				if (max_len < end - start + 1) {
					max_len = end - start + 1;
					maxs = start;
					maxe = end;
				}
			}
			if (map.size() > k) {
				valid = false;
			}
			// Check for invalid and start releasing characters till it becomes valid
			while (valid == false) {
				char cstart = str.charAt(start);
				map.put(cstart, map.get(cstart) - 1);
				if (map.get(cstart) == 0) {
					map.remove(cstart);
				}
				if (map.size() == k) {
					valid = true;
				}
				start++;
			}
			// Acquire more
			end++;
		}
		System.out.println(maxs + " " + maxe);
		return max_len;
	}

	public static void main(String[] args) {
		String str = "abbccdaacbddagaafaggfcdahag";
		System.out.println(longest(str, 3));
	}
}
