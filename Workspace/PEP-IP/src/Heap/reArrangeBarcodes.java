package Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class reArrangeBarcodes {
	public int[] rearrangeBarcodes(int[] barcodes) {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			public int compare(int[] f, int[] s) {
				return s[1] - f[1];
			}
		});
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < barcodes.length; i++) {
			map.put(barcodes[i], map.getOrDefault(barcodes[i], 0) + 1);
		}
		for (int key : map.keySet()) {
			pq.add(new int[] { key, map.get(key) });
		}
		int index = 0;
		while (pq.size() >= 2) {
			int[] t1 = pq.remove();
			int[] t2 = pq.remove();
			barcodes[index++] = t1[0];
			barcodes[index++] = t2[0];
			t1[1]--;
			t2[1]--;
			if (t1[1] > 0) {
				pq.add(new int[] { t1[0], t1[1] });
			}
			if (t2[1] > 0) {
				pq.add(new int[] { t2[0], t2[1] });
			}
		}
		if (pq.size() != 0) {
			barcodes[index++] = pq.remove()[0];
		}
		return barcodes;
	}
}
