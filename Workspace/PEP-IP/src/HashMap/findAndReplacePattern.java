package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class findAndReplacePattern {
	public List<String> findAndReplacePattern(String[] words, String pattern) {
		List<String> result = new ArrayList<String>();
		for (String word : words) {
			if (isMatch(word, pattern)) {
				result.add(word);
			}
		}
		return result;
	}

	boolean isMatch(String word, String pattern) {
		if (word.length() != pattern.length()) {
			return false;
		}
		HashMap<Character, Character> map = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++) {
			if (!map.containsKey(pattern.charAt(i))) {
				// Already that character is mapped by some other char
				if (map.containsValue(word.charAt(i))) {
					return false;
				}
				// Else establish a key
				map.put(pattern.charAt(i), word.charAt(i));
			} else {
				char cc = map.get(pattern.charAt(i));
				if (cc != word.charAt(i)) {
					return false;
				}
			}
		}
		return true;
	}

}
