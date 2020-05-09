package BinarySearch;

import java.util.Scanner;

public class _KillingSpree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			long n = sc.nextInt();
			long ans = -1;
			long s = 1, e = n;
			while (s <= e) {
				long mid = (s + e) / 2;
				if (((mid + 1) * (2 * mid + 1)) > 6 * n / mid) {
					e = mid - 1;
				} else {
					ans = mid;
					s = mid + 1;
				}
			}
			System.out.println(ans);
		}
	}
}
