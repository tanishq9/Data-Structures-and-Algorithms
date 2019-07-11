package BinarySearch;

public class _ArrangingCoins {
	public int arrangeCoins(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		long ln = (long) n;
		long left = 0;
		long right = ln;
		long ans = -1;
		// 1 + 2 + 3 + .... + x < n => x*(x+1)/2<=n
		while (left <= right) {
			long mid = left + (right - left) / 2;
			if ((mid + 1) > 2 * ln / mid) {
				right = mid - 1;
			} else {
				ans = mid;
				left = mid + 1;
			}
		}
		return (int) ans;
	}
}
