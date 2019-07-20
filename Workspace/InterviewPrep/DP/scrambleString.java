package DP;

public class scrambleString {
	public static void main(String[] args) {
		String str1 = "great";
		String str2 = "eatgr";
		System.out.println(areScrambled(str1, str2));
	}

	static boolean areScrambled(String str1, String str2) {
		int len = str1.length() == str2.length() ? str1.length() : -1;
		if (len == -1) {
			return false;
		}
		// dp[i][j][len] : string1 starting at 1, string2 starting at 2
		// and len is the length of the string we are considering
		boolean[][][] dp = new boolean[len][len][len + 1];
		for (int currLen = 1; currLen <= len; currLen++) {
			// Now fix the starting and the end point of strings
			for (int i = 0; i <= len - currLen; i++) {
				for (int j = 0; j <= len - currLen; j++) {
					if (currLen == 1) {
						dp[i][j][currLen] = str1.charAt(i) == str2.charAt(j);
					} else {
						// i,j,cut and i+cut,j+cut,currLen-cut || i,j+k-cut,cut and i+cut,j,currLen-cut
						for (int cut = 1; cut < currLen; cut++) {
							boolean f1 = dp[i][j][cut] && dp[i + cut][j + cut][currLen - cut];
							boolean f2 = dp[i][j + currLen - cut][cut] && dp[i + cut][j][currLen - cut];
							dp[i][j][currLen] = f1 || f2;
							// if once it will true , we will break otherwise it can become false later on
							// despite being true earlier
							if (dp[i][j][currLen] == true) {
								break;
							}
						}
					}
				}
			}
		}
		return dp[0][0][len];
	}
}
