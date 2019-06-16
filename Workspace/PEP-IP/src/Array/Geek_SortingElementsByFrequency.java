package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Geek_SortingElementsByFrequency {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			HashMap<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				if (map.containsKey(arr[i])) {
					map.put(arr[i], map.get(arr[i]) + 1);
				} else {
					map.put(arr[i], 1);
				}
			}
			ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
			Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
				public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
					if (e1.getValue() > e2.getValue()) {
						return -1;
					} else if (e1.getValue() < e2.getValue()) {
						return 1;
					} else {
						return e1.getKey() > e2.getKey() ? 1 : -1;
					}
				}
			});
			for (Map.Entry<Integer, Integer> entry : list) {
				int freq = entry.getValue();
				while (freq-- > 0) {
					System.out.print(entry.getKey() + " ");
				}
			}
			System.out.println();
		}
	}
}
