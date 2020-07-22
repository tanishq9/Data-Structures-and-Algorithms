package Arr;

import java.util.ArrayList;

public class PowerSum {
	static int power(int x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}
		if (n % 2 == 1) {
			return x * power(x, n - 1);
		} else {
			return power(x, n / 2) * power(x, n / 2);
		}
	}

	static int binarySearch(int x, int n) {
		int left = 0, right = x, mid, res = 0;
		while (left <= right) {
			mid = (left + right) / 2;
			int pow = power(mid, n);
			if (pow == x) {
				return mid;
			} else if (pow < x) {
				res = mid;
				left = mid + 1;
			} else if (pow > x) {
				right = mid - 1;
			}
		}
		return res;
	}

	static Boolean bitMasks(int i, int[] arr, int x, int n) {
		int index = 1;
		ArrayList<Integer> list = new ArrayList<>();
		while (i > 0) {
			if ((i & 1) == 1) {
				list.add(arr[index]);
			}
			index++;
			i = i >> 1;
		}
		int sum = 0;
		for (Integer item : list) {
			sum += power(item, n);
		}
		// System.out.println(sum);
		if (sum == x) {
			return true;
		}
		return false;
	}

	// Complete the powerSum function below.
	static int powerSum(int X, int N) {
		int max_kaha_tak_jayega = binarySearch(X, N);
		// System.out.println(max_kaha_tak_jayega);
		int[] arr = new int[max_kaha_tak_jayega + 1];
		for (int i = 0; i < max_kaha_tak_jayega + 1; i++) {
			arr[i] = i;
		}
		int range = 1 << (max_kaha_tak_jayega);
		// System.out.println(range);
		int count = 0;
		for (int i = 0; i < range; i++) {
			if (bitMasks(i, arr, X, N)) {
				// System.out.println(i);
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(powerSum(800, 2));
	}

}
