package Strings;

import java.util.HashMap;
import java.util.Set;

public class maxfreq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "sttrrrriiinggg";
		int currentCount = 0, maxCount = 0;
		// O(n^2) Brute Force
		char maxChar = '0';
		for (int i = 0; i < string.length(); i++) {
			currentCount = 0;
			for (int j = 0; j < string.length(); j++) {
				if (string.charAt(i) == string.charAt(j)) {
					currentCount++;
				}
			}
			if (currentCount >= maxCount) {
				maxCount = currentCount;
				maxChar = string.charAt(i);
			}
		}
		System.out.println(maxChar + " " + maxCount);
		// 0(n) Time and Space
		HashMap<Character, Integer> hmap = new HashMap<>();
		for (int i = 0; i < string.length(); i++) {
			if (!hmap.containsKey(string.charAt(i))) {
				hmap.put(string.charAt(i), 1);
			} else {
				hmap.put(string.charAt(i), hmap.get(string.charAt(i)) + 1);
			}
		}
		char maxFreqChar = '0';
		int maxFreq = 0;
		Set<Character> set = hmap.keySet();
		for (Character c : set) {
			if (hmap.get(c) >= maxFreq) {
				maxChar = c;
				maxFreq = hmap.get(c);
			}
		}
		System.out.println(maxChar + " " + maxCount);
		// O(n) Time and O(1) space
		int mCount = 0, cCount = 0;
		char cChar = '0', mChar = '0', prevChar = string.charAt(0);
		for (int i = 0; i < string.length(); i++) {
			cChar = string.charAt(i);
			if (prevChar == cChar) {
				cCount++;
			} else {
				if (cCount >= mCount) {
					mCount = cCount;
					mChar = prevChar;
				}
				cCount = 1;
			}
			prevChar = cChar;
		}
		System.out.println(mChar + " " + mCount);
	}

}
