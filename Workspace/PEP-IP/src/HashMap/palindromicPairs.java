package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class palindromicPairs {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] words = new String[n];
		for (int i = 0; i < n; i++) {
			words[i] = sc.next();
		}
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(words[i], i);
		}
		int count = 0;
		// if map contains ""
		if (map.containsKey("")) {
			int blankIdx = map.get("");
			for (int i = 0; i < words.length; i++) {
				if (isPalindrome(words[i])) {
					if (i == blankIdx) {
						continue;
					}
					count += 2;
				}
			}
		}
		// find all reverse string pairs
		for (int i = 0; i < n; i++) {
			String revstr = rev(words[i]);
			if (map.containsKey(revstr)) {
				int found = map.get(revstr);
				if (found == i) {
					continue;
				}
				count++;
			}
		}
		// find cut pairs
		for (int i = 0; i < n; i++) {
			String curr = words[i];
			for (int cut = 1; cut < curr.length(); cut++) {
				if (isPalindrome(curr.substring(0, cut))) {
					String cut_r = rev(curr.substring(cut));
					if (map.containsKey(cut_r)) {
						int found = map.get(cut_r);
						if (found == i) {
							continue;
						}
						count++;
					}
				}
				if (isPalindrome(curr.substring(cut))) {
					String cut_r = rev(curr.substring(0, cut));
					if (map.containsKey(cut_r)) {
						int found = map.get(cut_r);
						if (found == i) {
							continue;
						}
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}

	static String rev(String str) {
		StringBuilder sb = new StringBuilder(str);
		return sb.reverse().toString();
	}

	static boolean isPalindrome(String word) {
		int i = 0;
		int j = word.length() - 1;
		while (i <= j) {
			if (word.charAt(i) != word.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
