package HashMap;

import java.util.HashMap;

public class SmallestsubarrayWithMaxFreqElement {

	static class Tuple {
		int freq;
		int sp;
		int ep;

		Tuple(int ifreq, int isp, int iep) {
			this.freq = ifreq;
			this.sp = isp;
			this.ep = iep;
		}
	}

	public static void subarrAllOcc(int[] arr) {
		int n = arr.length;
		HashMap<Integer, Tuple> map = new HashMap<>();
		int mfstart = Integer.MAX_VALUE;
		int maxfreq = 0;
		int len = 0;
		for (int i = 0; i < n; i++) {
			int element = arr[i];
			if (!map.containsKey(element)) {
				map.put(element, new Tuple(1, i, i));
				if (i < mfstart) {
					len = 0;
					maxfreq = 1;
					mfstart = i;
				}
			} else {
				int freq = map.get(element).freq;
				int spe = map.get(element).sp;
				map.put(element, new Tuple(freq + 1, spe, i));
				if (freq > maxfreq && len < (i - spe)) {
					len = i - spe;
					maxfreq = freq;
					mfstart = spe;
				}
			}
		}
		for (int i = mfstart; i <= (mfstart + len); i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
