package HashMap;

import java.util.HashMap;

public class winnerElection {
	public static String[] func(String[] arr) {

		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		int max = 0;
		String winner = "";
		for (String key : map.keySet()) {
			if (max < map.get(key)) {
				max = map.get(key);
				winner = key;
			} else if (max == map.get(key)) {
				if (key.compareTo(winner) < 0) {
					winner = key;
				}
			}
		}
		return new String[] { winner };
	}
}
