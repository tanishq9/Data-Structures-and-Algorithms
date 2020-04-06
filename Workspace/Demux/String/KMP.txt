
public class KMP {

	static void computeLPS(String p, int[] lps) {
		// i and j are start and end pointer
		int i = 0;
		int j = 1;
		// lps[i] tells longest suffix that is also a prefix till index i
		lps[0] = 0;
		while (j < p.length()) {
			// if there's a match
			if (p.charAt(j) == p.charAt(i)) {
				lps[j] = lps[j - 1] + 1;
				i++;
				j++;
			}
			// if there's not a match
			else {
				if (i != 0) {
					i = lps[i - 1];
				} else {
					// start afresh
					lps[j] = 0;
					j++;
				}
			}
		}
		System.out.println(Arrays.toString(lps));
	}

	public static void match(String s, String p) {
		int[] lps = new int[p.length()];
		computeLPS(p, lps);
		int i = 0; // index of original string
		int j = 0; // index of pattern string
		while (i < s.length()) {
			if (s.charAt(i) == p.charAt(j)) {
				i++;
				j++;
			}
			if (j == p.length()) {
				System.out.println("Pattern found at : " + (i - j));
				j = lps[j - 1];
			}
			// mismatch after j matches
			else if (s.charAt(i) != p.charAt(j)) {
				if (j > 0) {
					j = lps[j - 1];
				} else {
					// start afresh
					i += 1;

				}
			}
		}
	}

	public static void main(String[] args) {
		match("adsgwadsxdsgwadsgz", "dsgwadsgz");
	}
}
