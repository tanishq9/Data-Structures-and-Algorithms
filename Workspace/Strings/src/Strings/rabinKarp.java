package Strings;

public class rabinKarp {

	public static int d = 256;
	public static int q = 11;

	public static void search(String pattern, String text) {
		int n = pattern.length();
		int m = text.length();
		int i, j;
		int q = 11;
		int h = (int) (Math.pow(d, pattern.length() - 1) % q);
		int p = 0;// hash code of the pattern
		int t = 0;// hash code of the text
		// get the initial pattern from the text
		for (i = 0; i < pattern.length(); i++) {
			p = (d * p + pattern.charAt(i)) % q;
			t = (d * t + text.charAt(i)) % q;
		}
		// use the rolling back hash function
		for (i = 0; i < text.length() - pattern.length() + 1; i++) {
			if (p == t) {
				// then check char by char
				for (j = 0; j < pattern.length(); j++) {
					if (pattern.charAt(j) != text.charAt(i + j)) {
						break;
					}
				}
				if (j == pattern.length()) {
					System.out.println("Pattern Found");
					return;
				}
			}
			if (i < m - n) {
				t = (d * (t - text.charAt(i) * h) + text.charAt(i + pattern.length()));
				t = t % q;
				if (t < 0) {
					t = t + q;
				}
			}
		}
		System.out.println("No match found");
	}

	public static void main(String[] args) {
		String text = "abc";
		String pattern = "bc";
		search(pattern, text);
	}
}
