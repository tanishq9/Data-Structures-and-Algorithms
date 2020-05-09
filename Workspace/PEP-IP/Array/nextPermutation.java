package Array;

import java.util.Arrays;

public class nextPermutation {
	public void nextPermutation_Leet(int[] arr) {
		int n = arr.length;
		int i1 = -1, i2 = -1;
		for (int i = n - 1; i >= 1; i--) {
			if (arr[i - 1] < arr[i]) {
				i1 = i - 1;
				break;
			}
		}
		if (i1 == -1) {
			Arrays.sort(arr);
			return;
		}
		for (int i = n - 1; i >= i1; i--) {
			if (arr[i] > arr[i1]) {
				i2 = i;
				break;
			}
		}
		// swap
		int temp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = temp;
		// reverse
		reverse(arr, i1 + 1, n - 1);
	}

	void reverse(int[] arr, int s, int e) {
		while (s <= e) {
			int temp = arr[s];
			arr[s] = arr[e];
			arr[e] = temp;
			s++;
			e--;
		}
	}
}
