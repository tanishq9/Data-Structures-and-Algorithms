package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class pairSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int sum = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(count(arr, sum));
		}
	}

	static int count(int[] arr, int sum) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		int pairs = 0;
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(sum - arr[i])) {
				pairs += map.get(sum - arr[i]);
			}
			if (arr[i] == (sum - arr[i])) {
				pairs--;
			}
		}
		return pairs / 2;
	}
}
