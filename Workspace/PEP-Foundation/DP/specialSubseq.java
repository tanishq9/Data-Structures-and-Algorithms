package DP;

public class specialSubseq {

	public static void main(String[] args) {
		String str = "abcabc";
		System.out.println(countSubseq(str));
	}

	private static int countSubseq(String str) {
		int[] table = new int[3];
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a') {
				table[0] = 1 + 2 * table[0];
			} else if (str.charAt(i) == 'b') {
				table[1] = table[0] + 2 * table[1];
			} else if (str.charAt(i) == 'c') {
				table[2] = table[1] + 2 * table[2];
			}
		}

		return table[2];
	}

}
