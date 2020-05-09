package Arr;

public class equlibiriumpoint {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 3 };
		int reqI = 0;
		Boolean flag = false;
		// o(n2) approacj
		for (int i = 0; i < arr.length; i++) {
			int leftSum = 0;
			for (int j = 0; j < i; j++) {
				leftSum += arr[j];
			}
			int rightSum = 0;
			for (int k = i + 1; k < arr.length; k++) {
				rightSum += arr[k];
			}
			if (leftSum == rightSum) {
				flag = true;
				reqI = i;
			}
		}

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		int leftS = 0;
		for (int i = 0; i < arr.length; i++) {
			sum -= arr[i];
			if (leftS == sum) {
				flag = true;
			}
			leftS += arr[i];
		}
		System.out.println(reqI);
	}

}
