package PatternMatching;

public class ZAlgo {

	public static void main(String[] args) {
		String str = "bacabbdbbabbcbabbcd";
		String pattern = "abbc";
		String c = pattern + "#" + str;
		int[] zarray = new int[c.length()];
		fillZarray(c, zarray);
		for (int i = 0; i < zarray.length; i++) {
			if (zarray[i] == pattern.length()) {
				System.out.println(i);
			}
		}
	}

	public static void fillZarray(String str, int[] zarray) {
		int i = 1;
		int l = 0;
		int r = 0;
		while (i < zarray.length) {
			if (i > r) {
				l = r = i;
				while (i < str.length() && str.charAt(r) == str.charAt(r - l)) {
					r++;
				}
				r--;
				zarray[l] = r - l + 1;
			} else {
				int k = i - l;
				if (zarray[k] < r - i + 1) {
					zarray[i] = zarray[k];
				} else {
					l = r = i;
					while (i < str.length() && str.charAt(r) == str.charAt(r - l)) {
						r++;
					}
					r--;
					zarray[l] = zarray[r - l + 1];
				}
			}
			i++;
		}
	}

}
