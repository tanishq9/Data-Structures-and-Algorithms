package Recursion;

import java.util.ArrayList;

public class keypadArrayList {

	static String[] codes = { "", "abc", "def", "ghi", "jkl", "mno", "pqr", "st", "uvwx", "yz" };

	public static void main(String[] args) {
		String str = "123";
		getCodes(str, "");
		ArrayList<String> result = getKCodes(str);
		System.out.println(result);
	}

	public static ArrayList<String> getKCodes(String str) {
		if (str.length() == 0) {
			ArrayList<String> baseResult = new ArrayList<>();
			baseResult.add("");
			return baseResult;
		}
		String ros = str.substring(1);
		ArrayList<String> rr = getKCodes(ros);
		ArrayList<String> mr = new ArrayList<>();
		for (String s : rr) {
			int idx = str.charAt(0) - '0';
			for (int i = 0; i < codes[idx].length(); i++) {
				mr.add(codes[idx].charAt(i) + s);
			}
		}
		return mr;
	}

	public static void getCodes(String str, String asf) {
		if (str.length() == 0) {
			System.out.println(asf);
			return;
		}
		char cc = str.charAt(0);
		int idxcc = cc - '0';
		for (int i = 0; i < codes[idxcc].length(); i++) {
			getCodes(str.substring(1), asf + codes[idxcc].charAt(i));
		}
	}

}
