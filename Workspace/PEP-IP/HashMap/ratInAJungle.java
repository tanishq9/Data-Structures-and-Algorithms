package HashMap;

import java.util.HashMap;

public class ratInAJungle {
	public static int numRats(int[] answers) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int ans = 0;
		for (int i : answers) {
			if (i == 0) {
				ans += 1;
				continue;
			} else if (!map.containsKey(i)) {
				ans += (i + 1);
				map.put(i, 1);
			} else if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
				if (map.get(i) == (i + 1)) {
					map.remove(i);
				}
			}
		}
		return ans;
	}
}
