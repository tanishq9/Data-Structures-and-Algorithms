package HashMap;

import java.util.HashMap;
import java.util.Set;

public class Matches {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "give me one grand today night";
		String s2 = "give one grand today";
		System.out.println(isMatching(s1, s2));
	}

	static Boolean isMatching(String s1, String s2) {
		HashMap<String, Integer> hmap = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != ' ') {
				sb.append(s1.charAt(i));
			} else if (s1.charAt(i) == ' ') {
				while (i < s1.length() && s1.charAt(i) == ' ') {
					i++;
				}
				if (hmap.containsKey(sb.toString())) {
					hmap.put(sb.toString(), hmap.get(sb.toString()) + 1);
				} else {
					hmap.put(sb.toString(), 1);
				}
				sb.setLength(0);
				i--;
			}
		}
		// For the last word
		if (hmap.containsKey(sb.toString())) {
			hmap.put(sb.toString(), hmap.get(sb.toString()) + 1);
		} else {
			hmap.put(sb.toString(), 1);
		}
		sb.setLength(0);

		for (int i = 0; i < s2.length(); i++) {
			if (s2.charAt(i) != ' ') {
				sb.append(s2.charAt(i));
			} else if (s2.charAt(i) == ' ') {
				while (i < s1.length() && s2.charAt(i) == ' ') {
					i++;
				}
				if (hmap.containsKey(sb.toString())) {
					hmap.put(sb.toString(), hmap.get(sb.toString()) - 1);
					if (hmap.get(sb.toString()) < 0) {
						return false;
					}
				} else if (!hmap.containsKey(sb.toString())) {
					return false;
				}
				sb.setLength(0);
				i--;
			}
		}
		if (hmap.containsKey(sb.toString())) {
			hmap.put(sb.toString(), hmap.get(sb.toString()) - 1);
			if (hmap.get(sb.toString()) < 0) {
				return false;
			}
		} else if (!hmap.containsKey(sb.toString())) {
			return false;
		}

		return true;
	}

}
