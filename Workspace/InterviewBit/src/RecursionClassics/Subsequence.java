package RecursionClassics;

import java.util.ArrayList;

public class Subsequence {

	private static ArrayList<String> list = null;

	public static void main(String[] args) {
		String str = "abc";
		list = new ArrayList<>();
		genSubseq(str, "");
		for (String s : list) {
			System.out.print(s + " ");
		}
	}

	public static void genSubseq(String str, String result) {
		if (str.length() == 0) {
			list.add(result);
			return;
		}
		char cc = str.charAt(0);
		// Consider one time
		genSubseq(str.substring(1), result);
		// Do not consider other time
		genSubseq(str.substring(1), result + cc);
	}
}
