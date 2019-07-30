package Array;

public class productExceptSelf {
	public int[] productExceptSelf_ON_space(int[] arr) {
		// O(n) space approach
		int n = arr.length;
		// Stores the product of numbers before the ith index;excluding the current
		int[] leftProductList = new int[n];
		// Stores the product of numbers after the ith index;excluding the current
		int[] rightProductList = new int[n];
		// Building the left list
		leftProductList[0] = 1;
		for (int i = 1; i < n; i++) {
			leftProductList[i] = leftProductList[i - 1] * arr[i - 1];
		}
		// Building the right list
		rightProductList[n - 1] = 1;
		for (int i = n - 2; i >= 0; i--) {
			rightProductList[i] = rightProductList[i + 1] * arr[i + 1];
		}
		int[] excludingProductList = new int[n];
		for (int i = 0; i < n; i++) {
			excludingProductList[i] = leftProductList[i] * rightProductList[i];
		}
		return excludingProductList;
	}

	public int[] productExceptSelf_O1_Space(int[] arr) {
		int n = arr.length;
		int[] excludingProductList = new int[n];
		excludingProductList[0] = 1;
		for (int i = 1; i < n; i++) {
			excludingProductList[i] = excludingProductList[i - 1] * arr[i - 1];
		}
		int r = 1;
		for (int i = n - 1; i >= 0; i--) {
			excludingProductList[i] *= r;
			r *= arr[i];
		}
		return excludingProductList;
	}
}
