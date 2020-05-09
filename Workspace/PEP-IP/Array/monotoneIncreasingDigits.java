package Array;

public class monotoneIncreasingDigits {
	public int monotoneIncreasingDigits_LeetCode(int N) {
		char[] arr = String.valueOf(N).toCharArray();
		int j = arr.length - 1;
		for (int i = arr.length - 1; i >= 1; i--) {
			if (arr[i] < arr[i - 1]) {
				arr[i - 1]--;
				j = i - 1;
			}
		}
		j += 1;
		while (j < arr.length) {
			arr[j++] = '9';
		}
		return Integer.valueOf(new String(arr));

	}
}
