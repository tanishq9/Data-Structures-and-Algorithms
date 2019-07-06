package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class groupShiftedANAGRAMS {
	public static List<List<String>> groupStrings(String[] strs) {
		// write your code here.
		HashMap<String, List<String>> map = new HashMap<>();
		if (strs.length == 0)
			return new ArrayList();

		// O(n*log(n)) : To maintain lexographical order
		// O(n)
		for (String str : strs) {
			// Build the key from by using difference in frequency
			String key = "";
			for (int i = 1; i < str.length(); i++) {
				key += (str.charAt(i) - str.charAt(i - 1) + 26) % 26;
				key += "#";
				// ? otherwise abc and al would mean the same i.e 12
				// but 1#2# is not same as 12# , therefore add seperator between diff in ascii
			}

			// Search then add/update the map
			if (map.containsKey(key)) {
				List<String> list = map.get(key);
				list.add(str);
				map.put(key, list);
			} else {
				List<String> list = new ArrayList<>();
				list.add(str);
				map.put(key, list);
			}
		}
		List<List<String>> result = new ArrayList<>();
		for (String key : map.keySet()) {
			result.add(map.get(key));
		}
		return result;
	}
}
