package Strings;

public class editDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "aggb";
		String str2 = "acfv";
		System.out.println(editDistance(str1, str2));
	}

	private static int editDistanceDP(String str1, String str2) {
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];
		for (int i = str1.length(); i >= 0; i++) {
			for (int j = str2.length(); j >= 0; j++) {
				if (i == str1.length()) {
					dp[i][j] = str2.length() - j;
					continue;
				}
				if (j == str2.length()) {
					dp[i][j] = str1.length() - i;
					continue;
				}
				if (str1.charAt(i) == str2.charAt(j)) {
					dp[i][j] = dp[i + 1][j + 1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i + 1][j + 1], Math.min(dp[i + 1][j], dp[i][j + 1]));
				}
			}
		}
		return dp[0][0];
	}

	private static int editDistance(String str1, String str2) {
		if (str1.length() == 0) {
			return str2.length();
		}
		if (str2.length() == 0) {
			return str1.length();
		}
		String ros1 = str1.substring(1);
		String ros2 = str2.substring(1);
		char cc1 = str1.charAt(0);
		char cc2 = str2.charAt(0);
		if (cc1 == cc2) {
			return editDistance(ros1, ros2);
		} else {
			int isReplaced = editDistance(ros1, ros2);
			int isAdd = editDistance(ros1, str2);
			int isRemove = editDistance(str1, ros2);
			return 1 + Math.min(isReplaced, Math.min(isRemove, isAdd));
		}

	}

}
