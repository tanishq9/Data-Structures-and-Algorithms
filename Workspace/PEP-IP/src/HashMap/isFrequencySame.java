package HashMap;

public class isFrequencySame {
	static boolean isSame(int[] freq) {
		int same = 0;
		for (int i = 0; i < 26; i++) {
			if (freq[i] > 0) {
				same = i;
				break;
			}
		}
		for (int i = same; i < 26; i++) {
			if (freq[i] > 0 && freq[i] != freq[same]) {
				return false;
			}
		}
		return true;
	}

	public static boolean isFrequencyEqual(String str) {
		int[] freq = new int[26];
		// Build frequency array
		for (int i = 0; i < str.length(); i++) {
			freq[str.charAt(i) - 'a']++;
		}
		if (isSame(freq)) {
			return true;
		}
		// check if removal of any single element make it equal
		for (int i = 0; i < 26; i++) {
			if (freq[i] > 0) {
				freq[i]--;
				if (isSame(freq)) {
					return true;
				}
				// didn't work , try for some other character
				freq[i]++;
			}
		}
		return false;
	}

}
