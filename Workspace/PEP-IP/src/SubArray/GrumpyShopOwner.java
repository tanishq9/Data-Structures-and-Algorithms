package SubArray;

public class GrumpyShopOwner {
	public int maxSatisfied(int[] customers, int[] grumpy, int X) {
		int start = 0, end = 0, max = 0;
		int contribution = 0;
		while (end < grumpy.length) {
			if (grumpy[end] == 1) {
				contribution += customers[end];
			}
			if ((end - start + 1) == X) {
				// 0 2 2 3 1 6
				max = Math.max(max, contribution);
				if (grumpy[start] == 1) {
					contribution -= customers[start];
				}
				start++;
			}
			end++;
		}
		for (int i = 0; i < customers.length; i++) {
			if (grumpy[i] == 0) {
				max += customers[i];
			}
		}
		return max;
	}
}
