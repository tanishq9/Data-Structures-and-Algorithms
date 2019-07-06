package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class countOfSubstringHavingSameFirstandLastCharacter {
	public static int count(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			char cc = str.charAt(i);
			if (map.containsKey(cc)) {
				count += map.get(cc);
			}
			map.put(cc, map.getOrDefault(cc, 0) + 1);
		}
		return count + str.length();
	}

	// Don't write your code here
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int ans = count(str);
		System.out.println(ans);
	}
}
