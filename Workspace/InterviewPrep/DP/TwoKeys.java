package DP;

public class TwoKeys {
	public int minSteps(int n) {
		int ans = 0;
		for (int i = 2; i * i <= n; i++) {
			while (n % i == 0) {
				n /= i;
				ans += i;
			}
		}
		if (n != 1) {
			return ans + n;
		}
		return ans;
	}
}
