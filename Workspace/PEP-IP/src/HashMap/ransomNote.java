package HashMap;

public class ransomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
		int[] freqnote = new int[26];
		int[] freqmag = new int[26];
		for (char cc : ransomNote.toCharArray()) {
			freqnote[cc - 'a']++;
		}
		for (char cc : magazine.toCharArray()) {
			freqmag[cc - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			freqnote[i] -= freqmag[i];
		}
		for (int i = 0; i < 26; i++) {
			if (freqnote[i] > 0) {
				return false;
			}
		}
		return true;
	}
}
