package SubArray;

import java.util.HashMap;
import java.util.Scanner;

public class substringWithKDistinctChars {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			String str = sc.next();
			int k = sc.nextInt();
			System.out.println(minWindow(str, k));
		}
	}

	// O(N^2)
	public static int minWindow(String str, int k) {
		HashMap<Character, Integer> map = new HashMap<>();
		int substr_count = 0;
		int n = str.length();
		// Consider all substrings beginning with str[i]
		for (int i = 0; i < n; i++) {
			int distinct = 0;
			map.clear();
			for (int j = i; j < n; j++) {
				if (!map.containsKey(str.charAt(j))) {
					distinct++;
				}
				map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);
				if (distinct == k) {
					substr_count++;
				}
			}
		}
		return substr_count;
	}
}
