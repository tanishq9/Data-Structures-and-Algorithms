package String;

public class longestCharacterReplacement {
	public static int characterReplacement(String s, int k) {
		// Write your code here
		int[] freq = new int[26];
		int start = 0, end = 0, maxCount = 0, maxLen = 0;
		while (end < s.length()) {
			maxCount = Math.max(maxCount, ++freq[s.charAt(end) - 'A']);
			// till the window is invalid start releasing characters from start
			while (end - start + 1 - maxCount > k) {
				freq[s.charAt(start) - 'A']--;
				start++; // releasing character
			}
			// valid window length
			maxLen = Math.max(maxLen, end - start + 1);
			// Acquire more characters
			end++;
		}
		return maxLen;
	}
}
