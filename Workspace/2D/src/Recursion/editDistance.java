package Recursion;

public class editDistance {

	public static void main(String[] args) {
		System.out.println(edit("abcd", "adc"));
	}

	private static int edit(String str1, String str2) {
		if (str1.length() == 0) {
			return str2.length();
		}
		if (str2.length() == 0) {
			return str1.length();
		}
		if (str1.charAt(0) == str2.charAt(0)) {
			return edit(str1.substring(1), str2.substring(1));
		}
		int substitue = 1 + edit(str1.substring(1), str2.substring(1));
		int insert = 1 + edit(str1, str2.substring(1));
		int remove = 1 + edit(str1.substring(1), str2);
		return Math.min(substitue, Math.min(remove, insert));
	}

}
