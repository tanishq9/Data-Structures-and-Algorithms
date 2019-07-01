package SubArray;

public class numBoundedMaximum {
	public int numSubarrayBoundedMax(int[] arr, int L, int R) {
		int start = 0;
		int end = 0;
		int count = 0;
		int total = 0;
		while (end < arr.length) {

			if (L <= arr[end] && arr[end] <= R) {
				total += (end - start + 1);
				count = (end - start + 1);
				end++;
				continue;
			} else if (arr[end] < L) {
				total += count;
				end++;
				continue;
			} else {
				start = end + 1;
				end++;
				count = 0;
				continue;
			}
		}
		return total;
	}
}
