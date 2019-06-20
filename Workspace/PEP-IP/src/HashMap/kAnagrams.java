package HashMap;

public class kAnagrams {
	boolean areKAnagrams(String str1, String str2, int k) {
		if (str1.length() != str2.length()) {
			return false;
		}
		int[] freq = new int[26];
		for (int i = 0; i < str1.length(); i++) {
			freq[str1.charAt(i) - 'a']++;
		}
		for (int i = 0; i < str2.length(); i++) {
			freq[str2.charAt(i) - 'a']--;
		}

		int diff = 0; // different elements
		for (int i = 0; i < 26; i++) {
			if (freq[i] > 0) {
				diff += freq[i];
			}
		}
		return diff <= k;
	}
}
