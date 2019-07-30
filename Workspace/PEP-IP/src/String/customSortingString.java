package String;

import java.util.Collections;
import java.util.TreeMap;

public class customSortingString {
	public static String customSortString(String S, String T) {
		TreeMap<Character, Integer> map = new TreeMap<>(Collections.reverseOrder());

		for (char cc : T.toCharArray()) {
			map.put(cc, map.getOrDefault(cc, 0) + 1);
		}

		char[] str = T.toCharArray();
		int index = 0;
		for (char cc : S.toCharArray()) {
			if (!map.containsKey(cc)) {
				continue;
			} else {
				int freq = map.get(cc);
				while (freq-- > 0) {
					str[index++] = cc;
				}
				map.remove(cc);
			}
		}

		for (char key : map.keySet()) {
			int freq = map.get(key);
			while (freq-- > 0) {
				str[index++] = key;
			}
		}

		return new String(str);
	}

	public static void main(String[] args) {
		System.out.println(customSortString("cba", "acbdoixxxxeqqq"));
	}
}
