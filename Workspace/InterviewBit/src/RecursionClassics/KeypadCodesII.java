package RecursionClassics;

public class KeypadCodesII {

	static String[] strarr = { "", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };

	public static void main(String[] args) {
		String str = "23";
		printKeypadString(str, "", 0, 0);
	}

	static void printKeypadString(String in, String out, int i, int j) {
		// Base Case
		if (i == in.length()) {
			System.out.println(out);
			String s = String.valueOf(out);
			return;
		}
		// Recursive Case
		int digit = in.charAt(i) - '0';
		for (int k = 0; k < strarr[digit].length(); k++) {
			printKeypadString(in, out + strarr[digit].charAt(k), i + 1, j + 1);
		}

	}

}
