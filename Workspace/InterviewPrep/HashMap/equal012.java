package HashMap;

import java.util.HashMap;

public class equal012 {
	public static void equal_012(String line) {
		int count0 = 0, count1 = 0, count2 = 0, ans = 0;
		HashMap<String, Integer> map = new HashMap<>();
		map.put("0,0", 1);
		for (int i = 0; i < line.length(); i++) {
			char cc = line.charAt(i);
			if (cc == '0') {
				count0++;
			} else if (cc == '1') {
				count1++;
			} else if (cc == '2') {
				count2++;
			}
			String pair = (count0 - count1) + "," + (count0 - count2);
			if (map.containsKey(pair)) {
				ans += map.get(pair);
				map.put(pair, map.get(pair) + 1);
			} else {
				map.put(pair, 1);
			}
		}
		System.out.print(ans);
	}
}
