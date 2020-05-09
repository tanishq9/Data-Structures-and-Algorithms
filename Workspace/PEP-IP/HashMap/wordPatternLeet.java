package HashMap;

import java.util.HashMap;

public class wordPatternLeet {
	static Boolean wordPattern(String pattern, String str) {
		String[] arr = str.split(" ");
		if (arr.length != pattern.length()) {
			return false;
		}
		HashMap<Character, String> map = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++) {
			char cc = pattern.charAt(i);
			if (map.containsKey(cc)) {
				if (!map.get(cc).equals(arr[i])) {
					return false;
				}
			} else {
				if (map.containsValue(arr[i])) {
					return false;
				}
				map.put(cc, arr[i]);
			}
		}
		return true;
	}
}
