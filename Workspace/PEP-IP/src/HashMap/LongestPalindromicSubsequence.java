package HashMap;

import java.util.HashMap;

public class LongestPalindromicSubsequence {
	public int longestPalindrome(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (char cc : s.toCharArray()) {
			map.put(cc, map.getOrDefault(cc, 0) + 1);
		}
		int len = 0;
		boolean flag = false;
		for (char key : map.keySet()) {
			int freq = map.get(key);
			if (freq % 2 == 0) {
				len += freq;
			} else {
				flag = true;
				len += (freq - 1);
			}
		}
		if (flag == true) {
			len += 1;
		}
		return len;
	}
}
