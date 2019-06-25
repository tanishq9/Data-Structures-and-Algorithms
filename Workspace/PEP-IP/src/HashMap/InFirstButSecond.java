package HashMap;

import java.util.HashSet;

public class InFirstButSecond {
	public static void solve(long a[], long b[], int n, int m) {
		// Write your code here
		HashSet<Long> set = new HashSet<>();
		for (long i : a) {
			set.add(i);
		}
		for (long i : b) {
			if (set.contains(i)) {
				set.remove(i);
			}
		}
		for (long i : a) {
			if (set.contains(i)) {
				System.out.print(i + " ");
			}
		}
	}
}
