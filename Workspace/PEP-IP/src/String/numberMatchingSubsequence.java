package String;

import java.util.HashMap;
import java.util.LinkedList;

public class numberMatchingSubsequence {
	public int numMatchingSubseq(String S, String[] words) {
		HashMap<Character, LinkedList<String>> map = new HashMap<>();
		// for every character
		for (char cc = 'a'; cc <= 'z'; cc++) {
			map.put(cc, new LinkedList<String>());
		}
		// init the map for parallel string matching
		for (String word : words) {
			map.get(word.charAt(0)).addLast(word);
		}
		int count = 0;
		// traverse the main string and update map
		for (int i = 0; i < S.length(); i++) {
			char cc = S.charAt(i);
			LinkedList<String> list = map.get(cc);
			int size = list.size();
			while (size-- > 0) {
				String word = list.removeFirst();
				if (word.length() == 1) {
					count++;
					System.out.println(word);
				} else {
					map.get(word.charAt(1)).addLast(word.substring(1));
				}
			}

		}
		return count;
	}
}
