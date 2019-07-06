package BinarySearch;

public class T1_arrangeCoins {
	public int arrangeCoins(int n) {
		long ln = (long) n;
		long left = 0;
		long right = ln;
		long ans = -1;
		// 1 + 2 + 3 + .... + x < n => x*(x+1)/2<=n
		while (left <= right) {
			long mid = left + (right - left) / 2;
			if (mid * (mid + 1) > 2 * ln) {
				right = mid - 1;
			} else {
				ans = mid;
				left = mid + 1;
			}
		}
		return (int) ans;
	}
}
