package DP_Pep;

import java.util.ArrayList;
import java.util.HashSet;

public class palindromicSubstrings {

	static HashSet<String> set = new HashSet<>();
	static ArrayList<String> list = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abaaa";
		System.out.println(ways(str));
		for (String s : set) {
			System.out.print(s + " ");
		}
		System.out.println(set.size());
		System.out.println();
		for (String s : list) {
			System.out.print(s + " ");
		}
	}

	private static int ways(String str) {
		boolean[][] strg = new boolean[str.length()][str.length()];
		// Meaning of strg[i][j] : whether string from i to j is palindrome or not
		int count = 0, longest = 0;
		for (int gap = 0; gap < str.length(); gap++) {
			for (int i = 0, j = i + gap; j < str.length(); i++, j++) {
				if (gap == 0) {
					strg[i][j] = true;
				} else if (gap == 1) {
					if (str.charAt(i) == str.charAt(j)) {
						strg[i][j] = true;
					}
				} else {
					if (str.charAt(i) == str.charAt(j) && strg[i + 1][j - 1] == true) {
						strg[i][j] = true;
					}
				}
				if (strg[i][j] == true) {
					count++;
					longest = gap + 1;
					set.add(str.substring(i, j + 1));
					list.add(str.substring(i, j + 1));
				}
			}
		}
		return count;
	}

}
