package HashMap;

import java.util.HashSet;

public class pairsWithGivenRelation {
	public static int solve(int[] arr) {
		// write your code here.
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int prod = arr[i] * arr[j];
				if (set.contains(prod)) {
					return 1;
				} else {
					set.add(prod);
				}
			}
		}

		return -1;
	}

}
