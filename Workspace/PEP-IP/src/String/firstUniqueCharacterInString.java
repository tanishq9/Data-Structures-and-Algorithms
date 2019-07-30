package String;

public class firstUniqueCharacterInString {
	public int firstUniqChar(String s) {
		Pair[] freq = new Pair[26];
		for (int i = 0; i < 26; i++) {
			freq[i] = new Pair(0, -1);
		}
		for (int i = 0; i < s.length(); i++) {
			// Increment the count
			freq[s.charAt(i) - 'a'].count++;
			// Update the first occurrence
			if (freq[s.charAt(i) - 'a'].firstOccurrence == -1) {
				freq[s.charAt(i) - 'a'].firstOccurrence = i;
			}
		}
		int index = Integer.MAX_VALUE;
		for (int i = 0; i < 26; i++) {
			if (freq[i].count == 1) {
				index = Math.min(index, freq[i].firstOccurrence);
			}
		}
		if (index == Integer.MAX_VALUE) {
			return -1;
		}
		return index;
	}

	class Pair {
		int count;
		int firstOccurrence;

		Pair(int ic, int io) {
			this.count = ic;
			this.firstOccurrence = io;
		}
	}
}
