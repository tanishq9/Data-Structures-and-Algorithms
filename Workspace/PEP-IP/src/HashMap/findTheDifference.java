package HashMap;

import java.util.HashMap;

public class findTheDifference {
	public static char findTheDifference(String s, String t) {
		// write your code here.
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		for (int i = 0; i < t.length(); i++) {
			char ct = t.charAt(i);
			if (map.containsKey(ct)) {
				map.put(ct, map.get(ct) - 1);
				if (map.get(ct) == 0) {
					map.remove(ct);
				}
			} else {
				return ct;
			}
		}
		return 'X';
	}
}
