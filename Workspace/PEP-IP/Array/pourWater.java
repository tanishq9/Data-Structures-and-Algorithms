package Array;

public class pourWater {
	public static int[] pourWater(int[] heights, int v, int k) {
		for (int i = 0; i < v; i++) {
			int cur = k;// place where a drop of water is poured
			// Move left
			while (cur > 0 && heights[cur] >= heights[cur - 1]) {
				cur--;
			}
			// Move right
			while (cur < heights.length - 1 && heights[cur] >= heights[cur + 1]) {
				cur++;
			}
			// Move left to K
			while (cur > k && heights[cur] >= heights[cur - 1]) {
				cur--;
			}
			heights[cur]++;
		}

		return heights;

	}
}
