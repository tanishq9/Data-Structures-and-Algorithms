package DynamicProgramming;

import java.util.List;

public class LongestCommonSubsequence {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int longestSubsequenceLength(final List<Integer> A) {
		if (A.isEmpty()) {
			return 0;
		}
		if (A.size() == 1) {
			return 1;
		}
		int[][] subseq = new int[A.size() + 1][A.size() + 1];
		int len = 0;
		for (int i = 0; i <= A.size(); i++) {
			for (int j = 0; j <= A.size(); j++) {
				if (i == 0 || j == 0) {
					subseq[i][j] = 0;
				} else if (A.get(i - 1) == A.get(j - 1)) {
					subseq[i][j] = subseq[i - 1][j - 1] + 1;
				} else {
					subseq[i][j] = Math.max(subseq[i - 1][j], subseq[i][j - 1]);
				}
			}
		}
		return subseq[A.size()][A.size()];
	}

}
