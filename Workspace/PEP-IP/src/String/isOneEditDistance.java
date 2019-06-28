package String;

public class isOneEditDistance {
	public static boolean is1EditDistance(String s, String t) {
		// write your code here.
		int[] f1 = new int[26];
		int[] f2 = new int[26];
		for (char cc : s.toCharArray()) {
			f1[cc - 'a']++;
		}
		for (char cc : t.toCharArray()) {
			f2[cc - 'a']++;
		}
		if (s.length() > t.length()) {
			for (int i = 0; i < 26; i++) {
				f1[i] -= f2[i];
			}
			int cn1 = 0;
			for (int i = 0; i < 26; i++) {
				// For removals
				if (f1[i] > 1) {
					return false;
				} else if (f1[i] == 1) { // For replacements
					cn1++;
					if (cn1 > 1) {
						return false;
					}
				}
			}
			if (cn1 == 1) {
				return true;
			}
			return false;
		} else {
			for (int i = 0; i < 26; i++) {
				f1[i] -= f2[i];
			}
			int cn1 = 0;
			for (int i = 0; i < 26; i++) {
				// For removals
				if (f1[i] > 1) {
					return false;
				} else if (f1[i] == 1) { // For replacements
					cn1++;
					if (cn1 > 1) {
						return false;
					}
				}
			}
			if (cn1 == 1) {
				return true;
			}
			return false;
		}
	}

	public static boolean isOneEditDistanceAlter(String s, String t) {

		for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
			if (s.charAt(i) != t.charAt(i)) {

				if (s.length() == t.length()) {

					return s.substring(i + 1).equals(t.substring(i + 1));

				} else if (s.length() < t.length()) {

					return s.substring(i).equals(t.substring(i + 1));

				} else {

					return t.substring(i).equals(s.substring(i + 1));

				}
			}
		}

		return Math.abs(s.length() - t.length()) == 1;

	}
}
