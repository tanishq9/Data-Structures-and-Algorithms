package HashMap;

import java.util.HashMap;

public class largestFreqChar {

	public static void main(String[] args) {
		String word = "hello";
		lfc(word);
	}

	private static void lfc(String word) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < word.length(); i++) {
			char cc = word.charAt(i);
			if (map.containsKey(cc)) {
				map.put(cc, map.get(cc) + 1);
			} else {
				map.put(cc, 1);
			}
		}
		char lfchar = word.charAt(0);
		int lf = 1;
		for (Character key : map.keySet()) {
			if (map.get(key) > lf) {
				lf = map.get(key);
				lfchar = key;
			}
		}
		System.out.println(lfchar + " " + lf);
	}

}
