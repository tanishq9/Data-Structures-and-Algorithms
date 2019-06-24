package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class keyBoardRow {
	public static String[] findWords(String[] words) {

		// Write your code here
		String[] strs = { "QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM" };
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			String str = strs[i];
			for (char cc : str.toCharArray()) {
				map.put(cc, i);
			}
		}
		List<String> list = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			int rn = map.get(word.toUpperCase().charAt(0));
			boolean flag = true;
			for (char cc : word.toUpperCase().toCharArray()) {
				if (map.get(cc) != rn) {
					flag = false;
					break;
				}
			}
			if (flag == true) {
				list.add(word);
			}
		}
		if (list.size() == 0) {
			return new String[] { "" };
		}
		return list.toArray(new String[0]);
	}
}
