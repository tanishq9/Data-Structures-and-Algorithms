package String;

public class decodeStringAtIndex {
	public String decodeAtIndex(String S, int k) {
		long size = 0;
		// length of decoded string
		for (int i = 0; i < S.length(); i++) {
			char cc = S.charAt(i);
			if (Character.isDigit(cc)) {
				size *= (cc - '0');
			} else {
				size++;
			}
		}
		// smart work
		for (int i = S.length() - 1; i >= 0; i--) {
			char cc = S.charAt(i);
			k %= size; // keep updating k
			if (k == 0 && Character.isLetter(cc)) {
				return cc + "";
			}
			if (Character.isDigit(cc)) {
				size /= cc - '0';
			} else {
				size--;
			}
		}
		return "";
	}
}
