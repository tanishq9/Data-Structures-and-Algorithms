package Arr;

public class sortBinaryArr {

	public static void main(String[] args) {
		int[] ar = { 0, 0, 1, 0, 1, 0, 1, 1 };
		minSwaps(ar, ar.length);
	}

	private static void minSwaps(int[] arr, int len) {
		int[] countZeros = new int[len];
		int i, count = 0;
		countZeros[len - 1] = 1 - arr[len - 1];

		for (i = len - 2; i >= 0; i--) {
			countZeros[i] = countZeros[i + 1];
			if (arr[i] == 0) {
				countZeros[i]++;
			}
		}

		for (i = 0; i < len; i++) {
			System.out.print(countZeros[i] + " ");
		}
		System.out.println();
		for (i = 0; i < len; i++) {
			if (arr[i] == 1) {
				count += countZeros[i];
			}
		}
		System.out.println(count);
	}
}
