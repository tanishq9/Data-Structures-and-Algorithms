package PatternMatching;

import java.util.ArrayList;

public class KMP {

	private static ArrayList<Integer> getLPS(String pat) {
		ArrayList<Integer> lps = new ArrayList<>();
		for (int i = 0; i < pat.length(); i++) {
			lps.add(0);
		}
		int i = 1;
		int l = 0;
		while (i < pat.length()) {
			if (pat.charAt(i) == pat.charAt(l)) {
				lps.set(i, l + 1);
				i++;
				l++;
			} else {
				if (l > 0) {
					l = lps.get(l - 1);
				} else {
					i++;
				}
			}
		}
		return lps;
	}

	public static void kmp(String src, String pat) {
		ArrayList<Integer> lps = getLPS(pat);
		int i = 0;
		int j = 0;
		while (i < src.length()) {
			if (src.charAt(i) == pat.charAt(j)) {
				i++;
				j++;
				if (j == pat.length()) {
					System.out.print("Pattern Found at ");
					System.out.println(i-j);
					j = lps.get(j - 1);
				}
			} else {
				if (j > 0) {
					j = lps.get(j - 1);
				} else {
					i++;
				}
			}
		}
	}

	public static void main(String[] args) {
		String src = "abaababaab";
		String pattern = "abaab";
		kmp(src, pattern);
	}

}
