package Array;

public class containerMaxStorage {
	public int maxArea(int[] height) {
		int i = 0; // left bound
		int j = height.length - 1; // right bound
		int max = 0;
		while (i < j) {
			max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
			if (height[i] < height[j]) {
				i++;
			} else if (height[i] == height[j]) {
				i++;
				j--;
			} else if (height[i] > height[j]) {
				j--;
			}
		}
		return max;
	}
}
