package HashMap;

import java.util.HashMap;

public class validateAlienDictionary {
	public boolean isAlienSorted(String[] words, String order) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < order.length(); i++) {
			map.put(order.charAt(i), i);
		}
		for (int i = 0; i < words.length - 1; i++) {
			String word1 = words[i];
			String word2 = words[i + 1];
			int len = Math.min(word1.length(), word2.length());
			int w1 = 0, w2 = 0;
			boolean flag = false;
			while (w1 < len && w2 < len) {
				if (map.get(word1.charAt(w1)) > map.get(word2.charAt(w2))) {
					return false;
				} else if (map.get(word1.charAt(w1)) < map.get(word2.charAt(w2))) {
					flag = true;
					break;
				} else {
					w1++;
					w2++;
				}
			}
			if (word1.length() > word2.length() && flag == false) {
				return false;
			}
		}
		return true;
	}
}
