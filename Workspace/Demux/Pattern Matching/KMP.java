static int[] getLPS(String pattern) {
		int[] lps = new int[pattern.length()];
		// i and j are start and end pointer (2 pointer technique)
		int i = 0, j = 1;
		// lps[i] tells longest suffix that is also a prefix till index i
		// lps[0] = 0 always because there is no 'proper' suffix which
		// is also 'proper' prefix of length 0
		while (j < pattern.length()) {
			if (pattern.charAt(i) == pattern.charAt(j)) {
				lps[j] = i + 1;
				i++;
				j++;
			} else {
				if (i != 0) {
					// look for the bubble in the i-1 array
					// bubble contains the longest proper prefix that is also longest proper suffix
					// by 'that is also' we mean they are both equal
					i = lps[i - 1];
				} else {
					// i is at 0 and still no between char at i and char at j, so increment j
					// it is obvious but we can also write this : lps[j] = 0;
					j++;
				}
			}
		}
		return lps;
	}

	static void kmp(String text, String pattern) {
		int[] lps = getLPS(pattern);
		System.out.println(Arrays.toString(lps));
		int i = 0, j = 0;
		while (i < text.length()) {
			while (i < text.length() && j < pattern.length() && text.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			}
			if (j == pattern.length()) {
				// if complete pattern is found
				System.out.println(i - j);
				// set j=0 and look for both possible matches
				j = lps[j - 1];
			} else {
				// if there's a mismatch
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
				// j will move to that index in the pattern
				// that skip past redudant / already checked indexes
			}
		}
	}

	public static void main(String[] args) {
		String text = "aabaaabaaac";// "adsgwadsxdsgwadsgz" ;
		String pattern = "aabaaac";// "dsgwadsgz";
		kmp(text, pattern);
	}