package Strings;

public class decodings {

	public static void main(String[] args) {
		String s = "12345";
		int[] memo = new int[s.length() + 1];
		for (int i = 0; i < memo.length; i++) {
			memo[i] = -1;
		}
		System.out.println(numDecodings(s, s.length(), memo));
	}

	private static int numDecodings(String s, int k, int[] memo) {
		if (k == 0) {
			return 1;
		}
		int startingIndex = s.length() - k;
		if ((int) s.charAt(startingIndex) == 0) {
			return 0;
		}
		if (memo[k] != -1) {
			return memo[startingIndex];
		}
		int result = numDecodings(s, k - 1, memo);
		if (k >= 2 && Integer.parseInt(s.substring(startingIndex, startingIndex + 2)) <= 26) {
			result += numDecodings(s, k - 2, memo);
		}
		memo[k] = result;
		return result;
	}

}
