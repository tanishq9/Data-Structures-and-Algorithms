package HashMap;

import java.util.Scanner;
import java.util.TreeSet;

public class justSmallerOnLeft {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			int x[] = new int[N];
			for (int i = 0; i < N; i++) {
				x[i] = sc.nextInt();
			}
			justSmallerLeft(x);
		}
	}

	static void justSmallerLeft(int[] arr) {
		TreeSet<Integer> ts = new TreeSet<>();
		for (int i = 0; i < arr.length; i++) {
			ts.add(arr[i]);
			if (ts.lower(arr[i]) != null) {
				System.out.print(ts.lower(arr[i]) + " ");
			} else {
				System.out.print("-1 ");
			}
		}
		System.out.println();
	}
}