package Misc;

public class decodeStringAtIndex {
	public String decodeAtIndex(String S, int k) {
		long size = 0;
		for (char cc : S.toCharArray()) {
			if (Character.isDigit(cc)) {
				size *= (cc - '0');
			} else {
				size++;
			}
		}
		System.out.println(size);
		for (int i = S.length() - 1; i >= 0; i--) {
			char cc = S.charAt(i);
			// update k everytime as it can become greater than size
			k %= size; // don't write k=k%size kyuki typecast karna padh jayega
			// aur usse galat answer aayega
			if (Character.isDigit(cc)) {
				size /= (cc - '0');
			} else {
				if (k == 0 && Character.isLetter(cc)) {
					return Character.toString(cc);
				} else {
					size--;
				}
			}
		}
		return "";
	}
}
