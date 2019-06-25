package Misc;

import java.util.ArrayList;
import java.util.List;

public class commonCharacters {
	class Solution {
		public List<String> commonChars(String[] A) {
			int[] freqCommon = new int[26];
			for (char cc : A[0].toCharArray()) {
				freqCommon[cc - 'a']++;
			}
			int[] freqCurrent = new int[26];
			for (int i = 1; i < A.length; i++) {
				// Re-init for further strings
				freqCurrent = new int[26];
				for (char cc : A[i].toCharArray()) {
					freqCurrent[cc - 'a']++;
				}
				// Find common
				for (int j = 0; j < 26; j++) {
					freqCommon[j] = Math.min(freqCommon[j], freqCurrent[j]);
				}
			}
			List<String> result = new ArrayList<>();
			for (int i = 0; i < 26; i++) {
				if (freqCommon[i] != 0) {
					int freq = freqCommon[i];
					while (freq-- > 0) {
						result.add((char) (i + 'a') + "");
					}
				}
			}
			return result;
		}
	}
}
