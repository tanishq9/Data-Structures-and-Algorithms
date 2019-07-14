package HashMap;

import java.util.HashMap;

public class fourSumV2 {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		HashMap<Long, Integer> map1 = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				long sum = A[i] + B[j];
				map1.put(sum, map1.getOrDefault(sum, 0) + 1);
			}
		}
		int count = 0;
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				long sum = C[i] + D[j];
				if (map1.containsKey(-1 * sum)) {
					count += map1.get(-1 * sum);
				}
			}
		}
		return count;
	}
}
