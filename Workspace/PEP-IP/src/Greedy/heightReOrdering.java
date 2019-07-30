package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class heightReOrdering {
	public int[][] reconstructQueue(int[][] people) {
		if (people == null || people.length == 0 || people[0].length == 0) {
			return new int[0][0];
		}
		// sort on heigh decreasing manner and on k in increasing manner
		Arrays.sort(people, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] > b[0]) {
					return -1;
				} else if (a[0] < b[0]) {
					return 1;
				} else {
					return a[1] - b[1];
				}
			}
		});

		LinkedList<int[]> list = new LinkedList<>();
		for (int i = 0; i < people.length; i++) {
			// index,value
			list.add(people[i][1], people[i]);
		}

		int[][] res = new int[people.length][2];
		int idx = 0;
		for (int[] a : list) {
			res[idx++] = a;
		}

		return res;
	}
}
