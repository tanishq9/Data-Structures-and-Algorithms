package SubArray;

import java.util.HashMap;

public class longestSubstringWithoutRepeatingCharacaters {
	public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		boolean valid = true;
		int start = 0; // for releasing
		int end = 0; // for acquiring
		int max = 0;
		while (end < s.length()) {
			char cend = s.charAt(end);
			map.put(cend, map.getOrDefault(cend, 0) + 1);
			if (map.get(cend) > 1) {
				valid = false;
			}
			if (valid == true) {
				max = Math.max(max, end - start + 1);
			}
			while (valid == false) {
				// start releasing from start
				char cbegin = s.charAt(start);
				// make the window valid again
				if (cbegin == cend) {
					valid = true;
				}
				// only consider characters in that window
				// delete past records
				map.put(cbegin, map.get(cbegin) - 1);
				// narrow down the window
				start++;
			}
			end++;
		}
		return max;
	}
}
