package Misc;

public class uncommonElementFREQARRAY {
	public static void uncommon(String str1, String str2) {
		// Write your code here
		int[] freq = new int[26];
		for (char cc : str1.toCharArray()) {
			int idx = cc - 'a';
			freq[idx] = 1;
		}
		for (char cc : str2.toCharArray()) {
			int idx = cc - 'a';
			if (freq[idx] == 1) {
				freq[idx] = -1;
			} else {
				if (freq[idx] != -1) {
					freq[idx] = 2;
				}
			}
		}
		for (int idx = 0; idx < 26; idx++) {
			if (freq[idx] == 1 || freq[idx] == 2) {
				System.out.print((char) (idx + 'a'));
			}
		}
	}

}
