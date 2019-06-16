package HashMap;

import java.util.Scanner;
import java.util.TreeMap;

public class RelativeSorting {
	// O(N) + O(M*LOG(M))
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] arr1 = new int[n];
			int[] arr2 = new int[m];
			for (int i = 0; i < n; i++) {
				arr1[i] = sc.nextInt();
			}
			for (int i = 0; i < m; i++) {
				arr2[i] = sc.nextInt();
			}
			sort(arr1, arr2);
			System.out.println();
		}
	}

	static void sort(int[] arr1, int[] arr2) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		// O(n)
		for (int i = 0; i < arr1.length; i++) {
			map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
		}
		int index = 0;
		// O(m*log(m))
		for (int i : arr2) {
			if (!map.containsKey(i)) {
				continue;
			}
			int n = map.get(i);
			while (n-- > 0) {
				arr1[index++] = i;
			}
			map.remove(i);
		}
		// O(remaining_elements*(log(remaining_elements)))
		for (int i : map.keySet()) {
			int n = map.get(i);
			while (n-- > 0) {
				arr1[index++] = i;
			}
		}
		for (int i : arr1) {
			System.out.print(i + " ");
		}
	}
}
