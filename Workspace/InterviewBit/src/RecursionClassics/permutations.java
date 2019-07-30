package RecursionClassics;

import java.util.ArrayList;

public class permutations {

	private static ArrayList<String> list = null;

	public static void main(String[] args) {
		String str = "abc";
		list = new ArrayList<>();
		permute(str, 0);
		for (String s : list) {
			System.out.print(s + " ");
		}
	}

	// Very easy code just dry run it once.
	private static void permute(String str, int i) {
		if (i == str.length()) {
			list.add(str);
			return;
		}

		for (int j = i; j < str.length(); j++) {
			// We swap the elements at i and j
			str = swap(str, i, j);
			permute(str, i + 1);
			str = swap(str, i, j);
			// This is the backtracking step
			// It swaps back the char at i and j index to reach the previous state
		}
	}

	private static String swap(String str, int i, int j) {
		char ch[] = str.toCharArray();
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
		str = String.valueOf(ch);
		return str;
	}
}
