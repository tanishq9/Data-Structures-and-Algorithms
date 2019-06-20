package HashMap;

import java.util.HashMap;

public class isIsogram {
	public static boolean isIsogram(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			if (map.containsKey(str.charAt(i))) {
				return false;
			} else {
				map.put(str.charAt(i), 1);
			}
		}
		return true;
	}
}
