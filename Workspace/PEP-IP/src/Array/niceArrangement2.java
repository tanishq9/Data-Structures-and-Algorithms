package Array;

public class niceArrangement2 {
	public static int[] constructArray(int n, int k) {
		// write your code here.
		int[] arr = new int[n];
		int c = 0;
		for (int i = 1; i < n - k; i++) {
			arr[c++] = i;
		}
		// remaining k+1 elements
		// /2 because voh mera ek block hai head tail ka
		for (int i = 0; i <= k; i++) {
			// head
			if (i % 2 == 0) {
				arr[c++] = n - k + i / 2; // head value grows in size
			} else {
				// tail
				arr[c++] = n - i / 2; // tail value decreases in size
			}
		}
		return arr;
	}
}
