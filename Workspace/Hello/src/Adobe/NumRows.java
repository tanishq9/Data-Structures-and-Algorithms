package Adobe;

import java.util.HashMap;

public class NumRows {

	private static int numRows(int n) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int k = 0;
		for (int i = 1; i <= n; ) {
			k += 1;
			int num_points = k;
			while (num_points != 0 && i <= n) {
				map.put(i, k);
				num_points--;
				i++;
			}
		}
		for(int i:map.keySet()) {
			System.out.println(i+" "+map.get(i));
		}
		return map.get(n);
	}

	public static void main(String[] args) {
		int n = 10;
		System.out.println(numRows(n));
	}

}
