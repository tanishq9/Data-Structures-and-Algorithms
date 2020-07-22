package RecursionClassics;

import java.util.ArrayList;

public class keypadCodesInList {

	String[] str = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public ArrayList<String> letterCombinations(String A) {
		ArrayList<String> list = new ArrayList<>();
		keypadStrings(A, "", 0, 0, list);
		return list;
	}

	private void keypadStrings(String in, String out, int i, int j, ArrayList<String> list) {
		if (i >= in.length()) {
			list.add(out);
			return;
		}
		int digit = in.charAt(i) - '0';
		for (int k = 0; k < str[digit].length(); k++) {
			keypadStrings(in, out + str[digit].charAt(k), i + 1, j + 1, list);
		}
		return;
	}
}
