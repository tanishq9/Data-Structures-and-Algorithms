package BinarySearch;

public class T2_KokoBananas {
	public int minEatingSpeed(int[] piles, int H) {
		// 3+4+2+7+3+7+3+1
		// 0 to 27 12 1 + 1 + 1 + 2
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < piles.length; i++) {
			max = Math.max(max, piles[i]);
		}
		int left = 0;
		int right = max;
		// mid is the number of bananas eaten at every hour
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (isPoss(mid, H, piles)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		// left==right
		return left;
	}

	public boolean isPoss(int mid, int H, int[] piles) {
		for (int val : piles) {
			H -= (int) Math.ceil(val * (1.0 / mid));
		}
		return H >= 0;
	}

	boolean valid(int[] piles, int mid, int H) {
		int count = 0;
		for (int num : piles) {
			if (num <= mid) {
				count++;
			} else {
				while (num > 0) {
					num -= mid;
					count++;
				}
			}
		}
		if (count <= H) {
			return true;
		} else {
			return false;
		}
	}
}
