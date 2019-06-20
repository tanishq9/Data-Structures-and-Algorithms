package SubArray;

import java.util.HashSet;
import java.util.Scanner;

public class distinctSubstringLength2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			String str = sc.next();
			System.out.println(disub(str));
		}
	}

	// O(N^2)
	public static int disub(String str) {
		HashSet<String> set = new HashSet<>();
		int n = str.length();
		// Consider all substrings beginning with str[i]
		for (int i = 0; i < n; i++) {
			String s = "";
			for (int j = i; j < n; j++) {
				s += str.charAt(j);
				if (s.length() == 2) {
					set.add(s);
				}
			}
		}
		return set.size();
	}
}
