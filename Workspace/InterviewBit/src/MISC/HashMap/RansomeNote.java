package HashMap;

import java.util.HashMap;
import java.util.Map;

public class RansomeNote {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str1 = { "hello", "world", "hello" };
		String[] str2 = { "hello", "hello", "hello" };

		if (isRansomBuildPossible(str1, str2)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

	private static Boolean isRansomBuildPossible(String[] str1, String[] str2) {
		HashMap<String, Integer> magazine = getStringFrequency(str1);
		HashMap<String, Integer> note = getStringFrequency(str2);
		return hasEnoughWords(magazine, note);
	}

	private static HashMap<String, Integer> getStringFrequency(String[] str1) {
		HashMap<String, Integer> map = new HashMap<>();
		for (String entry : str1) {
			if (!map.containsKey(entry)) {
				map.put(entry, 1);
			} else {
				map.put(entry, map.get(entry) + 1);
			}
		}
		return map;
	}

	private static Boolean hasEnoughWords(HashMap<String, Integer> magazine, HashMap<String, Integer> note) {
		for (Map.Entry<String, Integer> entry : note.entrySet()) {
			String word = entry.getKey();
			if (!magazine.containsKey(word) || magazine.get(word) < entry.getValue()) {
				return false;
			}
		}
		return true;
	}

}
