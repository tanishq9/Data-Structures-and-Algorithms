package DP;

public class uniqueSubstringsInWrapAround {
	public int findSubstringInWraproundString(String s) {
		if (s.length() == 0) {
			return 0;
		}
		int[] count = new int[26];
		// count[i] is the maximum unique substring end with ith letter
		int n = s.length();
		int maxLen = 1;
		count[s.charAt(0) - 'a'] = 1;
		for (int i = 1; i < s.length(); i++) {
			// zab : z 1(z) za 2(a,za) zab 3(b,ab,azb)
			if (s.charAt(i) - s.charAt(i - 1) == 1 || s.charAt(i - 1) - s.charAt(i) == 25) {
				maxLen++;
			} else {
				maxLen = 1;
			}
			int index = s.charAt(i) - 'a';
			count[index] = Math.max(count[index], maxLen);
		}
		int sum = 0;
		for (int i : count) {
			sum += i;
		}
		return sum;
	}
}
